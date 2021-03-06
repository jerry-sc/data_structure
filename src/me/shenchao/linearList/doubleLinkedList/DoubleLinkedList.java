package me.shenchao.linearList.doubleLinkedList;

/**
 * 双向链表
 */
public class DoubleLinkedList<E> {

    private int size;

    DuLNode<E> header;

    public DoubleLinkedList() {
        this.header = new DuLNode<>();
        this.size = 0;
    }

    /**
     * 在双链表首部插入新元素
     *
     * @param data 插入的元素值
     */
    public void addFirst(E data) {
        DuLNode<E> newNode = new DuLNode<>(data);
        // 如果是第一个插入的元素
        if (header.next == null) {
            header.next = newNode;
        } else {
            // 将原首结点的前驱结点修改为新结点
            header.next.prev = newNode;
            // 将新结点的后继结点修改为原首结点
            newNode.next = header.next;
            // 将首结点修改为新结点
            header.next = newNode;
        }
        ++size;
    }

    /**
     * 在指定位置插入新元素
     *
     * @param index 插入位置
     * @param data 插入元素
     */
    public void add(int index, E data) {
        // 判断插入位置是否合法
        rangeCheckForAdd(index);
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size) {
            addLast(data);
            return;
        }
        // 创建一个新结点
        DuLNode<E> newNode = new DuLNode<>(data);
        // 找到插入位置index前的结点p
        DuLNode<E> p = findNode(index);
        // 修改指针，四个步骤，注意顺序
        newNode.next = p.next;
        newNode.prev = p;
        p.next.prev = newNode;
        p.next = newNode;

        ++size;
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("插入位置不合法！");
        }
    }

    /**
     * 在双链表末尾插入新元素
     *
     * @param data 新元素值
     */
    public void addLast(E data) {
        // 创建一个新结点
        DuLNode<E> newNode = new DuLNode<>(data);
        // 找到最后一个结点P
        DuLNode<E> p = findNode(size);
        // 3. 将p结点的next域指向新结点
        newNode.prev = p;
        p.next = newNode;
        ++size;
    }

    /**
     * 删除双链表中第一个结点
     */
    public void removeFirst() {
        // 判断链表是否为空
        if (header.next == null) {
            throw new RuntimeException("删除失败，因为链表为空！");
        }
        // 如果双链表中只有一个结点
        if (size == 1) {
            removeOnlyNode();
        } else {
            // 取得第一个结点
            DuLNode<E> p = header.next;
            header.next = p.next;
            p.next.prev = null;
            p.next = null;
            --size;
        }
    }

    /**
     * 删除双链表最后一个结点
     */
    public void removeLast() {
        // 判断链表是否为空
        if (header.next == null) {
            throw new RuntimeException("删除失败，因为链表为空！");
        }
        // 如果只有一个结点
        if (size == 1) {
            removeOnlyNode();
        } else {
            // 取得倒数第二个结点p,以及最后一个结点q
            DuLNode<E> p = findNode(size - 1);
            DuLNode<E> q = p.next;
            // 修改指针域
            p.next = q.next;
            q.prev = null;
            // 4. 链表长度-1
            --size;
        }
    }

    /**
     * 删除链表中间指定位置的元素
     *
     * @param index 删除位置
     */
    public void remove(int index) {
        // 判断链表是否为空
        if (header.next == null) {
            throw new RuntimeException("删除失败，因为链表为空！");
        }
        // 2. 判断删除位置是否合法
        rangeCheckForRemove(index);
        // 如果只有一个结点
        if (size == 1) {
            removeOnlyNode();
            return;
        }
        if (index == 0) {
            removeFirst();
            return;
        }
        if (index == size - 1) {
            removeLast();
            return;
        }
        // 找到删除位置index前的结点p，以及删除位置index的结点q
        DuLNode<E> p = findNode(index);
        DuLNode<E> q = p.next;
        // 修改指针域
        p.next = q.next;
        q.next.prev = p;
        q.prev = null;
        q.next = null;

        --size;
    }

    private void rangeCheckForRemove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("删除位置不合法！");
        }
    }

    /**
     * 如果链表中只有一个元素
     */
    private void removeOnlyNode() {
        header.next = null;
        --size;
    }

    /**
     * 找到指定位置<b>前</b>的结点P
     *
     * @param index 插入位置，从0计数
     * @return 指定位置结点
     */
    private DuLNode<E> findNode(int index) {
        DuLNode<E> p = header;
        for (int i = 0; i < index; ++i) {
            p = p.next;
        }
        return p;
    }

    public void print() {
        System.out.print("链表长度为：" + size + "，内部元素为： ");
        DuLNode<E> node = header.next;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
        doubleLinkedList.addFirst(2);
        doubleLinkedList.addFirst(8);
        doubleLinkedList.addFirst(13);
        doubleLinkedList.addFirst(7);
        doubleLinkedList.addFirst(9);
        doubleLinkedList.print();

        // 在双链表尾部插入结点
        doubleLinkedList.addLast(6);
        doubleLinkedList.print();

        // 在指定位置插入结点
        doubleLinkedList.add(1, 4);
        doubleLinkedList.print();

        // 删除第一个结点
        doubleLinkedList.removeFirst();
        doubleLinkedList.print();

        // 删除最后一个结点
        doubleLinkedList.removeLast();
        doubleLinkedList.print();

        // 删除指定位置的结点
        doubleLinkedList.remove(1);
        doubleLinkedList.print();
    }
}
