package com.hxzy.basic.day14;

/**
 * @author chenyongzhi
 * @date 2019/5/13 16:49
 */
public class Rectangle extends Shape{

    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }
}
