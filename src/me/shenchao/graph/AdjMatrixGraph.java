package me.shenchao.graph;

/**
 * 图的邻接矩阵存储
 */
public class AdjMatrixGraph<E> {

    /**
     * 存放顶点数组，顶点标示
     */
    private Object[] vertexs;

    /**
     * 顶点数量
     */
    private int numOfVertex;

    /**
     * 图的邻接矩阵
     */
    private int[][] adjmatrix;

    /**
     * 初始化邻接矩阵，默认为0；
     *
     * @param n
     */
    public AdjMatrixGraph(int n) {
        vertexs = new Object[n];
        adjmatrix = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                adjmatrix[i][j] = 0;
            }
        }
    }

    /**
     * 插入顶点
     */
    public void insertVertex(E vertex) {
        vertexs[numOfVertex++] = vertex;
    }

    /**
     * 为有向图插入边
     *
     * @param v1 弧头
     * @param v2 弧尾
     */
    public void insertEdgeForDigraph(int v1, int v2) {
        adjmatrix[v1][v2] = 1;
    }

    /**
     * 为无向图插入边
     *
     * @param v1 弧头
     * @param v2 弧尾
     */
    public void insertEdgeForUndigraph(int v1, int v2) {
        adjmatrix[v1][v2] = 1;
        adjmatrix[v2][v1] = 1;
    }

    /**
     * 无向图获得某个结点的度
     *
     * @param v 顶点
     */
    public void calDegreeForUndigraph(int v) {
        int degree = 0;
        for (int i = 0; i < numOfVertex; ++i) {
            degree += adjmatrix[v][i];
        }
        System.out.println("顶点" + vertexs[v] + "的度为 " + degree);
    }

    /**
     * 有向图获得某个结点的度
     *
     * @param v 顶点
     */
    public void calDegreeForDigraph(int v) {
        int inDegree = 0;
        int outDegree = 0;
        // 统计出度
        for (int i = 0; i < numOfVertex; ++i) {
            inDegree += adjmatrix[v][i];
        }
        System.out.println("顶点" + vertexs[v] + "的出度为 " + inDegree);
        for (int i = 0; i < numOfVertex; ++i) {
            outDegree += adjmatrix[i][v];
        }
        System.out.println("顶点" + vertexs[v] + "的入度为 " + outDegree);
        System.out.println("顶点" + vertexs[v] + "的度为 " + (inDegree + outDegree));
    }

    public static void main(String[] args) {
        // 建立有向图
        AdjMatrixGraph<String> digraph = new AdjMatrixGraph<>(4);
        for (int i = 0; i < 4; ++i) {
            digraph.insertVertex("v" + i);
        }
        digraph.insertEdgeForDigraph(0, 1);
        digraph.insertEdgeForDigraph(0, 2);
        digraph.insertEdgeForDigraph(3, 0);
        digraph.insertEdgeForDigraph(2, 3);
        digraph.calDegreeForDigraph(0);
        // 建立无向图
        AdjMatrixGraph<String> unDigraph = new AdjMatrixGraph<>(4);
        for (int i = 0; i < 4; ++i) {
            unDigraph.insertVertex("v" + i);
        }
        unDigraph.insertEdgeForUndigraph(0, 1);
        unDigraph.insertEdgeForUndigraph(0, 2);
        unDigraph.insertEdgeForUndigraph(3, 0);
        unDigraph.insertEdgeForUndigraph(2, 3);

//        unDigraph.calDegreeForUndigraph(0);
    }
}
