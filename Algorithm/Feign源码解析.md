

## Feign源码解析

### 简介

`OpenFeign`是声明性Web服务客户端，使用`Feign`可以像调用本地服务一样实现远程接口调用.

`OpenFeign` 内置了 `Ribbon`，用来实现客户端的负载均衡

`OpenFeign`支持 `SpringMVC`的注解，支持可插拔的编码器和解码器

`OpenFeign` 涉及到两个注解 `@EnableFeignClient` 和 `FeignClient`

- `@EnableFeignClient` : 用于开启 `Feign`
- `FeignClient` 标注`Feign`请求的接口



### 分析

使用`OpenFeign`必须在主启动类上加上`@EnableFeignClients`， 用来标注支持`Feign`的使用

#### @EnableFeignClients

`@EnableFeignClient` 中导入了 `FeignClientsRegistrar`。

```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
// 导入配置类
@Import(FeignClientsRegistrar.class)
public @interface EnableFeignClients {
	
	String[] value() default {}; // basePackages的别名

	String[] basePackages() default {}; // 指定被@FeignClient注解注释的接口所在的包的包名

	Class<?>[] basePackageClasses() default {}; // 指定被@FeignClient注解注释的接口所在的包的包名集合

	Class<?>[] defaultConfiguration() default {}; // 默认配置

	Class<?>[] clients() default {}; // @FeignClient注解注释的接口集合
}
```



#### FeignClientsRegistrar

`FeignClientsRegistrar`是一个注册器， 通过扫描特定的类，将Bean注入到Sprig中

此类继承了实现了 `ImportBeanDefinitionRegistrar` 实现了 `registerBeanDefinitions`方法，实现`Bean`的动态注入

##### registerBeanDefinitions

` registerBeanDefinitions `是`feign`的核心方法，进行配置注册和`bean`的注入

```java
class FeignClientsRegistrar
		implements ImportBeanDefinitionRegistrar, ResourceLoaderAware, EnvironmentAware {
    ....
    
    @Override
    public void registerBeanDefinitions(AnnotationMetadata metadata,
                                        BeanDefinitionRegistry registry) {
        // 进行配置的注册
        registerDefaultConfiguration(metadata, registry);
        // 
        registerFeignClients(metadata, registry);
    }
}
```

##### registerDefaultConfiguration

`registerDefaultConfiguration` 方法内部从 `SpringBoot` 启动类上检查是否有`@EnableFeignClients`, 有该注解的话， 则完成 一些配置内容

```java
private void registerDefaultConfiguration(AnnotationMetadata metadata,
			BeanDefinitionRegistry registry) {
    // 扫描标注EnableFeignClients注解，获取该注解下的属性
    Map<String, Object> defaultAttrs = metadata
        .getAnnotationAttributes(EnableFeignClients.class.getName(), true);

    if (defaultAttrs != null && defaultAttrs.containsKey("defaultConfiguration")) {
        String name;
        if (metadata.hasEnclosingClass()) {
            name = "default." + metadata.getEnclosingClassName();
        }
        else {
            name = "default." + metadata.getClassName();
        }
        // 执行注册
        registerClientConfiguration(registry, name,
                                    defaultAttrs.get("defaultConfiguration"));
    }
}

private void registerClientConfiguration(BeanDefinitionRegistry registry, Object name,
			Object configuration) {
    // 加载FeignClientSpecification的bean
    BeanDefinitionBuilder builder = BeanDefinitionBuilder
        .genericBeanDefinition(FeignClientSpecification.class);
    builder.addConstructorArgValue(name);
    builder.addConstructorArgValue(configuration);
    
    // 将BeanDefinition添加到注册到FeignClientSpecification中
    registry.registerBeanDefinition(
        name + "." + FeignClientSpecification.class.getSimpleName(),
        builder.getBeanDefinition());
}
```

