package oop.basic.day04.exer3;

/**
 * @author chenyongzhi
 * @date 2019/5/13 12:29
 */
public class CylinderTest {

    public static void main(String[] args) {

        Cylinder cy = new Cylinder();

        cy.setLength(3.4);
        cy.setRadius(2.1);

        System.out.println("圆柱体的体积为：" + cy.findVolume());

        System.out.println("圆柱体的表面积为：" + cy.findArea());
    }
}
