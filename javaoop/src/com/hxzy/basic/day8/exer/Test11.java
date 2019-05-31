package com.hxzy.basic.day8.exer;

/**
 * @author chenyongzhi
 * @Description 11.打印:
 * 1
 * 21
 * 321
 * 4321
 * 54321
 * @date 2019/5/4 15:11
 */
public class Test11 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {//i控制行数
            for (int j = i; j >= 1; j--) {//j控制每列输出
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
