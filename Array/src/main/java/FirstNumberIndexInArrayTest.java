import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author kxj
 * @date 2020/7/7 1:20
 * @desc 在一个字符串(0<=字符串长度<=10000，全部由字母组成)
 * 中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回-1（需要区分大小写）。
 */
public class FirstNumberIndexInArrayTest {
    public static void main(String[] args) {
        String str = "abcdefghijklskabcdfewlsdfj";
        int index = getFirstNumberIndex(str);
        System.out.println(index);

    }

    /**
     * 利用map
     * @param str
     * @return
     */
    static int getFirstNumberIndex(String str) {
        Map<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        int i = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
