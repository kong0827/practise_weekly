package sort;

/**
 * @author kxj
 * @date 2020/7/30 23:47
 * @desc 插入排序
 */
public class SelectSort {

    public static void main(String[] args) {
        
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i; // 最小元素的下标
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j; // 找到最小值
                }
            }

            // 交换位置
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}
