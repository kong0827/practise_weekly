import java.util.ArrayList;
import java.util.List;

/**
 * @author xiangjin.kong
 * @date 2021/3/24 18:58
 *
 * 给定一组不同的整数S，返回所有可能的子集。
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique.
 */
public class 子集 {

    public static void main(String[] args) {
        List<List<Integer>> subsets = subsets(new int[]{1, 2, 3});
        List<List<Integer>> subsets2 = subsets2(new int[]{1, 2, 3});
        System.out.println(subsets);
        System.out.println(subsets2);
    }


    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for(int i = 0; i < nums.length ; i++)
        {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> newtemp = new ArrayList<Integer>(res.get(j));
                newtemp.add(nums[i]);
                res.add(newtemp);
            }
        }
        return res;
    }
    public static List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        search(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    private static void search(ArrayList<List<Integer>> res, ArrayList<Integer> integers, int[] nums, int index) {
        res.add(new ArrayList<Integer>(integers));

        for (int i = index; i < nums.length; i++) {
            integers.add(nums[i]);
            search(res, integers, nums,i + 1);
            integers.remove(integers.size() - 1);
        }
    }

}
