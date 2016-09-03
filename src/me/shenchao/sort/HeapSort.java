package me.shenchao.sort;

/**
 * 堆排序（不稳定）
 */
public class HeapSort {

    /**
     * 堆排序，使用顺序表来存储完全二叉树
     *
     * @param seqList 给定顺序表
     */
    private static void heapSort(int[] seqList) {
        // 循环从第一个非叶结点开始，至根节点结束
        for (int i = seqList.length / 2; i > 0; --i) {
            // 首先将待排序列构建成一个大顶堆
            heapAdjust(seqList, i, seqList.length-1);
        }
        System.out.print("初始大顶堆建立完成： ");
        print(seqList);

        // 将堆顶记录和当前未经排序子序列的最后一个记录交换位置
        for (int i=seqList.length-1;i>1;--i) {
            swap(seqList, 1, i);
            // 重新调整为大顶堆
            heapAdjust(seqList,1,i-1);
            print(seqList);
        }
    }

    /**
     * 构建堆过程
     *
     * @param seqList 给定顺序表
     * @param i   结点编号
     * @param length  顺序表长度
     */
    private static void heapAdjust(int[] seqList, int i, int length) {
        int temp = seqList[i];
        // j 为结点i的左孩子下标
        for (int j = 2 * i; j <= length; j *= 2) {
            // 如果结点i有右孩子，那么先判断两个孩子哪个大，并用j指向
            if (j < length && seqList[j] < seqList[j + 1]) {
                ++j;
            }
            // 如果结点i的值比孩子大，那么没有必要交换，退出循环，否则进行交换
            if (temp >= seqList[j]) {
                break;
            }
            seqList[i] = seqList[j];
            // 更新i下标，并以此向下继续判断
            i = j;
        }
        seqList[i] = temp;
    }

    private static void swap(int[] seqList, int i, int j) {
        int temp = seqList[i];
        seqList[i] = seqList[j];
        seqList[j] = temp;
    }

    private static void print(int[] seqList) {
        for (int i = 1; i < seqList.length; ++i) {
            System.out.print(seqList[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 为了使获取结点的左孩子右孩子方便，元素在数组中从下标1开始，这样左孩子下标为2i,右孩子为2i+1
        int[] seqList = {-1,50,10,90,30,70,40,80,60,20};
        System.out.print("排序前： ");
        print(seqList);
        System.out.println("排序后： ");
        heapSort(seqList);
    }
}
