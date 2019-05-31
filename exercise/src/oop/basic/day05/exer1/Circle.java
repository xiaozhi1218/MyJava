package oop.basic.day05.exer1;

/**
 * @author chenyongzhi
 * @date 2019/5/14 10:57
 */
public class Circle extends GeometricObject {

    private double radius;

    public Circle(double radius, String color, double weight) {
        super(color, weight);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double findArea() {
        return Math.PI * radius *radius;
    }
}
