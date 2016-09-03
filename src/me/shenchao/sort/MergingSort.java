package me.shenchao.sort;

/**
 * 归并排序（稳定）
 */
public class MergingSort {

    /**
     * 二路归并
     * @param seqList 给定顺序表
     * @param left 左边界
     * @param right 右边界
     */
    private static void mergeSort(int[] seqList, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left+right) / 2;
        mergeSort(seqList, left, mid);
        mergeSort(seqList, mid + 1, right);
        merge(seqList, left, mid, right);
    }

    // 将两个有序表合并为一个表
    private static void merge(int[] seqList, int left, int mid, int right) {
        int[] tempList = new int[seqList.length];
        // r1 为第二个表的指针
        int r1 = mid+1;
        // k 为tempList表的指针
        int k = left;
        // 起始位置
        int start = left;
        while (left <= mid && r1 <= right) {
            if (seqList[left] <= seqList[r1]) {
                tempList[k++] = seqList[left++];
            } else {
                tempList[k++] = seqList[r1++];
            }
        }
        // 如果一个表指针已经到达末尾，则将另一个表的剩余元素全部加入tempList
        while (left <= mid) {
            tempList[k++] = seqList[left++];
        }
        while (r1 <= right) {
            tempList[k++] = seqList[r1++];
        }
        // 将临时数组内容复制回原数组
        while (start <= right) {
            seqList[start] = tempList[start];
            ++start;
        }
        print(seqList);
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
        mergeSort(seqList, 0, seqList.length-1);
    }
}
