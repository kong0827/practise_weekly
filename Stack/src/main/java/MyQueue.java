import java.util.Stack;

/**
 * @author xiangjin.kong
 * @date 2020/7/10 17:16
 * @desc 用两个栈模拟队列
 *
 * 有两个栈 stack1 和 stack2
 * 入队列的时候只往 stack1 添加元素就行
 * 出队列的时候先判断 stack2 是否为空，stack2 中的元素都是先进来的，先进先出。
 * 如果 stack2 不为空，则直接弹出 stack2 的栈顶元素。如果为空，则将 stack1 的元素添加到 stack2 中，然后弹出 stack2 的栈顶元素
 */
public class MyQueue {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.add(5);
        myQueue.add(6);
        myQueue.add(7);
        myQueue.add(8);

        System.out.println(myQueue.poll());
        myQueue.add(9);
        System.out.println(myQueue.poll());

    }

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    /**
     * 入队列
     */
    public void add(Integer num) {
        stack1.add(num);
    }


    /**
     * 出队列
     */
    public Integer poll() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return null;
        }
        if (!stack2.isEmpty() && stack1.isEmpty()) {
            return stack2.pop();
        }
        while (!stack1.isEmpty()) {
            stack2.add(stack1.pop());
        }
        return stack2.pop();
    }
}
