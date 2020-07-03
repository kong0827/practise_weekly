import org.junit.jupiter.api.Test;

import javax.xml.transform.Templates;
import java.util.Arrays;

/**
 * @author xiangjin.kong
 * @date 2020/7/3 15:35
 * @desc 输入一个正整数组，把数组所有的数字拼接起来排成一个数，打印拼接处所有数字中最小的一个
 * 例如输入数组{3,32,321}, 则打印这三个数字能排列处的最小数字是321323
 */
public class MinNumber {

    public static void main(String[] args) {
        int[] array = {3, 32, 321};
        int minNumber = getMinNumber(array);
        System.out.println(minNumber);

    }


    public static int getMinNumber(int[] array) {
        Arrays.sort(array);
        int result = array[0];
        for (int i = 0; i < array.length - 1; i++) {

        }
        return result;
    }
}
