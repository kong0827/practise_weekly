## 一、平均分组问题（Java实现）

#### 题目

按分数对选手进行平均分组，可分多组。

注意：

1. 输入的选手名单players为集合形式，player表示选手名称，score表示选手的分数
2. 选手的分数体现选手的实力，分数有可能是负数
3. 最终解不是唯一，但要求分组后，每组的实力尽量接近，每组的人数也尽量接近

例如：
将所有选手，总共7人

```
[
    {
        "player": "a",
        "score": 22
    },
    {
        "player": "b",
        "score": -9
    },
    {
        "player": "c",
        "score": 13
    },
    {
        "player": "d",
        "score": 17
    },
    {
        "player": "e",
        "score": 0
    },
    {
        "player": "f",
        "score": -11
    },
    {
        "player": "g",
        "score": -2
    }
]
```

1、如果分成两组，应该是4 VS 3 的队形

```json
[
  [
    {
      "player": "a",
      "score": 22
    },
    {
      "player": "e",
      "score": 0
    },
    {
      "player": "g",
      "score": -2
    },
    {
      "player": "f",
      "score": -11
    }
  ],
  [
    {
      "player": "d",
      "score": 17
    },
    {
      "player": "c",
      "score": 13
    },
    {
      "player": "b",
      "score": -9
    }
  ]
]
```

2、如果分成三组，应该是3 VS 2 VS 2的队形

```json
[
  [
    {
      "player": "a",
      "score": 22
    },
    {
      "player": "b",
      "score": -9
    },
    {
      "player": "f",
      "score": -11
    }
  ],
  [
    {
      "player": "c",
      "score": 13
    },
    {
      "player": "e",
      "score": 0
    }
  ],
  [
    {
      "player": "d",
      "score": 17
    },
    {
      "player": "g",
      "score": -2
    }
  ]
]
```



​	不知道大家第一次看到这代题目时候，是怎么想的。请大家先想一下，不要着急看我的思路和代码，这样容易顺着我的思路走，应该有自己的思路与想法，如果没有，再参考我的解决思路。

**********************



#### 解题思路：

​	首先可以确定的是这道题是有可能无法得到最优解的，只能得到一个接近最优解的解或最优解。

  + 1、 先按照选手的分数按照正序或者倒叙进行排序，我这里按照倒叙排列。 

  + 2、 求出所有选手的总分数，然后求出平均数。 

  + 3、 将选手分成两组，例如组一，组二，然后用组一的分值最小的选手去和组二中分值最大的选手进行交换

  + 4、如果交换后组一的总分数大于平均数，那么进行交换，直至出现临界值，当组一的总分数小于平均分值，即分组成功 

    		+ 1、<!--要注意分组中负数的存在，负数会越加越小。-->
    	
    	    			+ 2、<!--为什么用组一的分值最小的选手去和组二中分值最大的选手进行交换-->

    ​			 因为可以使组一的分值缓慢下降，直至出现组一的分值大于平均值。 否则快速下降，很难确定临界值。

    

    #### Java代码：

    下面是我的代码，如果有什么不足的地方或者错误的地方，欢迎指出。

    ```java
    package com.kxj;
    
    /**
     * @ClassName GroupingDemo
     * @Description TODO
     * @Author kongxiangjin
     * @Date 2019/10/15 16:13
     * @Version 1.0
     **/
    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.List;
    
    public class GroupingDemo {
        //选手集合  
        private static List<Player> players = new ArrayList<>();
    
        public static void main(String[] args) {
            // 初始化选手
            Player player1 = new Player("a", 22);
            Player player2 = new Player("b", -9);
            Player player3 = new Player("c", 13);
            Player player4 = new Player("d", 17);
            Player player5 = new Player("e", 0);
            Player player6 = new Player("f", -11);
            Player player7 = new Player("g", -2);
    
            players.add(player1);
            players.add(player2);
            players.add(player3);
            players.add(player4);
            players.add(player5);
            players.add(player6);
            players.add(player7);
    
            //选手总人数
            int count = players.size();
            //总分数
            double sum = sumMethod(players);
            //分组数
            int groupNum = 2;
            //平均数
            double average = sum / groupNum;
            //每组人数
            int num = count / groupNum;        
            //double diff = sum;
            boolean flag = false;
            //倒叙
            Collections.sort(players);
    
            List<Player> groupList1 = new ArrayList<>();   
            List<Player> groupList2 = new ArrayList<>();
    
            for (int i = 0; i < num; i++) {
                groupList1.add(players.get(i));
            }
            for (int i = num; i < count; i++) {
                groupList2.add(players.get(i));
            }
    
            for (int i = 0; i < groupList2.size(); ) {
                // 先取出第二组中最大的选手
                Player p2 = groupList2.get(i);
                for (int j = groupList1.size() - 1; j >= 0; j--) {
                    // 集合中的对象进行交换
                    Player p1 = groupList1.get(j);
                    groupList1.remove(p1);
                    groupList1.add(p2);
                    groupList2.remove(p2);
                    groupList2.add(p1);
                    double sum1 = sumMethod(groupList1);
    //              double sum2 = sumMethod(groupList2);
    
                    // 如果交换后的数据不满足条件，说明上一个值即为临界值，则进行回退
                    if (sum1 > average && j != 0) {
                        groupList1.remove(p2);
                        groupList1.add(p1);
                        groupList2.remove(p1);
                        groupList2.add(p2);
                    } else if (sum1 > average && j == 0) {
                        break;
                    } else {
                        // 找到临界值后跳出循环
                        flag = true;
                        break;
                    }
    
                }
                if (flag == true) {
                    System.out.println(groupList1);
                    System.out.println(groupList2);
                    break;
                }
                // 每次循环需要对组一进行重新排序，再交换的过程中，原先的倒叙会被打乱。
                Collections.sort(groupList1);
            }
        }
    
        /**
         * 求总分数
         * @param players
         * @return
         */
        private static double sumMethod(List<Player> players) {
            double sum = 0;
            for (Player player : players) {
                sum += player.getScore();
            }
            return sum;
        }
    }
    
    ```

    ```java
    package com.kxj;
    
    /**
     * @ClassName Player
     * @Description TODO
     * @Author kongxiangjin
     * @Date 2019/10/15 16:14
     * @Version 1.0
     **/
    public class Player implements Comparable<Player> {
        private String name;
        private int score;
    
        public Player() {
        }
    
        public Player(String name, int score) {
            this.name = name;
            this.score = score;
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public int getScore() {
            return score;
        }
    
        public void setScore(int score) {
            this.score = score;
        }
    
        @Override
        public int compareTo(Player o) {
            return o.score - this.score;
        }
    
        @Override
        public String toString() {
            return "Player{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }
    
    
    ```

    

    

