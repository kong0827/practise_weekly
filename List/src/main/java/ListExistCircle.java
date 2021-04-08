import org.junit.jupiter.api.Test;

/**
 * @author xiangjin.kong
 * @date 2021/4/8 19:22
 * @desc 判断链表是否存在环
 *
 * 快慢指针
 */
public class ListExistCircle {

    @Test
    public void test() {
        ListNode listNode1 = new ListNode();
        listNode1.value = 1;
        ListNode listNode2 = new ListNode();
        listNode2.value = 2;
        ListNode listNode3 = new ListNode();
        listNode3.value = 3;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        System.out.println(isCircle(listNode1));
        listNode3.next = listNode2;
        System.out.println(isCircle(listNode1));

    }

    public boolean isCircle(ListNode head) {
        // 慢指针 一次走一步
        ListNode slow = head;
        // 快指针 一次走两步
        ListNode fast = head;

        while (fast.next != null && slow != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
