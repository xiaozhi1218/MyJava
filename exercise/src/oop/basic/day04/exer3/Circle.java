package oop.basic.day04.exer3;

/**
 * @author chenyongzhi
 * @date 2019/5/13 11:57
 */
public class Circle {

    private double radius;

    public Circle() {
        this.radius = 1;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double findArea() {
        return Math.PI * radius * radius;
    }
}
