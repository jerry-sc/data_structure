package me.shenchao.tree;

/**
 * 二叉线索树结点
 */
public class BThrNode<E> {

    E data;

    BThrNode<E> lchild, rchild;
    /**
     * 若ltag为0，lchild指向左孩子，否则指向前驱，rtag为0，rchild指向右孩子，否则指向后继
     */
    int ltag,rtag;

    public BThrNode() {

    }

    public BThrNode(E data) {
        this.data = data;
    }

    public BThrNode(E data, BThrNode<E> lchild, BThrNode<E> rchild) {
        this(data);
        this.lchild = lchild;
        this.rchild = rchild;
    }
}
