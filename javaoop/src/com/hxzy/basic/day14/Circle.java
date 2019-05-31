package com.hxzy.basic.day14;

/**
 * @author chenyongzhi
 * @date 2019/5/13 16:52
 */
public class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
