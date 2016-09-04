package me.shenchao.tree;

import java.util.Arrays;

/**
 * 二叉树的顺序存储，假设存储从下标1开始，这样左孩子下标为父结点下标×2，右孩子为父节点下标×2+1
 */
public class SeqBTree<E> {

    private Object[] elementData;

    public SeqBTree() {
        // 初始化数组容量为1000
        this.elementData = new Object[1000];
    }

    /**
     * 初始化带根节点的二叉树，根节点存储在下标为1的位置
     *
     * @param data 新的子节点的数据
     */
    public SeqBTree(E data) {
        this();
        elementData[1] = data;
    }

    /**
     * 为指定结点添加子节点
     *
     * @param index  需要添加子节点的父节点索引
     * @param data   新的子节点的数据
     * @param isLeft 是否为左节点
     */
    public void add(int index, E data, boolean isLeft) {
        if (elementData[index] == null) {
            throw new RuntimeException(index + "处节点为空，无法添加子节点！");
        }
        if (2 * index >= elementData.length || 2 * index + 1 >= elementData.length) {
            throw new RuntimeException("树底层数组已满");
        }
        if (isLeft) {
            elementData[2 * index] = data;
        } else {
            elementData[2 * index + 1] = data;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(elementData);
    }

    public void print() {
        System.out.println(toString());
    }

    public static void main(String[] args) {
        SeqBTree<Character> seqBTree = new SeqBTree<>('A');
        seqBTree.add(1, 'B', true);
        seqBTree.add(1, 'C', false);
        seqBTree.add(2, 'D', true);
        seqBTree.add(2, 'E', false);
        seqBTree.add(3, 'F', false);
        seqBTree.add(5, 'G', true);
        seqBTree.print();
    }
}
