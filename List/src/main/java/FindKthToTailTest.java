/**
 * @author xiangjin.kong
 * @date 2020/6/28 15:07
 * @desc 输入一个链表，输出该链表中倒数第k个结点
 */
public class FindKthToTailTest {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode();
        listNode1.value = 1;
        ListNode listNode2 = new ListNode();
        listNode2.value = 2;
        ListNode listNode3 = new ListNode();
        listNode3.value = 3;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ListNode kToTail = findKToTail(listNode1, 2);
        System.out.println(kToTail);
    }

    static ListNode findKToTail(ListNode head, int k) {

        if (head == null) {
            return null;
        }
        int count = 1;
        // 计算节点的个数
        ListNode newHead = head;
        while (newHead.next != null) {
            newHead = newHead.next;
            count++;
        }
        if (k > count) {
            return null;
        }
        // 查找第count-k节点
        for (int i = 0; i < count - k; i++) {
            head = head.next;
        }
        return head;
    }
}
