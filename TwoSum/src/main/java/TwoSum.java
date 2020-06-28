import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author xiangjin.kong
 * @date 2020/6/1 16:48
 * @desc 两数之和
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 */
public class TwoSum {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
       int[] nums = {2, 7, 11, 15};
        int[] result = twoSum2(nums, 9);
        System.out.println(result[0] + " " + result[1]);

    }

    public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            boolean flag = false;
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    flag = true;
                    arr[0] = nums[i];
                    arr[1] = nums[j];
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        return arr;
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i< nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
