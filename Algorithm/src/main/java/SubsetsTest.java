import java.util.List;

/**
 * @author xiangjin.kong
 * @date 2020/6/23 16:56
 * @desc
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 */
public class SubsetsTest {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = subsets(nums);
    }

    public static List<List<Integer>> subsets(int[] nums) {

        return null;
    }

    public void backTrace(int start, int[] nums, List<Integer> temp) {
        for (int i = 0; i < nums.length; i++) {
            temp.add(nums[i]);
            backTrace(i + 1, nums, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
