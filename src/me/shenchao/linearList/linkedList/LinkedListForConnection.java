package me.shenchao.linearList.linkedList;

/**
 * 单链表的连接
 */
public class LinkedListForConnection {

    private static LinkedList<Integer> initLinkedListA() {
        LinkedList<Integer> linkedListA = new LinkedList<>();
        linkedListA.addLast(3);
        linkedListA.addLast(5);
        linkedListA.addLast(8);
        linkedListA.addLast(11);
        return linkedListA;
    }

    private static LinkedList<Integer> initLinkedListB() {
        LinkedList<Integer> linkedListB = new LinkedList<>();
        linkedListB.addLast(2);
        linkedListB.addLast(6);
        linkedListB.addLast(8);
        linkedListB.addLast(9);
        linkedListB.addLast(11);
        return linkedListB;
    }

    public static void main(String[] args) {
        // 初始化链表A，B
        LinkedList<Integer> linkedListA = initLinkedListA();
        LinkedList<Integer> linkedListB = initLinkedListB();
        LinkedList<Integer> linkedListC = new LinkedList<>();
        // 令pa，pb指向链表AB的第一个结点
        Node<Integer> pa = linkedListA.header.next;
        Node<Integer> pb = linkedListB.header.next;
        // 当链表pa,pb指向的结点都不是尾结点时，依次比较两结点大小，将较小者插入新链表，并向后移动其指针
        while (pa != null && pb != null) {
            if (pa.data >= pb.data) {
                linkedListC.addLast(pb.data);
                pb = pb.next;
            } else {
                linkedListC.addLast(pa.data);
                pa = pa.next;
            }
        }
        // 当其中一个链表指针指向null后，由于链表本身就是顺序链表，直接将另一链表全部链接到末尾即可
        while (pa != null) {
            linkedListC.addLast(pa.data);
            pa = pa.next;
        }
        while (pb != null) {
            linkedListC.addLast(pb.data);
            pb = pb.next;
        }
        // 打印链表
        linkedListC.print();
    }
}
