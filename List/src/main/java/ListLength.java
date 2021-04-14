import org.junit.jupiter.api.Test;

/**
 * @author kxj
 * @date 2021/4/10 23:18
 * @desc 单链表中有效节点的个数
 */
public class ListLength {

    @Test
    public void test() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;
        int length = getLength(listNode1);
        System.out.println(length);
    }

    public int getLength(ListNode head) {
        if (head == null) {
            return 0;
        }

        int length = 1;
        ListNode newHead = head.next;
        while (newHead != null) {
            length++;
            newHead = newHead.next;
        }
        return length;
    }
}
