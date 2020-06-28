/**
 * @author xiangjin.kong
 * @date 2020/6/12 16:03
 * @desc 斐波那契数列问题
 * 1、初级版
 * 一只青蛙跳台阶，一次可以跳1阶，可以2阶。那么，台阶为n时，有多少种跳法。
 * <p>
 * 2、升级版
 * 一只青蛙跳台阶，一次可以跳1阶，可以2阶，其能力足够强大以至于一次可以跳n阶。那么，台阶为n时，有多少种跳法。
 */
public class FibonaccSequenceTest {

    public static void main(String[] args) {
        int solution = solution(10);
        System.out.println(solution);

        int solution2 = solution2(10);
        System.out.println(solution2);
    }

    /**
     * 递归算法（效率差）
     *
     * @param n
     * @return
     */
    public static int solution(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        return FibonaccSequenceTest.solution(n - 1) + FibonaccSequenceTest.solution(n - 2);
    }

    /**
     * 非递归
     * @param n
     * @return
     */
    public static int solution2(int n) {
        int x = 1;
        int y = 2;
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        for (int i = 2; i < n; i++) {
            int temp = y;
            y = x + y;
            x = temp;
        }
        return y;
    }


}
