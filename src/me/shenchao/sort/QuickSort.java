package me.shenchao.sort;

/**
 * 快速排序（不稳定）
 */
public class QuickSort {

    /**
     * 快速排序
     * @param seqList 给定线性表
     */
    private static void quickSort(int[] seqList, int left, int right) {
        if (left < right) {
            int middle = partition(seqList, left, right);
            quickSort(seqList, left, middle-1);
            quickSort(seqList, middle+1, right);
        }
    }

    /**
     * 找到seqList[left]应该所属的位置，使得其左边元素都小于它，右边都大于它
     * @param seqList 所给线性表
     * @param left 左边界
     * @param right 右边界
     * @return 所处位置
     */
    private static int partition(int[] seqList, int left, int right) {
        int pivotkey = seqList[left];
        while (left < right) {
            // 不断
            while (left < right && seqList[right] >= pivotkey) {
                --right;
            }
            seqList[left] = seqList[right];
            while (left < right && seqList[left] <= pivotkey) {
                ++left;
            }
            seqList[right] = seqList[left];
        }
        seqList[left] = pivotkey;
        print(seqList);
        return left;
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
        quickSort(seqList,0,seqList.length-1);
    }
}
