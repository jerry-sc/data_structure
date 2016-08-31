package me.shenchao.linearList.circularLinkedList;

/**
 * 循环链表
 */
public class CircularLinkedList<E> {

    Node<E> header;

    private int size;

    public CircularLinkedList() {
        header = new Node<>();
        // 此条件为循环链表为空的判断条件
        header.next = header;
        this.size = 0;
    }

    /**
     * 在链表首部插入新元素(头插法)
     * @param data 插入元素值
     */
    public void addFirst(E data) {
        Node<E> newNode = new Node<>(data);
        newNode.next = header.next;
        header.next = newNode;

    }

    public static void main(String[] args) {

    }
}
