/**
 * @author xiangjin.kong
 * @date 2020/7/14 14:50
 * @desc 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 *       使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的
 */
public class TwoNumberSumInArray {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        Integer[] number = getNumber(array, 5);
        for (Integer integer : number) {
            System.out.println(integer);
        }
    }

    static Integer[] getNumber(int[] array, int target) {

        if (array == null || array.length < 2) {
            return null;
        }

        int product = Integer.MAX_VALUE;
        Integer[] newArray = new Integer[2];
        boolean flag = true;

        for (int i = 0; i < array.length-1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > target) {
                    flag = false;
                    break;
                }
                if (array[j] > target) {
                    break;
                }
                if (array[i] + array[j] == target) {

                    int temp = array[i] * array[j];
                    if (temp < product) {
                        product = temp;
                        newArray[0] = array[i];
                        newArray[1] = array[j];
                    }
                }
            }
            if (!flag) {
                break;
            }
        }


        return newArray;
    }
}
