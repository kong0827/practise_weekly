/**
 * @author xiangjin.kong
 * @date 2020/7/14 14:50
 * @desc 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的
 */
public class TwoNumberSumInArray {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        Integer[] number = getNumber(array, 5);
        for (Integer integer : number) {
            System.out.println(integer);
        }

        System.out.println("------------------------");
        Integer[] number1 = getNumber1(array, 5);
        for (Integer integer : number1) {
            System.out.println(integer);
        }
    }

    /**
     * 这题主要是证明：满足:x+y=c的所有x和y中，当x-y绝对值最小时，x*y最小
     * 设x>y
     * x+y = c
     * x-y = d  （目标把x和y用c和d表示，这样才能用c和d表示x*y，主要是的体现x*y与d的关系）
     * <p>
     * x = (c+d)//2
     * y = (c-d)/2
     * x*y = (c+d)(c-d)/4 = c^2 - d^2  所以d越大，x*y越小,所以最外层最先遍历到的满足x+y为S的即为乘积最小
     */
    static Integer[] getNumber1(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        Integer[] newArray = new Integer[2];

        while (low < high) {
            int temp = array[low] + array[high];
            if (temp == target) {
                newArray[0] = array[low];
                newArray[1] = array[high];
                break;
            } else if (temp > target) {
                high--;
            } else {
                low++;
            }
        }
        return newArray;
    }

    static Integer[] getNumber(int[] array, int target) {

        if (array == null || array.length < 2) {
            return null;
        }

        int product = Integer.MAX_VALUE;
        Integer[] newArray = new Integer[2];
        boolean flag = true;

        for (int i = 0; i < array.length - 1; i++) {
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
