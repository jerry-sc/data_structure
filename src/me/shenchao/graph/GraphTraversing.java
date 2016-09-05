package me.shenchao.graph;

/**
 * 图遍历，以有向图为例
 */
public class GraphTraversing {

    private boolean[] visited;

    private VNode[] vertexs;

    public GraphTraversing(int n, AdjListGraph graph ) {
        this.visited = new boolean[n];
        this.vertexs = graph.vertexs;
        clear();
    }

    public void clear() {
        for (int i=0;i<visited.length;++i) {
            visited[i] = false;
        }
    }

    /**
     * 深度优先遍历
     * @param v 起始结点
     */
    private void dfs(int v) {
        visited[v] = true;
        // 访问结点v
        System.out.print(vertexs[v].data + " ");
        Edge edge = vertexs[v].first;
        while (edge != null) {
            // 如果未访问过，继续访问
            if (!visited[edge.to]) {
                dfs(edge.to);
            }
            // 直到一条分支结束，切换另一条
            edge = edge.next;
        }
    }

    /**
     * 广度优先遍历，需要借助队列
     * @param v 起始结点
     */
    public void bfs(int v) {
        // 队列存放即将要访问结点的序号
        Queue<Integer> queue = new Queue<>();
        queue.push(v);
        while (!queue.isEmpty()) {
            // pop，并访问
            v = queue.pop();
            System.out.print(vertexs[v].data + " ");
            visited[v] = true;
            // 然后将其所有的未访问的后继结点入队
            Edge edge = vertexs[v].first;
            while (edge != null) {
                if (!visited[edge.to]) {
                    queue.push(edge.to);
                }
                edge = edge.next;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 有向图 邻接表存储
        AdjListGraph digraph = new AdjListGraph(5);
        for (int i=0;i<5;++i) {
            digraph.insertVertex(i, (char) ('A'+i));
        }
        digraph.insertEdgeForDigraph(0,1);
        digraph.insertEdgeForDigraph(0,3);
        digraph.insertEdgeForDigraph(1,2);
        digraph.insertEdgeForDigraph(2,3);
        digraph.insertEdgeForDigraph(3,4);
        digraph.insertEdgeForDigraph(4,0);

        GraphTraversing graphTraversing = new GraphTraversing(5,digraph);
        graphTraversing.dfs(0);
        graphTraversing.clear();
        System.out.println();
        graphTraversing.bfs(0);
    }
}
