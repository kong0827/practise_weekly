/**
 * @author xiangjin.kong
 * @date 2020/9/23 11:12
 * <p>
 * 用数组模拟队列
 */
public class ArrayQueue {
    /**
     * 队列最大容量
     */
    private int maxSize;
    /**
     * 队列头
     */
    private int front;
    /**
     * 队列尾
     */
    private int near;
    /**
     * 数组
     */
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        near = -1;
    }

    /**
     * 判断队列是否已满
     */
    public boolean isFull() {
        return near == maxSize - 1;
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty() {
        return near == front;
    }

    /**
     * 入队
     *
     * @param member
     */
    public void add(int member) {
        // 判断队列是否已满
        if (isFull()) {
            System.out.println("队列已满，无法添加");
        }
        near++;
        arr[near] = member;
    }

    /**
     * 出队
     *
     * @return
     */
    public int remove() {
        // 判断队列是否为空
        if (isEmpty()) {
            System.out.println("队列为空，无法出队元素");
        }
        front++;
        return arr[front];
    }

    /**
     * 取队首元素
     *
     * @return
     */
    public int peek() {
        // 判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法取队首元素");
        }
        return arr[front + 1];
    }

    /**
     * 显示队列所有元素
     */
    public void show() {
        // 判断队列是否为空
        if (isEmpty()) {
            System.out.println("队列为空");
        }
        for (int i = front+1; i < near+1; i++) {
            System.out.println(arr[i]);
        }
    }


    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        System.out.println("添加元素：1");
        arrayQueue.add(1);
        System.out.println("添加元素：2");
        arrayQueue.add(2);
        System.out.println("队首元素：" + arrayQueue.peek());
        System.out.println("显示队列所有元素");
        arrayQueue.show();
        System.out.println("移除队首元素");
        System.out.println(arrayQueue.remove());
        System.out.println("显示队列所有元素");
        arrayQueue.show();
    }
}
