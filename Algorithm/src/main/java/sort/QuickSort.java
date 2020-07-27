package sort;

/**
 * @author kxj
 * @date 2020/7/27 22:13
 * @desc 快排
 */
public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        // temp：基准位
        temp = arr[low];

        while (i < j) {
            // 先看右边
            while (temp <= arr[j] && i < j) {
                j--;
            }

            // 再看左边
            while (temp >= arr[i] && i < j) {
                i++;
            }

            // 如果满足条件进行交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

            // 最后将基准位与i和j相等位置进行数字交换
            arr[low] = arr[i];
            arr[i] = temp;
            // 递归调用左半数组
            quickSort(arr, low, j - 1);
            // 递归调用右半数组
            quickSort(arr, j + 1, high);
        }

    }

    public static void main(String[] args) {
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        quickSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
