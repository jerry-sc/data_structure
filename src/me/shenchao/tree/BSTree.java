package me.shenchao.tree;

import me.shenchao.linearList.circularLinkedList.Node;

/**
 * 二叉排序树
 */
public class BSTree {

    /**
     * 递归插入新结点，每次插入只在父结点为叶子结点时才插入
     * @param root 父节点
     * @param data 新结点值
     * @return 根结点
     */
    private static BSTNode insertNode(BSTNode root, int data) {
        if (root == null) {
            return new BSTNode(data);
        } else if (data < root.data) {
            root.lchild = insertNode(root.lchild, data);
        } else {
            root.rchild = insertNode(root.rchild, data);
        }
        return root;
    }

    /**
     * 查找指定值的结点
     * @param root 父节点
     * @param data 查找值
     * @return true代表找到
     */
    private static boolean search(BSTNode root, int data) {
        if (root == null) {
            return false;
        }
        if (data == root.data) {
            return true;
        } else if (data < root.data) {
            return search(root.lchild, data);
        } else {
            return search(root.rchild, data);
        }
    }

    /**
     * 删除结点
     * @param root 父节点
     * @param data 删除元素值
     * @return 根节点
     */
    private static BSTNode remove(BSTNode root, int data) {
        // 如果没有找到删除结点，什么都不做
        if (root == null) {
            return null;
        }
        if (data > root.data) {
            root.rchild = remove(root.rchild,data);
        } else if (data < root.data) {
            root.lchild = remove(root.lchild,data);
        } else {
            // 如果要删除结点 左右子树均不为空
            if (root.lchild != null && root.rchild != null) {
                // 在root的右字数中找到最小值
                root.data = findMin(root.rchild).data;
                root.rchild = remove(root.rchild, root.data);
            } else {
                // 如果存在左子树或右子树 或者 为叶子结点，直接修改指针
                root = (root.lchild != null) ? root.lchild : root.rchild;
            }
        }
        return root;
    }

    /**
     * 从某一结点出发，找到以该结点为根结点的树中的最小结点
     * @param node 给定结点
     * @return 最小结点
     */
    private static BSTNode findMin(BSTNode node) {
        while (node.lchild != null) {
            node = node.lchild;
        }
        return node;
    }

    /**
     * 中序遍历
     *
     * @param root 根结点
     */
    private static void inOrder(BSTNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.lchild);
        System.out.print(root.data + " ");
        inOrder(root.rchild);
    }

    public static void main(String[] args) {
        int[] seqList = {10,18,3,8,12,2,7,21};
        BSTNode root = new BSTNode(10);
        for (int i=1;i<seqList.length;++i) {
            root = insertNode(root, seqList[i]);
        }
        inOrder(root);
        System.out.println();
        // 查找
        if (search(root, 21)) {
            System.out.println("找到该元素");
        } else {
            System.out.println("未找到该元素");
        }
        // 删除
        root = remove(root,8);
        inOrder(root);
    }

}

class BSTNode {

    int data;
    BSTNode lchild;
    BSTNode rchild;

    public BSTNode(int data) {
        this.data = data;
    }
}
