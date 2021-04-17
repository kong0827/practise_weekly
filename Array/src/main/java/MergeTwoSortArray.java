import static java.lang.System.out;

/**
 * @author xiangjin.kong
 * @date 2021/4/17 14:52
 * @desc 合并两个有序数组
 */
public class MergeTwoSortArray {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{2, 5, 6};
        int[] merge = merge(nums1, nums2);
        for (int i : merge) {
            out.println(i);
        }
    }

    /**
     * 1、两个指针分别从数组头部开始，然后比较、
     * 2、小的指针后移 直到有一个到数组尾部
     * 3、最后比较那个数组没有到尾部，然后全部拷贝到新数组
     * @param array1
     * @param array2
     * @return
     */
    public static int[] merge(int[] array1, int[] array2) {
        int[] array = new int[array1.length + array2.length];
        int i = 0, j = 0, m = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] <= array2[j]) {
                array[m++] = array1[i++];
            } else {
                array[m++] = array2[j++];
            }
        }
        while (i < array1.length) {
            array[m++] = array1[i++];
        }
        while (j < array2.length) {
            array[m++] = array2[j++];
        }
        return array;
    }
}
