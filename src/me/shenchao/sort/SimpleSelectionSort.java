package me.shenchao.sort;

/**
 * 简单选择排序（不稳定）
 */
public class SimpleSelectionSort {

    /**
     * 简单选择排序
     *
     * @param seqList 给定顺序表
     */
    private static void simpleSelectionSort(int[] seqList) {
        for (int i = 0; i < seqList.length; ++i) {
            // 记录最小元素值
            int min = seqList[i];
            // 记录最小元素所在下标
            int position = i;
            for (int j = i + 1; j < seqList.length; ++j) {
                if (seqList[j] < min) {
                    min = seqList[j];
                    position = j;
                }
            }
            seqList[position] = seqList[i];
            seqList[i] = min;
            print(seqList);
        }
    }

    private static void print(int[] seqList) {
        for (int i = 0; i < seqList.length; ++i) {
            System.out.print(seqList[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] seqList = {49, 38, 65, 97, 76, 13, 27, 48, 55, 4};
        System.out.print("排序前： ");
        print(seqList);
        System.out.println("排序后： ");
        simpleSelectionSort(seqList);
    }
}
