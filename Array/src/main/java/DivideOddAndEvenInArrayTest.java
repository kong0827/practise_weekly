import java.util.Arrays;

/**
 * @author xiangjin.kong
 * @date 2020/7/7 17:16
 * @desc 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分
 *
 * 设定两个指针
 *
 * 第一个指针start从数组第一个元素出发，向尾部前进
 * 第二个指针end从数组的最后一个元素出发，向头部前进
 * start遍历到偶数，end遍历到奇数时，交换两个数的位置
 * 当start>end时，完成交换
 *
 */
public class DivideOddAndEvenInArrayTest {

    public static void main(String[] args) {
        int[] array = {2, 4, 7, 9, 6, 8};
        int[] newArray = divideArray2(array);
        Arrays.stream(newArray).forEach(item -> {
            System.out.println(item);
        });
    }

    public static int[] divideArray1(int[] array) {
        if (array == null) {
            return null;
        }
        if (array.length <= 1) {
            return array;
        }

        int[] newArray = new int[array.length];
        int end = array.length - 1;
        int start = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                newArray[start] = array[i];
                start++;
            } else {
                newArray[end] = array[i];
                end--;
            }
        }
        return newArray;
    }

    public static int[] divideArray2(int[] array) {
        if (array == null) {
            return null;
        }
        if (array.length <= 1) {
            return array;
        }

        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            while (array[start] % 2 != 0) {
                start++;
            }
            while (array[end] % 2 == 0) {
                end--;
            }
            if (start < end) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }
        return array;
    }
}
