import java.util.*;
import java.util.stream.Stream;

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
        int number3 = get(random);
        System.out.println(number + " " + number2 + " " + number3);
    }

    /**
     * 递归实现 O(2^n)
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

    /**
     * 递归优化 记录已计算的值 O(n)
     * @param n
     * @return
     */
    public static int get(int n) {
        if (n < 1) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            list.add(0);
        }
        return helper(n, list);
    }

    private static int helper(int n, List<Integer> list) {
        if (n == 1 || n == 2) {
            return 1;
        }
        // 已经计算过
        if (list.get(n) != 0) {
            return list.get(n);
        }
        int number = helper(n - 1, list) + helper(n - 2, list);
        list.set(n, number);
        return list.get(n);
    }

    /**
     * 回溯  O(1)
     * @param n
     * @return
     */
    public static int getNumber2(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int number = 0;
        int a = 1, b = 1;
        for (int i = 3; i <= n; i++) {
            number = a + b;
            a = b;
            b = number;
        }
        return number;
    }
}
