package me.shenchao.search;

/**
 * 分块查找
 */
public class BLKSearch {

    /**
     * 分块查找
     *
     * @param indexTable   索引表
     * @param seqList      已经分好块的顺序表
     * @param addressTable 块地址表
     * @param key          查找关键字
     * @return 查找成功返回指定位置，否则返回 -1
     */
    private static int blkSearch(int[] indexTable, int[] seqList, int[] addressTable, int key) {
        // 首先通过折半查找找到所在块的起始地址
        int begin = 0, end = indexTable.length - 1, mid;
        while (begin <= end) {
            mid = (begin + end) / 2;
            if (key <= indexTable[mid]) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        // 查找完毕，begin为所在块，然后进行顺序查找
        int seqSearchEnd;
        // 如果所在块为最后一块
        if (begin == indexTable.length - 1) {
            seqSearchEnd = seqList.length;
        } else {
            seqSearchEnd = addressTable[begin + 1];
        }
        for (int i = addressTable[begin]; i < seqSearchEnd; ++i) {
            if (key == seqList[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // 此案例重在讲述如何通过分块查找找到元素，关于如何分块，如何建索引并没有实现
        int[] seqList = {22, 12, 13, 8, 9, 20, 33, 42, 44, 38, 24, 48, 60, 58, 74, 57, 86, 53};
        int[] indexTable = {22, 48, 86};
        int[] addressTable = {0, 6, 12};

        int result = blkSearch(indexTable, seqList, addressTable, 33);
        if (result != -1) {
            System.out.println("查找成功，所在位置为： " + result);
        } else {
            System.out.println("查找失败，顺序表中不存在该元素!");
        }
    }
}
