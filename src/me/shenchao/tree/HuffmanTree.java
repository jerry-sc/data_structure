package me.shenchao.tree;

/**
 * 哈夫曼树，由于n个叶子结点的哈夫曼树共有2n-1个结点，所以这里使用一维数组存储
 */
public class HuffmanTree {

    /**
     * 建立哈夫曼树
     *
     * @param huffmanTree 存放哈夫曼树结点的数组
     * @param weights     叶子结点的权值，假设叶子结点全部存放在数组的前n个位置
     * @param n           叶子结点个数
     */
    public static void buildHuffmanTree(HTNode[] huffmanTree, int[] weights, int n) {
        if (n <= 1) {
            return;
        }
        // 初始化哈夫曼数组中的所有结点，-1代表没有指针指向，如果parent不为-1，说明该结点已经并入哈夫曼树
        for (int i = 0; i < huffmanTree.length; ++i) {
            HTNode newNode = new HTNode();
            newNode.weight = 0;
            newNode.parent = -1;
            newNode.lchild = -1;
            newNode.rchild = -1;
            huffmanTree[i] = newNode;
        }
        // 读入权值
        for (int i = 0; i < n; ++i) {
            huffmanTree[i].weight = weights[i];
        }
        // 构造哈夫曼树
        for (int i = 0; i < n - 1; ++i) {
            // m1,m2 存放两个无父节点且结点权值最小的两个结点
            int m1 = Integer.MAX_VALUE;
            int m2 = Integer.MAX_VALUE;
            // x1,x2 存放这两个结点的数组中位置
            int x1 = 0, x2 = 0;
            // 找出所有结点中权值最小、无父结点的两个结点，并合并之为一颗二叉树
            for (int j = 0; j < n + i; ++j) {
                if (huffmanTree[j].weight < m1 && huffmanTree[j].parent == -1) {
                    m2 = m1;
                    x2 = x1;
                    m1 = huffmanTree[j].weight;
                    x1 = j;
                } else if (huffmanTree[j].weight < m2 && huffmanTree[j].parent == -1) {
                    m2 = huffmanTree[j].weight;
                    x2 = j;
                }
            }
            huffmanTree[x1].parent = n + i;
            huffmanTree[x2].parent = n + i;
            huffmanTree[n + i].weight = huffmanTree[x1].weight + huffmanTree[x2].weight;
            huffmanTree[n + i].lchild = x1;
            huffmanTree[n + i].rchild = x2;
        }
    }

    private static void huffmanCode(HTNode[] huffmanTree, int n) {
        for (int i=0;i<n;++i) {
            int c = i;
            int p = huffmanTree[c].parent;
            // 记录编码
            StringBuilder sb = new StringBuilder();
            while (p != -1) {
                if (huffmanTree[p].lchild == c) {
                    sb.append('0');
                } else {
                    sb.append('1');
                }
                c = p;
                p = huffmanTree[c].parent;
            }
            System.out.println(sb.reverse());
        }
    }


    public static void main(String[] args) {
        // 叶子结点个数
        int n = 5;
        HTNode[] huffmanTree = new HTNode[2*n-1];
        int[] weights = {2,4,2,3,3};
        buildHuffmanTree(huffmanTree, weights,n);
        System.out.println("编码后：");
        huffmanCode(huffmanTree,n);
    }
}

/**
 * 哈夫曼树的结点
 */
class HTNode {
    // 叶子结点权重
    int weight;
    // 这里既需要双亲信息，有需要孩子信息
    int parent, lchild, rchild;

}
