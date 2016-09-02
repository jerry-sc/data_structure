package me.shenchao.queue;

/**
 * 链队列
 */
public class LinkedQueue<E> {

    private int size;

    Node<E> front;

    Node<E> rear;

    /**
     * 初始化链队列
     */
    public LinkedQueue() {
        this.size = 0;
        this.front = null;
        this.rear = null;
    }

    public boolean isEmpty() {
        return size == 0 || (this.front == null && this.rear == null);
    }

    /**
     * 入队
     * @param data 新元素
     */
    public void push(E data) {
        // 创建一个新元素
        Node<E> newNode = new Node<>(data);
        // 如果插入的是第一个结点，需要同时修改首尾指针,否则只需要修改尾置针
        if (size == 0) {
            this.front = newNode;
        } else {
            this.rear.next = newNode;
        }
        this.rear = newNode;
        ++size;
    }

    /**
     * 出队
     * @return 队头元素
     */
    public E pop() {
        // 判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，出队失败！");
        }
        // 如果队长度为1，需要同时修改首尾指针，否则只需要修改头置针
        E data = this.front.data;
        if (this.size == 1) {
            this.front = null;
            this.rear = null;
        } else {
            this.front = this.front.next;
        }
        --size;
        return data;
    }

    public void print() {
        System.out.print("链表长度为：" + size + "，内部元素为： ");
        Node<E> node = front;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
        linkedQueue.push(3);
        linkedQueue.push(7);
        linkedQueue.push(2);
        linkedQueue.push(14);
        linkedQueue.push(9);
        linkedQueue.print();

        linkedQueue.pop();
        linkedQueue.pop();
        linkedQueue.print();
    }
}