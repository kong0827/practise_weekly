import com.sun.xml.internal.ws.api.pipe.NextAction;
import org.junit.jupiter.api.Test;

/**
 * @author kxj
 * @date 2021/5/12 0:35
 * @desc 翻转鏈表M-N
 */
public class Demo_03_ReverseMToNList {

    /**
     * 1->2->3->4->5->6->null
     * 翻转后
     * 1->4->3->2->->5->6
     *
     * @param head
     * @return
     */

    // 前驱
    ListNode pre = null;
    // 后继节点
    ListNode successor = null;

    ListNode reverse(ListNode head, int m, int n) {
        if (m == 1) {
            Demo_02_ReverseNList reverseNList = new Demo_02_ReverseNList();
            return reverseNList.reverse(head, n);
        }
        head.next = reverse(head.next, m - 1, n - 1);
        return head;
    }

    @Test
    public void test() {
        ListNode listNode = MockNodeList.create();
        ListNode node = reverse(listNode, 2,4);
        System.out.println(node);
    }

}
