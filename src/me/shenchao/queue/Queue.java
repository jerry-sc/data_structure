package me.shenchao.queue;

/**
 * 队列
 */
public class Queue<E> {

    /**
     * 初始化队列的最大容量为1000
     */
    private static final int QUEUE_CAPACITY = 1000;

    private Object[] elementData;

    /**
     * 指向队列的前端
     */
    private int front;

    /**
     * 指向队列的后端
     */
    private int rear;

    /**
     * 初始化队列，此时为空队列
     */
    public Queue() {
        this.elementData = new Object[QUEUE_CAPACITY];
        this.front = -1;
        this.rear = -1;
    }

    /**
     * 判断队列是否为空
     * @return 如果为空返回true
     */
    public boolean isEmpty() {
        return this.front == this.rear;
    }

    /**
     * 入队列
     * @param data 新元素
     */
    public void push(E data) {
        // 判断队列是否已满
        if (this.rear + 1 >= QUEUE_CAPACITY) {
            throw new RuntimeException("队列已满，入队失败！");
        }
        ++rear;
        this.elementData[rear] = data;
    }

    /**
     * 出队列
     * @return 队头元素
     */
    public E pop() {
        // 判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，出队失败！");
        }
        ++front;
        return (E) this.elementData[front];

    }

    /**
     * 取队头元素
     * @return 队头元素
     */
    public E peek() {
        // 判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，获取队头失败！");
        }
        return (E) this.elementData[front+1];
    }

    /**
     * 打印队列中元素
     */
    public void print() {
        if (isEmpty()) {
            System.out.println("此时为空队列！");
            return;
        }
        System.out.print("队列中共有 " + (rear - front) + " 个元素，内部元素为： ");
        for (int i = front+1; i <= rear; ++i) {
            System.out.print(elementData[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 初始化队列
        Queue<Integer> queue = new Queue<>();

        // 入队
        queue.push(4);
        queue.push(2);
        queue.push(8);
        queue.push(7);
        queue.push(15);
        queue.print();

        // 出队
        queue.pop();
        queue.print();

        // 获取队头元素
        System.out.println(queue.peek());
    }
}
