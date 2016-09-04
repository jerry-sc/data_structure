package me.shenchao.tree;

/**
 * 二叉树的链表实现
 */
public class LinkedBTree<E> {

    /**
     * 根结点
     */
    BTNode<E> root;

    public LinkedBTree(E data) {
        root = new BTNode<E>(data);
    }


    /**
     * 为指定结点添加子结点
     * @param parent 需要添加节点的父节点的索引
     * @param data 新结点数据
     * @param isLeft 是否添加左孩子
     * @return 新增结点
     */
    public BTNode<E> add(BTNode<E> parent, E data, boolean isLeft) {
        if(parent == null){
            throw new RuntimeException(parent + "节点为空，不能添加子节点！");
        }
        BTNode<E> newNode = new BTNode<E>(data);
        if (isLeft) {
            parent.lchild = newNode;
        } else {
            parent.rchild = newNode;
        }
        return newNode;
    }

    public void printChild(BTNode<E> parent) {
        System.out.println("结点" + getString(parent) + "的孩子结点为：" + getString(parent.lchild) + "和" + getString(parent.rchild));
    }

    private Object getString(BTNode<E> node) {
        if (node == null) {
            return "空";
        } else {
            return node.data;
        }
    }

    public static void main(String[] args) {
        LinkedBTree<Character> linkedBTree = new LinkedBTree<>('A');
        BTNode<Character> nodeB = linkedBTree.add(linkedBTree.root, 'B', true);
        BTNode<Character> nodeC = linkedBTree.add(linkedBTree.root, 'C', false);
        BTNode<Character> nodeD = linkedBTree.add(nodeB, 'D', true);
        BTNode<Character> nodeE = linkedBTree.add(nodeB, 'E', false);
        BTNode<Character> nodeF = linkedBTree.add(nodeC, 'F', false);
        BTNode<Character> nodeG = linkedBTree.add(nodeE, 'G', true);

        // 测试，输出某个结点的孩子结点
        linkedBTree.printChild(nodeF);
    }
}
