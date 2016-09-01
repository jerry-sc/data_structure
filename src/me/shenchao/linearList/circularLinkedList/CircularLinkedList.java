package me.shenchao.linearList.circularLinkedList;

/**
 * 循环链表，可参照PPT中图示，更容易理解
 */
public class CircularLinkedList<E> {

    Node<E> header;

    private int size;

    public CircularLinkedList() {
        header = new Node<>();
        // 关键步骤，此条件为循环链表为空的判断条件，这也是和单链表区别的地方
        header.next = header;
        this.size = 0;
    }

    public boolean isEmpty() {
        return header.next == header;
    }

    /**
     * 在循环链表头部插入元素
     *
     * @param data 插入元素值
     */
    public void addFirst(E data) {
        Node<E> newNode = new Node<>(data);
        newNode.next = header.next;
        header.next = newNode;
        ++size;
    }

    /**
     * 在指定位置插入新元素
     *
     * @param index 插入位置
     * @param data 插入元素
     */
    public void add(int index, E data) {
        //  判断插入位置是否合法
        rangeCheckForAdd(index);
        if (index == 0) {
            addFirst(data);
        } else {
            Node<E> newNode = new Node<>(data);
            // 找到插入位置index前的结点p
            Node<E> p = findNode(index);
            newNode.next = p.next;
            p.next = newNode;
            ++size;
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

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("插入位置不合法！");
        }
    }

    public void print() {
        System.out.print("链表长度为：" + size + "，内部元素为： ");
        Node<E> node = header.next;
        // 注意循环终止条件!
        while (node != header) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularLinkedList<Integer> circularLinkedList = new CircularLinkedList<>();
        // 从链表首部插入元素
        circularLinkedList.addFirst(3);
        circularLinkedList.addFirst(8);
        circularLinkedList.addFirst(11);
        circularLinkedList.addFirst(7);
        circularLinkedList.addFirst(9);
        circularLinkedList.print();

        // 从其他位置插入
        circularLinkedList.add(5, 24);
        circularLinkedList.print();

    }
}
