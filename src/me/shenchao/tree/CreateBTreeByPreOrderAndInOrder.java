package me.shenchao.tree;

/**
 * 通过一棵二叉树的先序序列和中序序列唯一的确定这棵二叉树
 */
public class CreateBTreeByPreOrderAndInOrder {

    /**
     * 递归建立二叉树
     * @param preOrder 先序序列
     * @param left1 指向先序序列的左指针
     * @param right1 指向先序序列的右指针
     * @param inOrder 中序序列
     * @param left2 指向中序序列的左指针
     * @param right2 指向中序序列的右指针
     * @return 根节点
     */
    private static BTNode<Character> createBTree(char[] preOrder, int left1, int right1, char[] inOrder, int left2,int right2) {
        if (left1 > right1 || left2 > right2) {
            return null;
        }
        char rootValue = preOrder[left1];
        BTNode<Character> root = new BTNode<>(rootValue);
        // 找到根节点在中序序列中的位置，然后以此分为两半
        int pos = left2;
        while (pos < right2) {
            if (rootValue == inOrder[pos]) {
                break;
            }
            ++pos;
        }
        // 左子树的结点个数
        int offset = pos - left2 -1;
        root.lchild = createBTree(preOrder,left1+1,left1+1+offset,inOrder,left2,left2+offset);
        root.rchild = createBTree(preOrder,left1+offset+2,right1,inOrder,pos+1,right2);
        return root;
    }

    /**
     * 先序遍历递归实现
     *
     * @param root 根结点
     */
    private static void preOrderByRecursion(BTNode<Character> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrderByRecursion(root.lchild);
        preOrderByRecursion(root.rchild);
    }

    public static void main(String[] args) {
        char[] preOrder = {'A','B','H','F','D','E','C','K','G'};
        char[] inOrder = {'H','B','D','F','A','E','K','C','G'};
        BTNode<Character> root = createBTree(preOrder,0,preOrder.length-1,inOrder,0,inOrder.length-1);
        preOrderByRecursion(root);
    }
}
