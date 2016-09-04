package me.shenchao.tree;

/**
 * 二叉树的遍历算法
 */
public class BTreeTraversing {

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

    /**
     * 先序遍历非递归实现，需要借助栈
     *
     * @param root 根结点
     */
    private static void preOrderByNotRecursion(BTNode<Character> root) {
        Stack<BTNode<Character>> stack = new Stack<>();
        BTNode<Character> p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                // 压入该结点和所有其左结点，压入前，先访问
                System.out.print(p.data + " ");
                stack.push(p);
                p = p.lchild;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                p = p.rchild;
            }
        }
    }

    /**
     * 中序遍历递归实现
     *
     * @param root 根结点
     */
    private static void inOrderByRecursion(BTNode<Character> root) {
        if (root == null) {
            return;
        }
        inOrderByRecursion(root.lchild);
        System.out.print(root.data + " ");
        inOrderByRecursion(root.rchild);
    }

    /**
     * 中序遍历非递归实现，需要借助栈
     *
     * @param root 根结点
     */
    private static void inOrderByNotRecursion(BTNode<Character> root) {
        Stack<BTNode<Character>> stack = new Stack<>();
        BTNode<Character> p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.lchild;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                // visit p
                System.out.print(p.data + " ");
                p = p.rchild;
            }
        }
    }

    /**
     * 后序遍历递归实现
     *
     * @param root 根结点
     */
    private static void postOrderByRecursion(BTNode<Character> root) {
        if (root == null) {
            return;
        }
        postOrderByRecursion(root.lchild);
        postOrderByRecursion(root.rchild);
        System.out.print(root.data + " ");
    }

    /**
     * 后序遍历非递归实现，需要借助栈
     *
     * @param root 根结点
     */
    private static void postOrderByNotRecursion(BTNode<Character> root) {
        Stack<BTNode<Character>> stack = new Stack<>();
        Stack<BTNode<Character>> tempStack = new Stack<>();
        BTNode<Character> p = root;
        while (p != null || !stack.isEmpty()) {
            // 由于后序遍历，根结点是最后一个访问的，根据栈特性，应该第一个入栈，右结点第二个入栈
            while (p != null) {
                tempStack.push(p);
                stack.push(p);
                p = p.rchild;
            }
            if (!stack.isEmpty()) {
                // 再加入左结点
                p = stack.pop();
                p = p.lchild;
            }
        }
        while (!tempStack.isEmpty()) {
            p = tempStack.pop();
            // visit
            System.out.print(p.data + " ");
        }
    }

    /**
     * 层次遍历， 借助队列完成
     * @param root 根节点
     */
    private static void levelOrder(BTNode<Character> root) {
        Queue<BTNode<Character>> queue = new Queue<>();
        if (root != null) {
            queue.push(root);
        }
        while (!queue.isEmpty()) {
            BTNode<Character> node = queue.pop();
            // visit node
            System.out.print(node.data + " ");
            if (node.lchild != null) {
                queue.push(node.lchild);
            }
            if (node.rchild != null) {
                queue.push(node.rchild);
            }
        }
    }

    public static void main(String[] args) {
        // 构建一棵二叉树
        LinkedBTree<Character> linkedBTree = new LinkedBTree<>('A');
        BTNode<Character> root = linkedBTree.root;
        BTNode<Character> nodeB = linkedBTree.add(root, 'B', true);
        BTNode<Character> nodeC = linkedBTree.add(root, 'C', false);
        BTNode<Character> nodeD = linkedBTree.add(nodeB, 'D', true);
        BTNode<Character> nodeE = linkedBTree.add(nodeB, 'E', false);
        BTNode<Character> nodeF = linkedBTree.add(nodeC, 'F', false);
        BTNode<Character> nodeG = linkedBTree.add(nodeE, 'G', true);

        // 先序遍历递归实现
        System.out.print("先序遍历递归实现： ");
        preOrderByRecursion(root);
        System.out.println();

        // 中序遍历递归实现
        System.out.print("中序遍历递归实现： ");
        inOrderByRecursion(root);
        System.out.println();

        // 后序遍历递归实现
        System.out.print("后序遍历递归实现： ");
        postOrderByRecursion(root);
        System.out.println();

        // 先序遍历非递归实现
        System.out.print("先序遍历非递归实现： ");
        preOrderByNotRecursion(root);
        System.out.println();

        // 中序遍历非递归实现
        System.out.print("中序遍历非递归实现： ");
        inOrderByNotRecursion(root);
        System.out.println();

        // 后序遍历非递归实现
        System.out.print("后序遍历非递归实现： ");
        postOrderByNotRecursion(root);
        System.out.println();

        // 层次遍历实现
        System.out.print("层次遍历实现： ");
        levelOrder(root);
        System.out.println();
    }
}
