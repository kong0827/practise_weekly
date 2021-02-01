/**
 * @author kxj
 * @date 2020/7/7 0:26
 * @desc 统计一个数字在排序数组中出现的次数
 */
public class NumberCountInArray {

    public static void main(String[] args) {
        int nums[] = new int[]{1, 2, 3, 3, 3, 3, 4, 5};
        int count = getNumberOfK(nums, 3);
        System.out.println(count);

    }

    public static int getNumberOfK(int[] array, int k) {
        /**
         * 二分查找 获取到k的第一个位置和k的最后一个位置，然后返回lastK-firstK+1
         */
        if (array == null || array.length == 0) {
            return 0;
        }
        int firstK = getFirstK(array, k, 0, array.length - 1);
        int lastK = getLastK(array, k, 0, array.length - 1);

        int number = 0;
        if (firstK > -1 && lastK > -1) {
            number = lastK - firstK + 1;
        }

        return number;
    }

    /**
     * 找出第一个k所在的位置
     * @param array
     * @param k
     * @param i
     * @param i1
     * @return
     */
    private static int getFirstK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middleIndex = (start + end) / 2;
        int middleData = array[middleIndex];
        if (middleData == k) {
            // 找出第一个位置K的终止条件，要么middleIndex=0, 要么middleIndex > 0, 但是middleIndex-1处位置不等于k
            if (middleIndex == 0 || (array[middleIndex - 1] != k && middleIndex > 0)) {
                return middleIndex;
            } else {
                end = middleIndex - 1;
            }
        } else if (middleData > k) {
            end = middleIndex - 1;
        } else {
            start = middleIndex + 1;
        }
        return getFirstK(array, k, start, end);
    }

    /**
     * 找出最后一个k所在的位置
     * @param array
     * @param k
     * @param start
     * @param end
     * @return
     */
    private static int getLastK(int[] array, int k, int start, int end) {

        if (start > end) {
            return -1;
        }

        int middleIndex = (start + end) / 2;
        int middleData = array[middleIndex];

        if (middleData == k) {
            if (middleIndex == array.length || (middleIndex < array.length && array[middleIndex + 1] != k)) {
                return middleIndex;
            } else {
                start = middleIndex + 1;
            }
        } else if (middleData > k) {
            start = middleIndex + 1;
        } else {
            end = middleIndex - 1;
        }

        return getLastK(array, k, start, end);
    }
}
