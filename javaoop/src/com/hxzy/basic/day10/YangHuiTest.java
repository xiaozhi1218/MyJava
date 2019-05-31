package com.hxzy.basic.day10;

/**
 * @author chenyongzhi
 * @version v1.0
 * @description
 * @date 2019/5/7 14:50
 */
public class YangHuiTest {

    public static void main(String[] args) {
        //1.声明并初始化二维数组
        int[][] yangHui = new int[5][];

        //2.给数组的元素赋值
        for (int i = 0; i < yangHui.length; i++) {
            yangHui[i] = new int[i + 1];//给每行创建列元素。例如：第0行有一个，第1行有2个，以此类推。

            //2.1 给首末元素赋值
            yangHui[i][0] = yangHui[i][i] = 1;
            //2.2 给每行的非首末元素赋值
            //if(i > 1){//i为0或1时都进不去下面循环
            for (int j = 1; j < yangHui[i].length - 1; j++) {//第二个元素开始到倒数第二个元素
                yangHui[i][j] = yangHui[i - 1][j - 1] + yangHui[i - 1][j];//第ij个元素等于它上方的元素加上左上方的元素
            }
            //}
        }


        //3.遍历二维数组
        for (int i = 0; i < yangHui.length; i++) {
            for (int j = 0; j < yangHui[i].length; j++) {
                System.out.print(yangHui[i][j] + "  ");
            }
            System.out.println();
        }


    }


}
