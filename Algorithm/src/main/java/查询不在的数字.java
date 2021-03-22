import javafx.util.Builder;

/**
 * @author xiangjin.kong
 * @date 2021/3/22 17:45
 * <p>
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * 输入: [0,1,3] 输出: 2 示例 2:
 * 输入: [0,1,2,3,4,5,6,7,9] 输出: 8
 */
public class 查询不在的数字 {

    public static void main(String[] args) {
        int number1 = getNumber(new Integer[]{1, 2, 3});
        int number2 = getNumber(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 9});
        int number3 = getNumber(new Integer[]{0, 1});
        System.out.println(number1 + " " + number2 + " " + number3);

    }

    static int getNumber(Integer[] arr) {
        int number = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i) {
                number = i;
                flag = true;
                break;
            }
        }
        if (!flag) {
            number = arr.length;
        }
        return number;
    }
}
