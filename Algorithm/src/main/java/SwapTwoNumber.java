/**
 * @author xiangjin.kong
 * @date 2020/7/7 17:40
 * @desc 不通过中间变量进行交换
 */
public class SwapTwoNumber {

    public static void main(String[] args) {
        int a = 1, b = 2;

        /**
         * 方式一 利用两数之和来做
         */
        a = a + b;   // a保存两数之和
        b = a - b;   // b 现在是a (a+b)-b = a
        a = a - b;  // a-b = (a+b)-a = b

        System.out.println(a + " " + b);

        /**
         * 利用两数之差，即两数之间的距离
         */
        a = 1; b = 2;
        a = b - a;   //a=两者的差
        b = b - a;    //b = 原来的b-两数的距离==原来的a
        a = a + b;    //最终的a=两者之差+原来的a==原来的b
        System.out.println(a + " " + b);

        /**
         * 方式三 异或
         */
        a = 1; b = 2;
        a = a^b;   //a保存两数异或的中间结果
        b = a^b;    //a两次异或b就变成原来的a，并将其赋值给了b
        a = a^b;    //b两次异或a就变成原来的b，并且将其赋值给了a
        System.out.println(a + " " + b);
    }
}
