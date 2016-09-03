package me.shenchao.sort;

/**
 * 直接插入排序（稳定），数据越有序时，插入时间越少
 */
public class StraightInsertionSort {

    /**
     * 直接插入排序
     * @param seqList 需要排序的顺序表
     */
    private static void straightInsertionSort(int[] seqList) {
        // 由于只有一个元素时本身就是有序的，所以从第二个开始
        for (int i=1;i<seqList.length;++i) {
            // 当发现后者位置较前者小时，前后交换
            for (int j=i-1; j>=0 && seqList[j+1] < seqList[j]; --j) {
                swap(seqList,j+1,j);
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
        for (int i=0; i< seqList.length; ++i) {
            System.out.print(seqList[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] seqList = {21,25,49,25,16,8};
        System.out.print("排序前： ");
        print(seqList);
        System.out.println("排序后： ");
        straightInsertionSort(seqList);
    }
}
