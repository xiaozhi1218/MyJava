package com.hxzy.basic.day10;

/**
 * @author chenyongzhi
 * @version v1.0
 * @description 二维数组的行求和、二维数组的转置
 * @date 2019/5/7 15:35
 */
public class ArrayTest {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[] sum = new int[4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum[i] += arr[i][j];
            }
            System.out.print(sum[i] + " ");
        }
        System.out.println();

        //转置
        int[][] arr1 = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr1[j][i] = arr[i][j];
            }
        }
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                System.out.print(arr1[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
