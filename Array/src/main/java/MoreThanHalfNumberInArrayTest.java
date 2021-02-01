import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author kxj
 * @date 2020/7/9 23:44
 * @desc 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0
 */
public class MoreThanHalfNumberInArrayTest {
    public static void main(String[] args) {
        int[] array = {2, 2, 1, 1, 1, 2, 2};
        int number = getMoreThanHalfNumberInArray(array);
        System.out.println(number);
    }

    static int getMoreThanHalfNumberInArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
                if (map.get(nums[i]) > (nums.length / 2)) {
                    return nums[i];
                }
            } else {
                map.put(nums[i], 1);
            }
        }
        return 0;
    }
}
