package com.hxzy.basic.day16.exer2;


/**
 * @author chenyongzhi
 * @date 2019/5/15 11:47
 */
public class ShapeFactory {

    private ShapeFactory() {

    }

    public static Shape getShape(String type) {
        //Shape shape = null;
        if (type.equalsIgnoreCase("Circle")) {
            Shape shape = new Circle();
            System.out.println("初始化圆形");
        } else if (type.equalsIgnoreCase("Rectangle")) {
            Shape shape = new Rectangle();
            System.out.println("初始化长方形");
        } else if (type.equalsIgnoreCase("Triangle")) {
            Shape shape = new Triangle();
            System.out.println("初始化三角形");
        }
        return null;
    }
}

