package dp;

import java.util.Arrays;

/**
 * @author kxj
 * @date 2021/5/9 18:17
 * @desc
 */
public class CollectChange {

    public static void main(String[] args) {
        int k = 3;
        int[] coins = {1, 2, 5};
        int amount = 11;

        int helper = helper(k, amount, coins);
        System.out.println(helper);
    }

    private static int helper(int k, int amount, int[] coins) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (Arrays.asList(coins).contains(amount)) {
            return 1;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {

            int subProblem = helper(k, amount - coins[i], coins);

            if (subProblem == -1) {
                continue;
            }
            res = Math.min(res, 1 + subProblem);
        }
        return res == Integer.MAX_VALUE ? -1 : res;

    }

}
