package com.hxzy.basic.day10;

/**
 * @author chenyongzhi
 * @version v1.0
 * @Description 二维数组的复制与克隆
 * @creat 2019/5/7 10:42
 */


public class ArrayClone {
    public static void main(String[] args) {
        int[] arr1 = new int[]{3, 2, 4, 7, 1};
        //int[] arr2 = arr1;
        int[] arr2 = new int[arr1.length];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr1[i];
        }
        //int[] arr2 = arr1.clone();//克隆方法
        for (int x : arr2) {
            System.out.print(x + " ");
        }
    }
}
