import org.junit.jupiter.api.Test;

/**
 * @author kxj
 * @date 2021/5/12 0:35
 * @desc 翻转鏈表前N个节点
 */
public class Demo_02_ReverseNList {

    /**
     * 1->2->3->4->5->6->null
     * 翻转后
     * 4->3->2->1->5->6
     *
     * @param head
     * @return
     */

    // 后继节点
    ListNode successor = null;

    ListNode reverse(ListNode head, int n) {
        int i = 1;
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverse(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }

    @Test
    public void test() {
        ListNode listNode = MockNodeList.create();
        ListNode node = reverse(listNode, 3);
        System.out.println(node);
    }

}
