package me.shenchao.queue;

/**
 * 循环队列
 */
public class CircularQueue<E> {

    private static final int QUEUE_CAPACITY = 4;

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
    public CircularQueue() {
        this.elementData = new Object[QUEUE_CAPACITY];
        this.front = 0;
        this.rear = 0;
    }

    /**
     * 入队列
     * @param data 新元素
     */
    public void push(E data) {
        // 判断队列是否已满，注意这里的区别
        if ((rear + 1) % QUEUE_CAPACITY == front) {
            throw new RuntimeException("队列已满，入队失败！");
        }
        rear = (rear+1) % QUEUE_CAPACITY;
        this.elementData[rear] = data;
    }

    /**
     * 出队列
     * @return 队头元素
     */
    public E pop() {
        // 判断队列是否为空
        if (rear == front) {
            throw new RuntimeException("队列为空，出队失败！");
        }
        front = (front + 1) % QUEUE_CAPACITY;
        return (E) this.elementData[front];
    }

    /**
     * 打印队列中元素
     */
    public void print() {
        if (rear == front) {
            System.out.println("此时为空队列！");
            return;
        }
        // 注意队列中元素个数的求法
        System.out.print("队列中共有 " + (rear - front + QUEUE_CAPACITY) % QUEUE_CAPACITY + " 个元素，内部元素为： ");
        for (int i = 1; i <= (rear - front + QUEUE_CAPACITY) % QUEUE_CAPACITY; ++i) {
            System.out.print(elementData[(i + front) % QUEUE_CAPACITY] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue<Integer> circularQueue = new CircularQueue<>();
        circularQueue.push(5);
        circularQueue.push(3);
        circularQueue.push(6);
//        circularQueue.push(8);  // 循环队列为了判定队空和队满，需要牺牲一个存储空间，因此这里再入队一元素会报错
        circularQueue.print();

        circularQueue.pop();
        circularQueue.pop();
        circularQueue.pop();
        circularQueue.print();

        // 由于是循环队列，可以继续插入元素，如果是普通队列，则会报错，因为rear指针已经指向数组末尾
        circularQueue.push(2);
        circularQueue.print();
    }
}
