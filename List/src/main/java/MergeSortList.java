/**
 * @author xiangjin.kong
 * @date 2020/6/19 17:27
 * @desc 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class MergeSortList {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode();
        listNode1.value = 1;
        ListNode listNode2 = new ListNode();
        listNode2.value = 3;
        listNode1.next = listNode2;


        ListNode listNode3 = new ListNode();
        listNode3.value = 2;
        ListNode listNode4 = new ListNode();
        listNode4.value = 4;
        listNode3.next = listNode4;

        ListNode merge = merge(listNode1, listNode3);
        System.out.println(merge);

    }

    public static ListNode merge(ListNode listNode1, ListNode listNode2) {
        // 新建一个头节点，用来存合并的链表
        ListNode head = new ListNode();
        head.next = null;
        ListNode root = head;

        while (listNode1 != null && listNode2 != null) {
            if (listNode1.value < listNode2.value) {
                head.next = listNode1;
                head = listNode1;
                listNode1 = listNode1.next;
            } else {
                head.next = listNode2;
                head = listNode2;
                listNode2 = listNode2.next;
            }
        }

        // 如果有一个链表为空，另一个链表非空，则将非空链表合并到链表尾部
        if (listNode1 != null) {
            head.next = listNode1;
        }
        if (listNode2 != null) {
            head.next = listNode2;
        }
        return root.next;
    }
}

