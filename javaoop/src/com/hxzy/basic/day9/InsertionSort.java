package com.hxzy.basic.day9;

/**
 * @author chenyongzhi
 * @version v1.0
 * @Description  插入排序
 * @creat 2019/5/6 17:01
 */


public class InsertionSort {
    public static void main(String[] args) {
        int[] b = new int[]{5, 9, 1, 4, 16, 8};
        /*for (int i = 0; i < b.length; i++) {
            int t = b[i];
            for (int j = b.length - 1; j >= 0 && b[j] > t; j++) {
                b[j + 1] = b[j];
            }
        }*/
        for (int i = 1; i < b.length; i++) {
            int temp = b[i];//保存每次需要插入的那个数
            int j;
            for (j = i; j > 0 && b[j - 1] > temp; j--) {//这个较上面有一定的优化
                b[j] = b[j - 1];//吧大于需要插入的数往后移动。最后不大于temp的数就空出来j
            }
            b[j] = temp;//将需要插入的数放入这个位置
        }
        for (int x : b) {
            System.out.print(x + " ");
        }
    }
}

