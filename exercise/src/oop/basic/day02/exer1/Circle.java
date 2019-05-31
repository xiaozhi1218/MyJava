package oop.basic.day02.exer1;

/**
 * @author chenyongzhi
 * @create 2019/5/11 16:48
 * 定义一个Circle类，包含一个double型的radius属性代表圆的半径，
 *  一个findArea()方法返回圆的面积。
 */
public class Circle {
    double radius;

    public double findArea() {
        return Math.PI * radius * radius;
    }
}
