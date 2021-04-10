import org.junit.jupiter.api.Test;

/**
 * @author kxj
 * @date 2021/4/10 23:18
 * @desc 单链表中有效节点的个数
 */
public class ListLength {

    @Test
    public void test() {
        ListNode listNode1 = new ListNode();
        listNode1.value = 1;
        ListNode listNode2 = new ListNode();
        listNode2.value = 2;
        ListNode listNode3 = new ListNode();
        listNode3.value = 3;
        int length = getLength(listNode1);
        System.out.println(length);
    }

    public int getLength(ListNode head) {
        if (head == null) {
            return 0;
        }

        int length = 0;
        while (head.next != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
