package sort;

/**
 * @author kxj
 * @date 2020/7/30 23:56
 * @desc 插入排序
 */
public class InsertSort {

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int value = arr[i];
            int j = 0;//插⼊的位置
            for (j = i-1; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j+1] = arr[j];//移动数据
                } else {
                    break;
                }
            }
            arr[j+1] = value; //插⼊数据
        }
    }
}
