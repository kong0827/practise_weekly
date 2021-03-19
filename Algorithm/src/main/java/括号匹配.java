import java.util.List;
import java.util.Stack;

/**
 * @author xiangjin.kong
 * @date 2021/3/19 16:50
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * example
 * ()   true
 * ([)] false
 */
public class 括号匹配 {

    public static void main(String[] args) {
        boolean check = check("([)]");
        System.out.println(check);
    }

    static boolean check(String str) {
        if (str.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                //表明有多余的括号
                return false;
            }
        }

        return true;
    }
}
