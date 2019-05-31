package oop.basic.day05.exer3;

/**
 * @author chenyongzhi
 * @date 2019/5/14 13:03
 */
public class Circle extends GeometricObject{

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, double weight, double radius) {
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
        return Math.PI * radius * radius;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Circle) {
            Circle circle = (Circle) obj;
            return this.radius == circle.radius;
        }
        return false;
    }

//    @Override
//    public String toString() {
//        return "Circle [radius=" + radius +"]";
//    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
