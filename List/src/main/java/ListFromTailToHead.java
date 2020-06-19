import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author xiangjin.kong
 * @date 2020/6/19 16:33
 * @desc
 * 给定一个链表，按照链表值从尾到头的顺序返回一个ArrayList
 */
public class ListFromTailToHead {

    /**
     * 使用栈
     * 按照链表值从尾到头的顺序返回一个ArrayList。
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (listNode == null) {
            return list;
        }

        // 使用栈
        Stack<Integer> stack = new Stack<Integer>();
        while (listNode != null) {
            stack.add(listNode.value);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    /**
     * 创建两个ArrayList，一个用来根据传进来的ListNode参数创建一个完整的ArrayList，另外一个用来存储翻转后的ArrayList
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList result = new ArrayList();
        ListNode temp = listNode;
        while (temp != null) {
            list.add(temp.value);
            temp = temp.next;
        }
        for (Integer integer : list) {
            result.add(integer);
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode();
        listNode1.value = 1;
        ListNode listNode2 = new ListNode();
        listNode2.value = 2;
        ListNode listNode3 = new ListNode();
        listNode3.value = 3;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ArrayList<Integer> integers = printListFromTailToHead(listNode1);
        for (Integer integer : integers) {
            System.out.println(integer);
        }

    }
}

