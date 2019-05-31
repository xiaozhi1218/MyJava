package com.hxzy.basic.day16.exer2;

/**
 * @author chenyongzhi
 * @date 2019/5/15 11:45
 */
public class Rectangle extends Shape {
    @Override
    public void draw() {
        System.out.println("画一个长方形");
    }

    @Override
    public void erase() {
        System.out.println("擦除长方形");
    }
}
