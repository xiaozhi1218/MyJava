package com.hxzy.basic.day11;

/**
 * @author chenyongzhi
 * @description 二维数组的克隆、利用foreach输出二维数组
 * @date 2019/5/8 9:50
 */
public class ArrayTest1 {
    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        int[][] arr1 = arr.clone();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("*****************");

        for (int i = 0; i < arr.length; i++) {
            arr1[i] = arr[i].clone();
        }
        arr1[0][1] = 5;

        /*for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }*/
        for (int[] x : arr1) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}
