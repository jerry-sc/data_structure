package me.shenchao.graph;

/**
 * 最小生成树，Kruskal算法
 */
public class Kruskal {

    private static void kruskal(int[][] vertexs, int num) {
        // // 用于保存"已有最小生成树"中每个顶点在该最小树中的终点
        int[] dest = new int[num];
        // 结果数组，保存kruskal最小生成树的边
        EdgeData[] rets = new EdgeData[num];
        // edges 存放所有边
        EdgeData[] edges = getAllEdges(vertexs,num);
        // 从小到大排序所有边
        sortEdges(edges);
        int index = 0;
        for (int i=0;i<num;++i) {
            // 获取第i条边的开始与结束顶点
            int start = edges[i].start;
            int end = edges[i].end;
            // 获取顶点start,end的终点
            int m = getEnd(dest,start);
            int n = getEnd(dest,end);
            // m !=n  说明没有形成环路，加入
            if (m!=n) {
                // 设置m在"已有的最小生成树"中的终点为n
                dest[m] = n;
                // 加入新的边
                rets[index++] = edges[i];
                System.out.println("新加入一条顶点分别为" + edges[i].start + "和" + edges[i].end + ",权值为" + edges[i].weight + "的边");
            }
        }
    }

    /**
     * 获取i的终点
     */
    private static int getEnd(int[] vends, int i) {
        while (vends[i] != 0)
            i = vends[i];
        return i;
    }

    /**
     * 冒泡排序
     */
    private static void sortEdges(EdgeData[] edges) {
        for (int i = 0; i < edges.length; ++i) {
            // 记录这一趟排序中，是否有发生位置交换，如果没有发生，证明已经有序，退出循环即可
            boolean flag = true;
            // 注意j的大小
            for (int j = 0; j < edges.length - 1 - i; ++j) {
                if (edges[j + 1].weight < edges[j].weight) {
                    EdgeData temp = edges[j];
                    edges[j] = edges[j+1];
                    edges[j+1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    /**
     * 返回所有边
     * @param vertexs 邻接矩阵
     */
    private static EdgeData[] getAllEdges(int[][] vertexs,int num) {
        int index = 0;
        EdgeData[] edges = new EdgeData[num];
        for (int i=0;i<vertexs.length;++i) {
            for (int j=i+1;j<vertexs.length;++j) {
                if (vertexs[i][j] != Integer.MAX_VALUE) {
                    edges[index++] = new EdgeData(i,j,vertexs[i][j]);
                }
            }
        }
        return edges;
    }

    /**
     * 获取图的边数目
     */
    private static int getNumOfEdges(int[][] vertexs) {
        int num = 0;
        for (int i=0;i<vertexs.length;++i) {
            for (int j=i+1;j<vertexs.length;++j) {
                if (vertexs[i][j] != Integer.MAX_VALUE) {
                    ++num;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int m = Integer.MAX_VALUE;
        int[][] adjMatrix = {
                {m, 8, 1, 6, m, m},
                {8, m, 5, m, 3, m},
                {1, 5, m, 7, 7, 4},
                {6, m, 7, m, m, 2},
                {m, 3, 7, m, m, 6},
                {m, m, 4, 2, 6, m}};
        // 统计边数量，这里直接数
        int numOfEdges = getNumOfEdges(adjMatrix);
        kruskal(adjMatrix,numOfEdges);
    }
}

/**
 * 存储边
 */
class EdgeData {
    /**
     * 边起点
     */
    int start;
    /**
     * 边终点
     */
    int end;
    /**
     * 边权值
     */
    int weight;

    public EdgeData(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

