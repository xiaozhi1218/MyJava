package oop.basic.day01.exer1;

/**
 * @author chenyongzhi
 * @description
 * @create 2019/5/11 13:32
 */
public class Circle {

    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double findArea() {
        double area = Math.PI * radius * radius;
        return area;
    }
}
