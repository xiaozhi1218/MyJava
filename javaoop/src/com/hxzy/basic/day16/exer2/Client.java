package com.hxzy.basic.day16.exer2;

/**
 * @author chenyongzhi
 * @date 2019/5/15 11:58
 */
public class Client {

    public static void main(String[] args) {

        Shape shape = ShapeFactory.getShape("Circle");
        shape.draw();
        shape.erase();

        Shape shape1 = ShapeFactory.getShape("Rectangle");
        shape1.draw();
        shape1.erase();
    }
}
