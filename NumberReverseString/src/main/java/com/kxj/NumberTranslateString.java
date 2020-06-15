package com.kxj;

/**
 * @author xiangjin.kong
 * @date 2020/6/9 16:11
 * @desc 面试题46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= num < 231
 */
public class NumberTranslateString {
    public static void main(String[] args) {
        int count = translateNum(12258);
        System.out.println(count);
    }

    public static int translateNum(int num) {
        int count = 1;

        while (num > 0 && num >= 10) {
            count++;
            int reverseNumber = 0;
            reverseNumber = reverseNumber * 10 + num % 10;
            num = num / 10;
            reverseNumber = num % 10 * 10 + reverseNumber;

            if (reverseNumber / 25 > 1) {
                count--;
            }

        }
        return count;
    }
}
