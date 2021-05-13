import org.junit.jupiter.api.Test;

/**
 * @author kxj
 * @date 2021/5/13 22:47
 * @desc
 */
public class Demo_05_ReverseGroupKList {

    ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        // 反转前 k 个元素
        ListNode newHead = Demo_06_ReverseANodeToBNode.reverse(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    @Test
    public void test() {
        ListNode listNode = MockNodeList.create();
        ListNode reverse = reverseKGroup(listNode, 2);
        System.out.println(reverse);
    }

}
