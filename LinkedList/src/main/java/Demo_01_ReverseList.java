import org.junit.jupiter.api.Test;
import org.omg.CORBA.SetOverrideType;

/**
 * @author kxj
 * @date 2021/5/12 0:35
 * @desc 链表翻转
 */
public class Demo_01_ReverseList {

    /**
     * 递归
     * 1->2->3->4->5->6->null
     * 最后一次：head=6 出递归，
     * 此时的last=6->null，head=5->6
     * head.next.next = head    head=5->6->5 last=6->5
     * head.next = null          head=5->null  last=6->5
     *
     * 再往上出一层
     * 此时head=4->5 last=6->5
     * head.next.next = head    head=4->5->4  last=6->5->4
     * head.next = null         head=4->null  last=6->5->4
     *
     * @param head
     * @return
     */
    ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        System.out.println(head.val);
//        reverse 函数会返回反转之后的头结点，用变量 last 接收
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    @Test
    public void test() {
        ListNode listNode = MockNodeList.create();
        reverse(listNode);
    }

}
