package me.shenchao.linearList.linkedList;

/**
 * 单链表
 */
public class LinkedList<E> {

    /**
     * 链表大小
     */
    private int size = 0;
    /**
     * 链表头结点
     */
    private Node<E> header;

    public LinkedList() {
        header = new Node<>();
    }

    /**
     * 在链表头部插入(头插法)，四个步骤
     *
     * @param data 插入元素
     */
    public void addFirst(E data) {
        // 1. 创建一个新结点
        Node<E> newNode = new Node<>(data);
        // 2. 将新结点的next域指向为header结点的next域
        newNode.next = header.next;
        // 3. 将header结点指向新结点
        header.next = newNode;
        // 4. 链表长度+1
        ++size;
    }

    /**
     * 在链表中间插入元素，6个步骤
     *
     * @param index 插入位置，从0计数
     * @param data  插入元素
     */
    public void addMiddle(int index, E data) {
        // 1. 判断插入位置是否合法
        rangeCheckForAddMiddle(index);
        // 2. 创建一个新结点
        Node<E> newNode = new Node<>(data);
        // 3. 找到插入位置index的结点p
        Node<E> p = findNode(index);
        // 4. 将新结点的next域指向p结点的next域
        newNode.next = p.next;
        // 5. 将p结点的next域指向新结点
        p.next = newNode;
        // 6. 链表长度+1
        ++size;
    }

    /**
     * 在链表尾部插入结点
     * @param data 插入元素
     */
    public void addLast(E data) {
        // 1. 创建一个新结点
        Node<E> newNode = new Node<>(data);
        // 2. 找到最后一个结点P
        Node<E> p = findNode(size);
        // 3. 将p结点的next域指向新结点
        p.next = newNode;
        // 4. 链表长度+1
        ++size;
    }

    /**
     * 判断插入位置是否合法
     *
     * @param index 插入位置
     */
    private void rangeCheckForAddMiddle(int index) {
        if (index < 1 || index >= size) {
            throw new IndexOutOfBoundsException("插入位置不合法！");
        }
    }

    /**
     * 找到指定位置的结点P
     *
     * @param index 插入位置，从0计数
     * @return 指定位置结点
     */
    private Node<E> findNode(int index) {
        Node<E> p = header;
        for (int i = 0; i < index; ++i) {
            p = p.next;
        }
        return p;
    }

    /**
     * 打印链表
     */
    public void print() {
        System.out.print("链表长度为：" + size + "，内部元素为： ");
        Node<E> node = header.next;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        // 在链表头部插入元素
        linkedList.addFirst(2);
        linkedList.addFirst(6);
        linkedList.addFirst(3);
        linkedList.addFirst(9);
        linkedList.addFirst(15);
        linkedList.print();

        // 在链表中间插入元素
        linkedList.addMiddle(4, 7);
        linkedList.print();

        // 在链表尾部插入元素
        linkedList.addLast(8);
        linkedList.print();
    }
}