##### registerFeignClients

 此方法负责扫描标注`@EnableFeignClients`注解的类，并获取需要扫描的包名 ，然后将该包下的所有标注`FeignClient`注解的接口，解析成`Bean`注入到`Spring`容器中

```java
public void registerFeignClients(AnnotationMetadata metadata,
                                 BeanDefinitionRegistry registry) {
    // 获取scanner扫描器
    ClassPathScanningCandidateComponentProvider scanner = getScanner();
    scanner.setResourceLoader(this.resourceLoader);

    Set<String> basePackages;

    Map<String, Object> attrs = metadata
        .getAnnotationAttributes(EnableFeignClients.class.getName());
    // 为FeignClient注解创建一个Filter
    AnnotationTypeFilter annotationTypeFilter = new AnnotationTypeFilter(
        FeignClient.class);
    // 在@EnableFeignClients中获取获取客户端的值
    final Class<?>[] clients = attrs == null ? null
        : (Class<?>[]) attrs.get("clients");
    if (clients == null || clients.length == 0) {
        // FeignClient过滤器添加到扫描器中
        scanner.addIncludeFilter(annotationTypeFilter);
        // 得到包, 如果不配置默认为SpringbootApplication同路径的包
        basePackages = getBasePackages(metadata);
    }
    else {
        final Set<String> clientClasses = new HashSet<>();
        basePackages = new HashSet<>();
        for (Class<?> clazz : clients) {
            basePackages.add(ClassUtils.getPackageName(clazz));
            clientClasses.add(clazz.getCanonicalName());
        }
        AbstractClassTestingTypeFilter filter = new AbstractClassTestingTypeFilter() {
            @Override
            protected boolean match(ClassMetadata metadata) {
                String cleaned = metadata.getClassName().replaceAll("\\$", ".");
                return clientClasses.contains(cleaned);
            }
        };
        scanner.addIncludeFilter(
            new AllTypeFilter(Arrays.asList(filter, annotationTypeFilter)));
    }

    // 遍历配置的扫描包路径
    for (String basePackage : basePackages) {
        // 获取@FeignClient修饰的接口
        Set<BeanDefinition> candidateComponents = scanner
            .findCandidateComponents(basePackage);
        for (BeanDefinition candidateComponent : candidateComponents) {
            if (candidateComponent instanceof AnnotatedBeanDefinition) {
                AnnotatedBeanDefinition beanDefinition = (AnnotatedBeanDefinition) candidateComponent;
                AnnotationMetadata annotationMetadata = beanDefinition.getMetadata();
                Assert.isTrue(annotationMetadata.isInterface(),
                              "@FeignClient can only be specified on an interface");

                Map<String, Object> attributes = annotationMetadata
                    .getAnnotationAttributes(
                    FeignClient.class.getCanonicalName());

                String name = getClientName(attributes);
                registerClientConfiguration(registry, name,
                                            attributes.get("configuration"));

                  // 注册Feign客户端，是用factorybean，FeignClientFactoryBean
                registerFeignClient(registry, annotationMetadata, attributes);
            }
        }
    }
}

// registerFeignClient 在这个方法中，就是去组装BeanDefinition，也就是Bean的定义，然后注册到Spring IOC容器
private void registerFeignClient(BeanDefinitionRegistry registry,
			AnnotationMetadata annotationMetadata, Map<String, Object> attributes) {
    // 获取标注FeignClient注解的接口名称
    String className = annotationMetadata.getClassName();
    
    // 使用BeanDefinitionBuilder构建bean：FeignClientBuilder
    // FeignClientFactoryBean重要
    BeanDefinitionBuilder definition = BeanDefinitionBuilder
        .genericBeanDefinition(FeignClientFactoryBean.class);
    validate(attributes);
    
    // 添加FeignClientFactoryBean的各个属性
    definition.addPropertyValue("url", getUrl(attributes));
    definition.addPropertyValue("path", getPath(attributes));
    String name = getName(attributes);
    definition.addPropertyValue("name", name);
    String contextId = getContextId(attributes);
    definition.addPropertyValue("contextId", contextId);
    definition.addPropertyValue("type", className);
    definition.addPropertyValue("decode404", attributes.get("decode404"));
    definition.addPropertyValue("fallback", attributes.get("fallback"));
    definition.addPropertyValue("fallbackFactory", attributes.get("fallbackFactory"));
    definition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);

    // 设置别名
    String alias = contextId + "FeignClient";
    AbstractBeanDefinition beanDefinition = definition.getBeanDefinition();

    boolean primary = (Boolean) attributes.get("primary"); // has a default, won't be
    // null

    beanDefinition.setPrimary(primary);

    String qualifier = getQualifier(attributes);
    if (StringUtils.hasText(qualifier)) {
        alias = qualifier;
    }

    BeanDefinitionHolder holder = new BeanDefinitionHolder(beanDefinition, className,
                                                           new String[] { alias });
  	// 注册FeignClientFactoryBean
    
    
    BeanDefinitionReaderUtils.registerBeanDefinition(holder, registry);
}

```

