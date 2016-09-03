package me.shenchao.sort;

/**
 * 冒泡排序（稳定）
 */
public class BubbleSort {

    /**
     * 冒泡排序
     *
     * @param seqList 给定顺序表
     */
    private static void bubbleSort(int[] seqList) {
        for (int i = 0; i < seqList.length; ++i) {
            // 记录这一趟排序中，是否有发生位置交换，如果没有发生，证明已经有序，退出循环即可
            boolean flag = true;
            // 注意j的大小
            for (int j = 0; j < seqList.length - 1 - i; ++j) {
                if (seqList[j + 1] < seqList[j]) {
                    swap(seqList, j, j + 1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
            print(seqList);
        }
    }

    /**
     * 交换两个位置元素
     */
    private static void swap(int[] seqList, int i, int j) {
        int temp = seqList[i];
        seqList[i] = seqList[j];
        seqList[j] = temp;
    }

    private static void print(int[] seqList) {
        for (int i = 0; i < seqList.length; ++i) {
            System.out.print(seqList[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] seqList = {49, 38, 65, 97, 76, 13, 27, 49, 55, 4};
        System.out.print("排序前： ");
        print(seqList);
        System.out.println("排序后： ");
        bubbleSort(seqList);
    }
}
