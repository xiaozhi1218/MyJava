package oop.basic.day05.exer3;

/**
 * @author chenyongzhi
 * @date 2019/5/14 13:13
 * 写一个测试类，创建两个Circle对象，判断其颜色是否相等；
 * 利用equals方法判断其半径是否相等；利用toString()方法输出其半径。
 */
public class CircleTest {

    public static void main(String[] args) {

        Circle circle1 = new Circle(2);
        Circle circle2 = new Circle(new String("white"), 2.0, 3.3);

        System.out.println("颜色是否相等：" + circle1.getColor().equals(circle2));

        System.out.println("半径是否相等：" + circle1.equals(circle2));

        System.out.println(circle1);
        System.out.println(circle2.toString());
    }
}
