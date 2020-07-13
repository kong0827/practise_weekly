import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author xiangjin.kong
 * @date 2020/7/10 18:09
 * @desc 用两个队列模拟栈，完成队列的Push和Pop操作。 队列中的元素为int类型
 */
public class MyStack {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();
    private int size;


    /**
     * 压栈
     * @param num
     */
    public void push(Integer num) {
        while (queue1.size() > 0) {
            queue2.add(queue1.poll());
        }
        queue1.add(num);
        while (queue2.size() > 0) {
            queue1.add(queue2.poll());
        }
    }

    /**
     * 出栈
     * @return
     */
    public Integer pop() {
        return queue1.poll();
    }


    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
