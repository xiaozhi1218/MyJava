package com.hxzy.basic.day9;

/**
 * @author chenyongzhi
 * @version v1.0
 * @Description 冒泡排序
 * @creat 2019/5/6 16:02
 */


public class BubbleSort {
    public static void main(String[] args) {
        int[] b = new int[]{5, 9, 1, 4, 16, 8};
        /**
         * 冒泡排序
         * N个数字要排序完成，总共进行N-1趟排序
         */
        for (int i = 0; i < b.length - 1; i++) {//外层比较 n-1 次
            for (int j = 0; j < b.length - 1 - i; j++) {//内层比较 n-1-i 次，每次比较一轮，找出一个最大的数，所以减去i次
                if (b[j] > b[j + 1]) {
                    int temp = b[j];
                    b[j] = b[j + 1];
                    b[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
    }
}
