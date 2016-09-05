package me.shenchao.graph;

/**
 * 图的邻接表存储
 */
public class AdjListGraph {

    VNode[] vertexs;

    int size;

    public AdjListGraph(int n) {
        vertexs = new VNode[n];
    }

    /**
     * 插入顶点
     * @param from 顶点序号
     */
    public void insertVertex(int from) {
        VNode vertex = new VNode(from);
        vertexs[size++] = vertex;
    }

    /**
     * 为有向图插入边, 头插法
     * @param from 弧头
     * @param to 弧尾
     */
    public void insertEdgeForDigraph(int from, int to) {
        Edge edge = new Edge(to);
        edge.next = vertexs[from].first;
        vertexs[from].first = edge;
    }

    /**
     * 为有向图插入边
     * @param from 弧头
     * @param to 弧尾
     */
    public void insertEdgeForUndigraph(int from, int to) {
        Edge edge = new Edge(to);
        edge.next = vertexs[from].first;
        vertexs[from].first = edge;

        edge = new Edge(from);
        edge.next = vertexs[to].first;
        vertexs[to].first = edge;
    }

    /**
     * 为有向图插入边
     * @param from 弧头
     * @param to 弧尾
     */
    public void insertEdgeForWeighteddigraph(int from, int to, int weight) {
        Edge edge = new Edge(to,weight);
        edge.next = vertexs[from].first;
        vertexs[from].first = edge;
    }

    public static void main(String[] args) {
        // 有向图 邻接表存储
        AdjListGraph digraph = new AdjListGraph(4);
        for (int i=0;i<4;++i) {
            digraph.insertVertex(i);
        }
        digraph.insertEdgeForDigraph(0,1);
        digraph.insertEdgeForDigraph(0,2);
        digraph.insertEdgeForDigraph(1,3);
        digraph.insertEdgeForDigraph(3,0);

        // 无向图 邻接表存储
        AdjListGraph unDigraph = new AdjListGraph(4);
        for (int i=0;i<4;++i) {
            unDigraph.insertVertex(i);
        }
        // 对于无向图，前后顺序无关紧要
        unDigraph.insertEdgeForUndigraph(0,1);
        unDigraph.insertEdgeForUndigraph(0,2);
        unDigraph.insertEdgeForUndigraph(1,3);

        // 带权有向图
        // 无向图 邻接表存储
        AdjListGraph weightedDigraph = new AdjListGraph(4);
        for (int i=0;i<4;++i) {
            weightedDigraph.insertVertex(i);
        }
        weightedDigraph.insertEdgeForWeighteddigraph(0,1,1);
        weightedDigraph.insertEdgeForWeighteddigraph(0,3,5);
        weightedDigraph.insertEdgeForWeighteddigraph(1,2,8);
        weightedDigraph.insertEdgeForWeighteddigraph(1,3,2);
        weightedDigraph.insertEdgeForWeighteddigraph(2,0,3);
        weightedDigraph.insertEdgeForWeighteddigraph(2,1,5);
        weightedDigraph.insertEdgeForWeighteddigraph(2,3,8);
        weightedDigraph.insertEdgeForWeighteddigraph(3,2,6);

        System.out.println();
    }
}

class VNode {

    int from;
    /**
     * 以from为起点的第一条边
     */
    Edge first;

    public VNode(int from) {
        this.from = from;
        this.first = null;
    }

}

class Edge {
    /**
     * 边的终点
     */
    int to;
    /**
     * 具有同一起点的下一条边
     */
    Edge next;

    /**
     * 边权值
     */
    int weight;

    public Edge(int to) {
        this.to = to;
        this.next = null;
    }

    public Edge(int to, int weight) {
        this(to);
        this.weight = weight;
    }
}
