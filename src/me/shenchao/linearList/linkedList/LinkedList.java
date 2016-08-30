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
     * 在链表中间指定位置插入元素，6个步骤
     *
     * @param index 插入位置，从0计数
     * @param data  插入元素
     */
    public void addMiddle(int index, E data) {
        // 1. 判断插入位置是否合法
        rangeCheckForAddMiddle(index);
        // 2. 创建一个新结点
        Node<E> newNode = new Node<>(data);
        // 3. 找到插入位置index前的结点p
        Node<E> p = findNode(index);
        // 4. 将新结点的next域指向p结点的next域
        newNode.next = p.next;
        // 5. 将p结点的next域指向新结点
        p.next = newNode;
        // 6. 链表长度+1
        ++size;
    }

    /**
     * 在链表尾部插入结点，四个步骤
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
     * 删除链表第一个结点，5个步骤
     */
    public void removeFirst() {
        // 1. 判断链表是否为空
        if (header.next == null) {
            throw new RuntimeException("删除失败，因为链表为空！");
        }
        // 2. 取得第一个结点p
        Node<E> p = header.next;
        // 3. 将header的next域指向p结点的next域
        header.next = p.next;
        // 4. 将p结点的next域设为null，等待垃圾回收机制回收p内存
        p.next = null;
        // 5. 链表长度-1
        --size;
    }

    /**
     * 删除链表中间指定位置的元素，5个步骤
     *
     * @param index 删除位置
     */
    public void removeMiddle(int index) {
        // 1. 判断删除位置是否合法
        rangeCheckForRemoveMiddle(index);
        // 2. 找到删除位置index前的结点p，以及删除位置index的结点q
        Node<E> p = findNode(index);
        Node<E> q = p.next;
        // 3. 将p结点的next域指向q结点的next域
        p.next = q.next;
        // 4. 将q结点的next域设为null，等待垃圾回收机制回收q内存
        q.next = null;
        // 5. 链表长度-1
        --size;
    }

    /**
     * 删除链表尾元素
     */
    public void removeLast() {
        // 1. 判断链表是否为空
        if (header.next == null) {
            throw new RuntimeException("删除失败，因为链表为空！");
        }
        // 2. 取得倒数第二个结点p,以及最后一个结点q
        Node<E> p = findNode(size-1);
        Node<E> q = p.next;
        // 3. 将p的next域指向q的next域
        p.next = q.next;
        // 4. 链表长度-1
        --size;
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
     * 判断删除位置是否合法
     *
     * @param index 删除位置
     */
    private void rangeCheckForRemoveMiddle(int index) {
        if (index < 1 || index >= size-1) {
            throw new IndexOutOfBoundsException("删除位置不合法！");
        }
    }

    /**
     * 找到指定位置<b>前</b>的结点P
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

        // 删除第一个元素
        linkedList.removeFirst();
        linkedList.print();

        // 在链表中间删除元素
        linkedList.removeMiddle(4);
        linkedList.print();

        // 删除链表尾元素
        linkedList.removeLast();
        linkedList.print();
    }
}
