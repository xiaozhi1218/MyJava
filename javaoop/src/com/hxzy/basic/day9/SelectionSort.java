package com.hxzy.basic.day9;

/**
 * @author chenyongzhi
 * @version v1.0
 * @Description 简单选择排序
 * @creat 2019/5/7 8:58
 */


public class SelectionSort {
    public static void main(String[] args) {
        int[] b = new int[]{5, 9, 1, 4, 16, 8};
        /**
         * 简单选择排序
         * 需要遍历获得最小值的次数
         * 排序N个数字，总共进行N-1趟排序
         */
        for (int i = 0; i < b.length - 1; i++) {
            int min = i;//保存最小值的下标
            // 寻找第i个小的数值
            for (int j = i + 1; j < b.length; j++) {//i=0,j从第二个位置遍历到最后一个位置
                if (b[j] < b[min]) {
                    min = j;
                }
            }
            //将找到的第i个小的数值放在第i个位置上
            if (i != min) {
                int temp = b[i];
                b[i] = b[min];
                b[min] = temp;
            }
        }
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
    }
}
