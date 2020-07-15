import java.util.HashMap;
import java.util.Map;

/**
 * @author kxj
 * @date 2020/7/9 23:44
 * @desc 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0
 */
public class MoreThanHalfNumberInArrayTest {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int number = getMoreThanHalfNumberInArray(array);
        System.out.println(number);
    }

    static int getMoreThanHalfNumberInArray(int[] array) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                Integer value = map.get(array[i]) + 1;
                if (value > array.length / 2) {
                    return array[i];
                }
                map.put(array[i], value);
            } else {
                map.put(array[i], 1);
            }
        }
        return 0;
    }
}
