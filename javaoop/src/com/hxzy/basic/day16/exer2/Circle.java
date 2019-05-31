package com.hxzy.basic.day16.exer2;

/**
 * @author chenyongzhi
 * @date 2019/5/15 11:44
 */
public class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("画一个圆形");
    }

    @Override
    public void erase() {
        System.out.println("擦除圆形");
    }
}
