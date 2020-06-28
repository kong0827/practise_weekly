import java.util.ArrayList;
import java.util.List;

/**
 * @author xiangjin.kong
 * @date 2020/6/28 15:38
 * @desc 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * 思路
 *  设置快慢指针，都从链表头触发，快指针每次走两步，慢指针每次走一步
 *  假设有环，一定相遇于环中某点。接着让两个指针分别从相遇点和链表头出发，每次都改为走一步
 *  最终会相遇于环入口
 *
 *  两个结论
 *      1、设置快慢指针，假设有环，最后一定相遇
 *      因为low指针一定进环，就相当于fast指针在追low指针，每次两者都接近一步，最终追上
 *      2、两个指针分别从链表头和相遇点出发，每次走一步，最终一定相遇于环入口。
 *      链表头到环入口的长度为a，环入口到相遇点的长度为b，相遇点到环入口的长度为c
 *      快指针的路径为a + (b+c)*k + b (k>=1)，慢指针的路径 （a+b)
 *      快指针是慢指针的路径的两倍
 *      (a+b)*2 = a + (b+c)*k +b
 *      => a = (k-1)(b+c) + c
 *
 */
public class EntryNodeOfLoopTest {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode();
        listNode1.value = 1;
        ListNode listNode2 = new ListNode();
        listNode2.value = 2;
        ListNode listNode3 = new ListNode();
        listNode3.value = 3;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode2;
        ListNode listNode = entryNodeOfLoop(listNode1);
        System.out.println(listNode);
    }

    /**
     * 方式一：快慢指针
     */
    static ListNode entryNodeOfLoop(ListNode pHead){
        ListNode targetNode = new ListNode(3);
        if (pHead == null || pHead.next == null) {
            return null;
        }

        ListNode preNode = pHead.next;
        ListNode postNode = pHead.next.next;
        // 找到相遇点
        while (preNode != postNode) {
            preNode = preNode.next;
            postNode = postNode.next.next;
        }
        // 将其中一个指针指向头结点
        postNode = pHead;
        // 步长都为1，同时往后走，直到两者相遇
        // 相遇点就是入口
        while (preNode != postNode) {
            preNode = preNode.next;
            postNode = postNode.next;
        }
        targetNode = preNode;

        return targetNode;
    }

    /**
     * 方式二，遍历将扫描后的节点存储到List中，若List中已经存在，则这个为入口
     */
    static ListNode entryNodeOfLoop2(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }

        List<ListNode> listNodes = new ArrayList<>();
        ListNode listNode = null;

        while (pHead != null) {
            listNodes.add(pHead);
            pHead = pHead.next;
            if (listNodes.contains(pHead)) {
                listNode = pHead;
                break;
            }
        }
        return listNode;
    }
}
