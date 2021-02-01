import java.util.Arrays;

/**
 * @author kxj
 * @date 2020/7/9 23:40
 * @desc 扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * <p>
 * 2-10为数字本身，A为1，J为11...大小王可以看成任何数字，可以把它当作0处理
 */
public class IsContinuous {
    public static void main(String[] args) {
        int[] numbers1 = {1, 3, 2, 5, 4};
        System.out.println(isContinuous(numbers1));
        int[] numbers2 = {1, 3, 2, 6, 4};
        System.out.println(isContinuous(numbers2));
        int[] numbers3 = {0, 3, 2, 6, 4};
        System.out.println(isContinuous(numbers3));
        int[] numbers4 = {0, 3, 1, 6, 4};
        System.out.println(isContinuous(numbers4));
        int[] numbers5 = {1, 3, 0, 5, 0};
        System.out.println(isContinuous(numbers5));
        int[] numbers6 = {1, 3, 0, 7, 0};
        System.out.println(isContinuous(numbers6));
        int[] numbers7 = {1, 0, 0, 5, 0};
        System.out.println(isContinuous(numbers7));
        int[] numbers8 = {1, 0, 0, 7, 0};
        System.out.println(isContinuous(numbers8));
        int[] numbers9 = {3, 0, 0, 0, 0};
        System.out.println(isContinuous(numbers9));
        int[] numbers10 = {0, 0, 0, 0, 0};
        System.out.println(isContinuous(numbers10));
        int[] numbers11 = {1, 0, 0, 1, 0};
        System.out.println(isContinuous(numbers11));
    }

    static boolean isContinuous(int[] array) {

        Arrays.sort(array);

        int zeroCount = 0;
        int count = 0;

        for (int i = 0; i < array.length-1; i++) {
            if (array[i] == 0) {
                zeroCount++;
                continue;
            }
            if (array[i + 1] - array[i] > 1) {
                count += array[i + 1] - array[i] -1;
            }
            if (array[i + 1] - array[i] == 0) {
                return false;
            }
        }
        if (zeroCount >= count) {
            return true;
        }

        return false;
    }
}
