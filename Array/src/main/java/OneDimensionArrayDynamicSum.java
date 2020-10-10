import java.util.Arrays;
import java.util.Collections;

/**
 * @author xiangjin.kong
 * @date 2020/10/10 9:41
 * @desc 一维数组的动态和
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * 请返回 nums 的动态和。
 * 示例 1：
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
 *
 * 示例 2：
 * 输入：nums = [1,1,1,1,1]
 * 输出：[1,2,3,4,5]
 * 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
 *
 * 示例 3：
 * 输入：nums = [3,1,2,10,1]
 * 输出：[3,4,6,16,17]
 *  
 *
 * 提示：
 * 1 <= nums.length <= 1000
 * -10^6 <= nums[i] <= 10^6
 */
public class OneDimensionArrayDynamicSum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] newNums = runningSum(nums);
        for (int newNum : newNums) {
            System.out.println(newNum);

        }
    }

     static int[] runningSum(int[] nums) {
        int temp = 0;
        for(int i=0; i<nums.length; i++) {
            nums[i] = nums[i] + temp;
            temp = nums[i];
        }
        return nums;
    }
}
