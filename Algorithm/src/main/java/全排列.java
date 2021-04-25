import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * @author xiangjin.kong
 * @date 2021/4/25 17:32
 * 1，2，3的全排列有
 * 1，2，3
 * 1，3，2
 * 2，1，3
 * 2，3，1
 * 3，1，2
 * 3，2，1
 * <p>
 * * 1.定1，来求2，3的全排列
 * * 　　　　1.1.定2，来求3的全排列
 * * 　　　　　　1.1.1.只有3了。所以得到的答案为【1，2，3】
 * * 　　　　1.2回到刚刚的2，3全排列，因为3排了，2没有变，所以此时2不得不变，得到的答案是【1，3，2】
 * * 2.定1已经完了，这时候1不得不变了，所以定2，求1，3的全排列
 * * 　　　　2.1.定1，来求3的全排列
 * * 　　　　　　2.1.1.只有3了。所以得到的答案为【2,1,3】
 * * 　　　　2.2回到刚刚的1，3全排列，因为3排了，1没有变，所以此时1不得不变，得到的答案是【2，3,1】
 * * 3.定1,2已经完了，这时候1,2不得不变了，所以定3，求1，2的全排列
 * * 　　　　2.1.定1，来求2的全排列
 * * 　　　　　　2.1.1.只有2了。所以得到的答案为【3,1,2】
 * * 　　　　2.2回到刚刚的1，2全排列，因为2排了，1没有变，所以此时1不得不变，得到的答案是【3,1,2】
 */

public class 全排列 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        // 回溯法

        //递归
        fullArray(nums, 0, nums.length - 1);
    }

    private static void fullArray(int[] array, int cursor, int end) {
        if (cursor == end) {
            System.out.println(Arrays.toString(array));
        } else {
            for (int i = cursor; i <= end; i++) {
                ArrayUtils.swap(array, cursor, i);
                fullArray(array, cursor + 1, end);
                ArrayUtils.swap(array, cursor, i); // 用于对之前交换过的数据进行还原
            }
        }

    }


}
