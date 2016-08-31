package me.shenchao.linearList.circularLinkedList;

/**
 * 单链表结点
 */
public class Node<E> {

    /**
     * 数据域
     */
    E data;
    /**
     * 地址域，指向直接后继
     */
    Node<E> next;

    public Node(E item, Node<E> next) {
        this.data = item;
        this.next = next;
    }

    public Node(E data) {
        this(data, null);
    }

    public Node() {
        this(null, null);
    }
}
