package oop.basic.day07.exer4;

/**
 * 定义一个Circle类，声明radius属性，提供getter和setter方法
 * @author chenyongzhi
 * @create 2019/5/19 22:06
 */
public class Circle {

    private Double radius;

    public Circle() {
    }

    public Circle(Double radius) {
        this.radius = radius;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }
}
