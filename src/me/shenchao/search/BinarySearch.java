package me.shenchao.search;

/**
 * 折半查找
 */
public class BinarySearch {

    /**
     * 二分查找
     *
     * @param seqList 已经排序好的顺序表
     * @param key     查找关键字
     * @return 查找成功返回指定位置，否则返回 -1
     */
    private static int binarySearch(int[] seqList, int key) {
        int begin = 0, end = seqList.length - 1, mid;
        while (begin <= end) {
            mid = (begin + end) / 2;
            if (seqList[mid] == key) {
                return mid;
            } else if (key < seqList[mid]) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int seqList[] = {5, 13, 19, 21, 37, 56, 64, 75, 80, 88, 92};
        int result = binarySearch(seqList, 21);
        if (result != -1) {
            System.out.println("查找成功，所在位置为： " + result);
        } else {
            System.out.println("查找失败，顺序表中不存在该元素!");
        }
    }
}
