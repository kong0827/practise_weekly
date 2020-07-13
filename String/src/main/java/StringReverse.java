/**
 * @author kxj
 * @date 2020/7/12 23:12
 * @desc 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student."，则输出"student. a am I"
 */
public class StringReverse {
    public static void main(String[] args) {
        System.out.println(reverseString("I am a student."));
    }

    static String reverseString(String str) {
        if (str == null) {
            return null;
        }
        String[] s = str.split(" ");
        String temp = "";
        for (int i = s.length - 1; i >= 0; i--) {
            temp += s[i] + " ";
        }
        return temp;
    }
}
