import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiangjin.kong
 * @date 2021/2/1 15:46
 *
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，
 * 则最小的4个数字是1、2、3、4。
 *
 *  示例 1：
 *  输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 *
 *  示例 2：
 *  输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 *  限制：
 *  0 <= k <= arr.length <= 10000
 *  0 <= arr[i] <= 10000
 */
public class MinKNumber {

    /**
     * 解答失败: 测试用例:[0,1,2,2,2,1,3,6,3,1,8,2,5,3,11,4,11,12,6,2,7,19,20,16,23,6,23
     * ,4,3,25,19,15,15,17,26,30,24,31,2,26,32,6,27,21,3,6,18,46,14,13,43,19,17,50,46,40,13,2,10,43
     * ,6,5,8,23,41,21,58,10,28,22,25,63,7,40,64,50,7,57,61,43,45,64,78,50,49,15,45,10,27,66,14,68,81,48,
     * 51,33,17,35,71,31] 24
     * 测试结果:[0,1,2,2,2,1,3,6,3,1,2,5,3,4,6,2,6,4,3,2,6,3,6,2]
     * 期望结果:[0,1,1,1,2,2,2,2,2,2,2,3,3,3,3,3,4,4,5,5,6,6,6,6]
     */
    public static void main(String[] args) {
        int[] nums = {3, 4, 2, 1};
        int k = 3;
        int[] leastNumbers = getLeastNumbers(nums, k);
        for (int leastNumber : leastNumbers) {
            System.out.println(leastNumber);
        }
    }

    static public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private static int[] quickSearch(int[] nums, int lo, int hi, int k) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
        int j = partition(nums, lo, hi);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return j > k? quickSearch(nums, lo, j - 1, k): quickSearch(nums, j + 1, hi, k);
    }

    // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
    private static int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && nums[i] < v);
            while (--j >= lo && nums[j] > v);
            if (i >= j) {
                break;
            }
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[lo] = nums[j];
        nums[j] = v;
        return j;
    }
}