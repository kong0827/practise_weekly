/**
 * @author xiangjin.kong
 * @date 2021/3/12 17:42
 */
public class ReverseList {


    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    class Solution {
        public ListNode ReverseList(ListNode head) {
            // 判断链表为空或长度为1的情况
            if (head == null || head.next == null) {
                return head;
            }
            ListNode pre = null; // 当前节点的前一个节点
            ListNode next = null; // 当前节点的下一个节点
            while (head != null) {
                next = head.next; // 记录当前节点的下一个节点位置；
                head.next = pre; // 让当前节点指向前一个节点位置，完成反转
                pre = head; // pre 往右走
                head = next;// 当前节点往右继续走
            }
            return pre;
        }
    }
}
