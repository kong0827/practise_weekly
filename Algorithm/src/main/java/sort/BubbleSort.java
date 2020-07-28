package sort;

/**
 * @author xiangjin.kong
 * @date 2020/7/28 15:58
 * @desc 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {

    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                int temp =0;
                if (arr[j] < arr[i + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

        }
    }
}
