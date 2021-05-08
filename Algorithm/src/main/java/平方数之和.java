/**
 * @author xiangjin.kong
 * @date 2021/5/8 15:07
 * @desc 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a^2 + b^2 = c。
 * 5  =  1*1 + 2*2
 */
public class 平方数之和 {

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            test(i);
        }
    }

    /**
     * 双指针
     *
     * @param c
     */
    private static void test(int c) {
        long left = 0;
        long right = (long) Math.sqrt(c);
        boolean flag = false;
        while (left < right) {
            long mul = left * left + right * right;
            if (mul == c) {
                flag = true;
                break;
            } else if (mul < c) {
                left++;
            } else {
                right--;
            }
        }
        if (flag) {
            System.out.println(c + ": " + left + "" + right);
            return;
        }
        System.out.println(c + ":无此平方数");
    }


}
