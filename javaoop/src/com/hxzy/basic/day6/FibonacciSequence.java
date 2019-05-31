package com.hxzy.basic.day6;

/**
 * 输出斐波那契数列
 */
public class FibonacciSequence {
    public static void main(String[] args) {
        int a = 1, b = 1, c;
        System.out.print(a + " " + b);
        for (int i = 0; i < 18; i++) {
            c = a + b;
            a = b;
            b = c;
            System.out.print(" " + c);
        }
    }
}
