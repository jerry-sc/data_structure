package me.shenchao.tree;

/**
 * 中序线索二叉树
 */
public class ThreadedBTree<E> {

    private BThrNode<E> pre;

    /**
     * 先序线索化
     */
    public void preThreading(BThrNode<E> node) {
        if (node == null) {
            return;
        }
        // 左线索化
        if (node.lchild == null) {
            node.ltag = 1;
            node.lchild = pre;
        }
        // 右线索化
        if (pre != null && pre.rchild == null) {
            pre.rchild = node;
            pre.rtag = 1;
        }
        pre = node;
        if (node.ltag == 0) {
            preThreading(node.lchild);
        }
        if (node.rtag == 0) {
            preThreading(node.rchild);
        }
    }

    /**
     * 中序线索化
     */
    public void inThreading(BThrNode<E> node) {
        if (node == null) {
            return;
        }
        // 递归左孩子，左孩子线索化
        inThreading(node.lchild);
        if (node.lchild == null) {
            node.ltag = 1;
            node.lchild = pre;
        }
        // 右孩子线索化
        if (pre != null && pre.rchild == null) {
            pre.rtag = 1;
            pre.rchild = node;
        }
        pre = node;
        inThreading(node.rchild);
    }

    /**
     * 后序线索化
     */
    public void postThreading(BThrNode<E> node) {
        if (node == null) {
            return;
        }
        postThreading(node.lchild);
        postThreading(node.rchild);
        // 左线索化
        if (node.lchild == null) {
            node.lchild = pre;
            node.ltag = 1;
        }
        // 右线索化
        if (pre != null && pre.rchild == null) {
            pre.rchild = node;
            pre.rtag = 1;
        }
        pre = node;
    }

    /**
     * 先序遍历，非递归
     */
    public void preOrderTraverse(BThrNode<E> node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        while (node.rchild != null) {
            if (node.ltag == 0 && node.lchild != null) {
                node = node.lchild;
            } else {
                node = node.rchild;
            }
            System.out.print(node.data + " ");
        }
    }

    /**
     * 中序遍历，非递归
     */
    public void inOrderTraverse(BThrNode<E> node) {
        if (node == null) {
            return;
        }
        // 找到第一个结点
        while (node.ltag == 0) {
            node = node.lchild;
        }
        System.out.print(node.data + " ");
        while (node.rchild != null) {
            if (node.rtag == 1) {
                node = node.rchild;
            } else {
                // 如果该结点有右子树，则继续找到该子树的最左边结点
                node = node.rchild;
                while (node.ltag == 0) {
                    node = node.lchild;
                }
            }
            System.out.print(node.data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 先建立一棵二叉树
        BThrNode<Character> nodeD = new BThrNode<>('D');
        BThrNode<Character> nodeE = new BThrNode<>('E');
        BThrNode<Character> nodeF = new BThrNode<>('F');
        BThrNode<Character> nodeB = new BThrNode<>('B',nodeD,nodeE);
        BThrNode<Character> nodeC = new BThrNode<>('C',null,nodeF);
        BThrNode<Character> root = new BThrNode<>('A',nodeB,nodeC);

        ThreadedBTree<Character> threadedBTree = new ThreadedBTree<>();
        threadedBTree.inThreading(root);
        threadedBTree.inOrderTraverse(root);
    }
}
