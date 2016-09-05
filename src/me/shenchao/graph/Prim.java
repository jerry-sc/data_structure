package me.shenchao.graph;

/**
 * 最小生成树，PRIM算法
 */
public class Prim {

    private static void prim(int length, int[][] adjMatrix) {
        // 记录顶点集U到i的最短距离,即U中所有点到i的距离之最小者
        int[] dis = new int[length];
        // 记录顶点是否被访问，即是否加入到了顶点集U
        boolean[] visited = new boolean[length];

        // 假设0号结点为第一个结点加入U
        visited[0] = true;
        System.out.println("加入点" + 0);
        for (int i = 1; i < length; ++i) {
            // 初始化最短距离数组，初始值为距离0号结点的距离
            dis[i] = adjMatrix[0][i];
            visited[i] = false;
        }
        // 从剩余结点中找出使得U总距离最小的结点，一共 length -1 趟
        for (int i = 0; i < length-1; ++i) {
            int min = Integer.MAX_VALUE;
            // k记录到U最小的结点编号，并加入U
            int k = -1;
            for (int j = 0; j < length; ++j) {
                if (dis[j] < min && !visited[j]) {
                    min = dis[j];
                    k = j;
                }
            }
            System.out.println("加入点" + k);
            visited[k] = true;
            // 关键！更新dis数组，使得dis中保存到U中结点最短的距离
            for (int j = 0; j < length; ++j) {
                if (adjMatrix[k][j] < dis[j] && !visited[j]) {
                    dis[j] = adjMatrix[k][j];
                }
            }
        }
    }

    public static void main(String[] args) {
        // 为了更方便测试，这里直接定义了一个二维数组作为邻接表
        int m = Integer.MAX_VALUE;
        int[][] adjMatrix = {
                {m, 8, 1, 6, m, m},
                {8, m, 5, m, 3, m},
                {1, 5, m, 7, 7, 4},
                {6, m, 7, m, m, 2},
                {m, 3, 7, m, m, 6},
                {m, m, 4, 2, 6, m}};
        prim(adjMatrix.length, adjMatrix);
    }
}
