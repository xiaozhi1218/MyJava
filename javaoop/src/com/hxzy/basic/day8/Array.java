package com.hxzy.basic.day8;

/**
 * @author chenyongzhi
 * @Description 1.一维数组的定义及使用
 * @creat 2019/5/5 15:10
 */


public class Array {
    public static void main(String[] args) {
        /*
            利用数组输出斐波那契数列前20个数
         */
        int[] a = new int[20];//定义数组
        a[0] = a[1] = 1;//前两个元素赋值为1
        //利用循环给第2个元素到第19个元素赋值
        for (int i = 2; i < a.length; i++) {//从a[2]开始给数组元素依次赋值
            a[i] = a[i - 1] + a[i - 2];//
        }

        arrOut(a);
        System.out.println();

        int[] b = new int[]{1, 2, 3, 4};
        arrOut(b);

        System.out.println();

        int[] c = new int[3];
        arrOut(c);
    }
    /**
     * 一维数组的输出方法
     * @param a
     */
    private static void arrOut(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
