package com.hxzy.basic.day12;

/**
 * @author chenyongzhi
 * @description
 * @date 2019/5/9 15:16
 */
public class AreaOfCircle {
    private static final double PI = 3.1415926535897932;
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void showArea(){
        double s = PI * radius * radius;
        System.out.println("面积为：" + s);
    }
}

class Test1 {
    public static void main(String[] args) {
        AreaOfCircle c1 = new AreaOfCircle();
        c1.setRadius(10);
        c1.showArea();
    }
}
