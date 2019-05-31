package com.hxzy.basic.day10;

import java.util.Scanner;

public class Stack {

    private int[] s;
    private int top = 0;

    public Stack(int size) {
        this.s = new int[size];
    }

    public void push(int x) {
        s[top] = x;
        top++;
    }

    public int pop() {
        top--;
        return s[top];
    }

    public boolean isFull() {
        return top == s.length ? true : false;
    }

    public boolean isEmpty() {
        return top == 0 ? true : false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack stack = new Stack(5);
        while (!stack.isFull()) {
            int x = scanner.nextInt();
            stack.push(x);
        }
        System.out.println("栈已满");
        while (!stack.isEmpty()) {
            int x = stack.pop();
            System.out.println(x);
        }
        System.out.println("已全部退栈");

    }
}