#### FeignClientFactoryBean

![](C:\Users\Ben\Desktop\images\diagram.png)

实现了`FactoryBean`接口，实现了 `getObject`、`getObjectType`、`isSingleton` 方法， 实现了`InitializingBean`的`afterPropertiesSet`方法；实现了`ApplicationContextAware`的`setApplicationContext`方法 

1、通过调用`getObject` 方法调用 `getTarget`方法

2、从`applicationContext`中拿到`FeignContext`，`FeignContext` 是在自动配置注入到Spring容器中的

3、调用`feign`方法从`FeignContext`获取`Feign.Builder`构建器， 包含了日志，编码解码器，解析

4、判断接口是否配置了`URL`，如果`URL`为空，则走负载均衡，否则生成默认的代理类

5、` targeter.target` 生成代理对象

```java
<T> T getTarget() {
    FeignContext context = this.applicationContext.getBean(FeignContext.class);
    Feign.Builder builder = feign(context);

    if (!StringUtils.hasText(this.url)) {
        if (!this.name.startsWith("http")) {
            this.url = "http://" + this.name;
        }
        else {
            this.url = this.name;
        }
        this.url += cleanPath();
        return (T) loadBalance(builder, context,
                               new HardCodedTarget<>(this.type, this.name, this.url));
    }
    if (StringUtils.hasText(this.url) && !this.url.startsWith("http")) {
        this.url = "http://" + this.url;
    }
    String url = this.url + cleanPath();
    Client client = getOptional(context, Client.class);
    if (client != null) {
        if (client instanceof LoadBalancerFeignClient) {
            // not load balancing because we have a url,
            // but ribbon is on the classpath, so unwrap
            client = ((LoadBalancerFeignClient) client).getDelegate();
        }
        if (client instanceof FeignBlockingLoadBalancerClient) {
            // not load balancing because we have a url,
            // but Spring Cloud LoadBalancer is on the classpath, so unwrap
            client = ((FeignBlockingLoadBalancerClient) client).getDelegate();
        }
        builder.client(client);
    }
    Targeter targeter = get(context, Targeter.class);
    return (T) targeter.target(this, builder, context,
                               new HardCodedTarget<>(this.type, this.name, url));
}


protected Feign.Builder feign(FeignContext context) {
    FeignLoggerFactory loggerFactory = get(context, FeignLoggerFactory.class);
    Logger logger = loggerFactory.create(this.type);

    // @formatter:off
    Feign.Builder builder = get(context, Feign.Builder.class)
        // required values
        .logger(logger)
        .encoder(get(context, Encoder.class))
        .decoder(get(context, Decoder.class))
        .contract(get(context, Contract.class));
    // @formatter:on

    configureFeign(context, builder);

    return builder;
}
```

#### 代理过程

