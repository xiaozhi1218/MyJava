package oop.basic.day03.exer3;

/**
 * @author chenyongzhi
 * @create 2019/5/11 18:30
 */
public class TriangleTest {

    public static void main(String[] args) {

        Triangle t1 = new Triangle();
        t1.setBase(2);
        t1.setHeight(3);
        System.out.println("base = " + t1.getBase() + ",height =" + t1.getHeight());

        Triangle t2 = new Triangle(3, 4);
        System.out.println("base = " + t2.getBase() + ",height =" + t2.getHeight());

        TriangleTest test = new TriangleTest();
        double area = test.triangleArea(t1);
        System.out.println(area);
    }

    public double triangleArea(Triangle t) {
        return t.getHeight() * t.getBase() / 2;
    }
}
