package com.hxzy.basic.day8;

/**
 * @author chenyongzhi
 * @version v1.0
 * @Description 求一个数组的和、平均值、最大值、最小值
 * @creat 2019/5/5 16:17
 */


public class ArrayTest {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 9};
        //数组求和
        //int sum = sum(arr);

        //数组求最大值方式一：
        /*int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }*/
        //数组求最大值方式二：（利用下标查找）
        //int max = getMaxIndex(arr);

        //求数组最小值：
        //int min = getMinIndex(arr);
        //double average = (double) sum / arr.length;
        //System.out.println("这个数组的元素和为：" + sum);
        //System.out.println("这个数组的元素平均值为：" + average);
        //System.out.println("这个数组的最大值的下标是" + max + ",最大值是" + arr[max]);
        //System.out.println("这个数组的最小值的下标是" + min + ",最小值是" + arr[min]);

        average(arr);
    }

    /**
     * 求一维数组元素的平均值
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
     * 获取一维数组元素的最小值及其下标
     *
     * @param arr
     * @return min
     */
    private static int getMinIndex(int[] arr) {
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[min]) {
                min = i;
            }
        }
        System.out.println("这个数组的最小值的下标是" + min + ",最小值是" + arr[min]);
        return min;
    }

    /**
     * 获取一维数组元素的最大值及其下标
     *
     * @param arr
     * @return
     */
    private static int getMaxIndex(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        return max;
    }

    /**
     * 获取一维数组的元素之和
     *
     * @param arr
     * @return sum
     */
    private static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}


