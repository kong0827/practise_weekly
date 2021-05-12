import org.junit.jupiter.api.Test;

/**
 * @author xiangjin.kong
 * @date 2021/3/12 17:42
 * @desc 翻转链表
 * 1、递归法
 * 2、
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        // 判断链表为空或长度为1的情况
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null; // 当前节点的前一个节点  保存先前节点
        ListNode next = null; // 当前节点的下一个节点 保存临时变量
        while (head != null) {
            next = head.next; // 记录当前节点的下一个节点位置；
            head.next = pre; // 让当前节点指向前一个节点位置，完成反转 断链
            pre = head; // pre 往右走
            head = next;// 当前节点往右继续走
        }
        return pre;
    }

    // 递归法
    public ListNode reverseList2(ListNode head) {
        // 判断链表为空或长度为1的情况
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        ListNode last = reverseList2(head.next);
        temp.next = head;
        head.next = null;
        return last;
    }

    /**
     * ListNode reverse(ListNode head) {
     *     if (head.next == null) return head;
     *     ListNode last = reverse(head.next);
     *     head.next.next = head;
     *     head.next = null;
     *     return last;
     * }
     * @param head
     * @return
     */

    ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = null;
        ListNode newList = null;
        while (head != null) {
            // 获得当前节点的下一个节点
            temp = head.next;
            // 断链，拿出当前节点
            head.next = newList;
            // 翻转后的新链表指向当前节点
            newList = head;
            // 当前节点的下一个节点作为当前节点
            head = temp;
        }
        return newList;
    }

    @Test
    public void test1() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        System.out.println(listNode1);
        ListNode reverse = reverse(listNode1);
        ListNode listNode = reverseList(listNode1);
        System.out.println(listNode);


    }

}
