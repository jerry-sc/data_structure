package me.shenchao.linearList.doubleLinkedList;

/**
 * 双向链表结点
 */
public class DuLNode<E> {

    E data;

    DuLNode<E> next;

    DuLNode<E> prev;

    public DuLNode(E data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public DuLNode() {
        this(null);
    }
}
