package com.hxzy.basic.day9;

import java.util.Scanner;

/**
 * @author chenyongzhi
 * @version v1.0
 * @Description 一维数组的应用：
 * 求和（平均值）
 * 找最大值（最小值）
 * 移位
 * 倒序
 * 查找（顺序查找、二分法查找）
 * 插入删除
 * 排序
 * 数组与数据结构（栈、队列）
 * @creat 2019/5/6 9:55
 */

public class ArrayTest1 {
    public static void main(String[] args) {
        int[] b = new int[]{5, 9, 1, 4, 16, 8};
        arrayOut(b);
        /*int sum = sum(b);
        average(b);
        int max = getMaxIndex(b);
        int min = getMinIndex(b);
        arrayShiftLeft(b);
        arrayRightLeft(b);
        arrayReversedOrder(b);
        sequentialSearch(b);*/
    }

    /**
     * 一维数组元素依次向右移动一位
     *
     * @param b
     */
    private static void arrayRightLeft(int[] b) {
        int temp = b[b.length - 1];
        for (int i = b.length - 1; i > 0; i--) {
            b[i] = b[i - 1];
        }
        b[0] = temp;
        arrayOut(b);
    }

    /**
     * 求一维数组元素的平均值
     *
     * @param arr
     */
    private static void average(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        double average = (double) sum / arr.length;
        System.out.println("平均值为：" + average);
    }

    /**
     * 顺序查找一个一维数组中的元素值
     *
     * @param b
     */
    private static void sequentialSearch(int[] b) {
        int index = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查找的值：");
        int x = scanner.nextInt();
        for (int i = 0; i < b.length; i++) {
            if (b[i] == x) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            System.out.println("找到了,其下标为：" + index);
        } else {
            System.out.println("没有找到");
        }
    }

    /**
     * 将一个一维数组逆序输出
     *
     * @param b
     */
    private static void arrayReversedOrder(int[] b) {
        for (int i = 0, j = b.length - 1; i < j; i++, j--) {
            int temp = b[i];
            b[i] = b[j];
            b[j] = temp;

        }
        arrayOut(b);
    }

    /**
     * 一维数组元素依次向左移动一位
     *
     * @param b
     */
    private static void arrayShiftLeft(int[] b) {
        int temp = b[0];
        for (int i = 0; i < b.length - 1; i++) {
            b[i] = b[i + 1];
        }
        b[b.length - 1] = temp;
        arrayOut(b);
    }

    /**
     * 输出所有一维数组的元素
     *
     * @param a
     */
    private static void arrayOut(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    /**
     * 获取一维数组的元素和
     *
     * @param arr
     * @return sum
     */
    private static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("数组元素的和为：" + sum);
        return sum;
    }

    /**
     * 获取一维数组元素的最大值及其下标
     *
     * @param arr
     * @return maxIndex
     */
    private static int getMaxIndex(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        System.out.println("这个数组的最大值的下标是" + max + ",值为" + arr[max]);
        return max;
    }

    /**
     * 获取一维数组元素的最小值及其下标
     *
     * @param arr
     * @return minIndex
     */
    private static int getMinIndex(int[] arr) {
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[min]) {
                min = i;
            }
        }
        System.out.println("这个数组的最小值的下标是" + min + ",值为" + arr[min]);
        return min;
    }
}

