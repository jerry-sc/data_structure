package me.shenchao.sort;

/**
 * 希尔排序（不稳定），也称缩小增量排序，希尔排序内部使用的是直接插入排序算法，
 * 而且希尔排序每趟排序都会将整个序列变得相对有序，所以越到后来数据越有序，直接插入速度更快
 */
public class ShellSort {

    /**
     * 希尔排序
     *
     * @param seqList 给定线性表
     * @param step    初始步长，这里定为线性表长度的一半
     */
    private static void shellSort(int[] seqList, int step) {
        // 直到步长为1停止算法
        while (step != 1) {
            // 缩小步长，策略为每次为上一次的一半
            step /= 2;
            for (int i = 0; i < step; ++i) {
                // 以固定步长找到相应的序列，并进行直接插入排序
                for (int j = i + step; j < seqList.length; j += step) {
                    // 直接插入排序
                    for (int k = j - step; k >= 0 && seqList[k + step] < seqList[k]; k -= step) {
                        swap(seqList, k + step, k);
                    }
                }
            }
            // 打印每趟结果
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
        shellSort(seqList, seqList.length);
    }
}
