import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiangjin.kong
 * @date 2020/6/16 14:02
 * @desc 等价多米诺骨牌
 * <p>
 * 给你一个由一些多米诺骨牌组成的列表 dominoes。
 * 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 * 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 * <p>
 * 示例：
 * 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * [[1,2],[1,2],[1,1],[1,2],[2,2]]  3
 * 输出：1
 *  
 * 提示：
 * 1 <= dominoes.length <= 40000
 * 1 <= dominoes[i][j] <= 9
 */
public class NumEquivDominoPairsTest {

    public static void main(String[] args) {
        int[][] dominoes = new int[][]{{1, 2}, {1, 2}, {1, 1}, {1, 2}, {2, 2}, {1, 2}};
//        int[][] dominoes = new int[][]{{1, 1}, {2, 2}, {1, 1}, {1, 2}, {1, 2}, {1, 1}};
        int count = numEquivDominoPairs2(dominoes);
        System.out.println(count);

    }

    public static int numEquivDominoPairs(int[][] dominoes) {
        int sum = 0;
        Map<Integer, HashMap<Integer, Integer>> map = new HashMap();
        for (int i = 0; i < dominoes.length; i++) {
            Arrays.sort(dominoes[i]);
            int a = dominoes[i][0];
            int b = dominoes[i][1];
            if (map.containsKey(a)) {
                HashMap<Integer, Integer> list = map.get(a);
                if (list.containsKey(b)) {
                    int count = list.get(b);
                    sum = sum + count;
                    list.put(b, count + 1);
                    map.put(a, list);
                } else {
                    list.put(b, 1);
                    map.put(a, list);
                }
            } else {
                HashMap<Integer, Integer> list = new HashMap<>();
                list.put(b, 1);
                map.put(a, list);
            }
        }
        return sum;
    }


    public static int numEquivDominoPairs2(int[][] dominoes) {
        int ans = 0;
        int[] cp = new int[100];
        for(int[] arr:dominoes){
            Arrays.sort(arr);
            ans+=cp[arr[0]*10+arr[1]]++;
        }
        return ans;
    }

}

/**
 * 2： 1  1+0
 * 3： 3  2+1
 * 4： 6  3+2+1
 * 5: 10  4+3+2+1
 */
