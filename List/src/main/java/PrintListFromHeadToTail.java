import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author kxj
 * @date 2021/4/10 23:29
 * @desc 从头到尾打印单链表
 * 1、先反转在遍历 会破坏链表的结构
 * 2、栈
 */
public class PrintListFromHeadToTail {

    @Test
    public void test() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;
        print(listNode1);
    }

    public void print(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode cur = head;
        Stack<ListNode> stack = new Stack<>();
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().value);
        }

    }
}
