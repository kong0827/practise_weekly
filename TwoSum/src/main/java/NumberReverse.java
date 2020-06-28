/**
 * @author xiangjin.kong
 * @date 2020/6/1 17:46
 * @desc 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 */
public class NumberReverse {

    public static void main(String[] args) {
        int reverseNumber = reverse2(123);
        System.out.println(reverseNumber);
    }

    public static int reverse(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        if (x >= 0) {
            for (int i = 0; i < chars.length / 2; i++) {
                char temp = chars[i];
                chars[i] = chars[chars.length - 1 - i];
                chars[chars.length - 1 - i] = temp;
            }
        } else {
            for (int i = 1; i < chars.length / 2 + 1; i++) {
                char temp = chars[i];
                chars[i] = chars[chars.length - i];
                chars[chars.length - i] = temp;
            }
        }
        Integer value = 0;
        try {
            value = Integer.valueOf(String.valueOf(chars));
        } catch (Exception e) {
            return value;
        }
        return value;
    }

    public static int reverse2(int x) {

        int value = 0;
        StringBuilder temp = new StringBuilder();

        if (x < 0) {
            temp.append("-");
            getResult(x, temp, 1);
        } else {
            getResult(x, temp, 0);

        }
        try {
            value = Integer.valueOf(String.valueOf(temp));
        } catch (Exception e) {
            return 0;
        }
        return value;
    }

    private static void getResult(int x, StringBuilder temp, int index) {
        int length = String.valueOf(x).length();
        for (int i = index; i < length; i++) {
            int mod = Math.abs(x % 10);
            temp.append(mod);
            x = x / 10;
        }
    }
}
