import java.util.Arrays;

/**
 * @author xiangjin.kong
 * @date 2020/7/3 15:35
 * @desc 输入一个正整数组，把数组所有的数字拼接起来排成一个数，打印拼接处所有数字中最小的一个
 * 例如输入数组{3,32,321}, 则打印这三个数字能排列处的最小数字是321323
 */
public class MinNumber {

    public static void main(String[] args) {
        int[] array = {3, 32, 321};
        String minNumber = getMinNumber1(array);
        System.out.println(minNumber);

    }

    /**
     * 解法一：
     * 全排列：用变量记录过程中的最小值，n个数字有n!个排列方式
     * 找规律排序，要对3，32 ，321 排序，不能直接比较32，3的大小，
     * 应该比较323，332的大小，即，3，32的大小应该有323，332的大小来确定。
     * 因此3比32大，3应该在32后面，32和321比较时，
     * 32321>32132,因此32>321,32在321后面，
     * 3，32，321由小到大排序为，321，32，3，
     * 组成的最小数为：321323
     *
     * @param array
     * @return
     */
    public static String getMinNumber1(int[] array) {
        String min = new String();
        if (array == null || array.length == 0) {
            return min;
        }
        if (array.length == 1) {
            return String.valueOf(array[0]);
        }

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                String a = "" + array[i] + array[j];
                String b = "" + array[j] + array[i];
                if (a.compareTo(b) > 0) { // 如果a>b
                    swap(i, j, array);
                }
            }
        }
        for (int num : array) {
            min += String.valueOf(num);
        }
        return min;
    }


    /**
     * 交换数组中的位置
     * @param i
     * @param j
     * @param numbers
     */
    private static void swap(int i, int j, int[] numbers) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
