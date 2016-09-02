package me.shenchao.search;

/**
 * 顺序查找
 */
public class SeqSearch {

    /**
     * 在顺序表中查找指定元素
     *
     * @param seqList 给定顺序表
     * @param key     查找关键字
     * @return 查找成功返回指定位置，否则返回 -1
     */
    private static int seqSearch(int[] seqList, int key) {
        for (int i = 0; i < seqList.length; ++i) {
            if (seqList[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int seqList[] = {5, 13, 19, 21, 37, 56, 64, 75, 80, 88, 92};
        int result = seqSearch(seqList, 6);
        if (result != -1) {
            System.out.println("查找成功，所在位置为： " + result);
        } else {
            System.out.println("查找失败，顺序表中不存在该元素!");
        }
    }
}
