import org.junit.jupiter.api.Test;

/**
 * @author kxj
 * @date 2021/5/13 23:04
 * @desc 反转以 a 为头结点的链表」其实就是「反转 a 到 null 之间的结点
 * 反转 a 到 b 之间的结点
 */
public class Demo_06_ReverseANodeToBNode {

    public static ListNode reverse(ListNode a, ListNode b) {

        ListNode pre = null;
        ListNode cur = a;
        ListNode next = a;

        while (cur != b) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

}
