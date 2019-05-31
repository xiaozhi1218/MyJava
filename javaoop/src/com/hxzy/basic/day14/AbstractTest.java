package com.hxzy.basic.day14;

/**
 * @author chenyongzhi
 * @date 2019/5/13 16:53
 */
public class AbstractTest {

    public static void main(String[] args) {

        Shape shape1 = new Rectangle(2, 3);
        Shape shape2 = new Circle(2);

        System.out.println(shape1.area());
        System.out.println(shape2.area());
    }
}
