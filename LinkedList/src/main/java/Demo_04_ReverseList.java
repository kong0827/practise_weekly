import org.junit.jupiter.api.Test;

/**
 * @author kxj
 * @date 2021/5/13 22:47
 * @desc 翻转链表  迭代
 */
public class Demo_04_ReverseList {

    public ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode next;
        ListNode pre = null;
        while (cur != null) {
            next = cur.next;
            // 逐个节点翻转
            cur.next = pre;
            // 更新指针位置
            pre = cur;
            cur = next;
        }
        // 翻转后的头节点
        return pre;
    }

    @Test
    public void test() {
        ListNode listNode = MockNodeList.create();
        ListNode reverse = reverse(listNode);
        System.out.println(reverse);
    }
}
