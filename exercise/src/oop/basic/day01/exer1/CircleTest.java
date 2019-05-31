package oop.basic.day01.exer1;

/**
 * @author chenyongzhi
 * @description
 * 2.利用面向对象的编程方法，设计类Circle计算圆的面积。
 * @create 2019/5/11 13:32
 */
public class CircleTest {

    public static void main(String[] args) {

        Circle c1 = new Circle();
        c1.setRadius(10);
        System.out.println("半径为" + c1.getRadius() + "的圆的面积为：" + c1.findArea());

    }
}
