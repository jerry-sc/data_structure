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
     * @param data 插入数据
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
        linkedList.addFirst(2);
        linkedList.addFirst(6);
        linkedList.print();
    }
}
