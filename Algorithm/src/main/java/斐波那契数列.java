import java.util.Map;

/**
 * @author xiangjin.kong
 * @date 2021/3/25 20:05
 * <p>
 * 斐波那契数列，又称黄金分割数列，指的是这样一个数列：0、1、1、2、3、5、8、13、21、34、
 * ……在数学上，斐波纳契数列以如下被以递归的方法定义：F（0）=0，F（1）=1，F（n）=F(n-1)+F(n-2)（n≥2，n∈N*）
 */
public class 斐波那契数列 {

    public static void main(String[] args) {
        int random = (int) (Math.random() * 20);
        int number = getNumber(random);
        int number2 = getNumber2(random);
        System.out.println(number + " " + number2);
    }

    /**
     * 递归实现
     */
    public static int getNumber(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return getNumber(n - 1) + getNumber(n - 2);
        }
    }

    public static int getNumber2(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int number = 0;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            number = a + b;
            a = b;
            b = number;
        }
        return number;
    }
}
