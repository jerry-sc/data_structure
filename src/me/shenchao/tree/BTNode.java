package me.shenchao.tree;

/**
 * 二叉树结点
 */
public class BTNode<E> {

    E data;

    BTNode<E> lchild;

    BTNode<E> rchild;

    public BTNode(E data, BTNode<E> lchild, BTNode<E> rchild) {
        this.data = data;
        this.lchild = lchild;
        this.rchild = rchild;
    }

    public BTNode(E data) {
        this(data, null, null);
    }
}
