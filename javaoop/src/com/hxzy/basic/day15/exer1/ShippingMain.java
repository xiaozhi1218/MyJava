package com.hxzy.basic.day15.exer1;

/**
 * @author chenyongzhi
 * @date 2019/5/14 9:47
 */
public class ShippingMain {

    public static void main(String[] args) {

        Company company = new Company();

        Car car = new Car();
        RiverBarge riverBarge = new RiverBarge();

        company.reportFuel(car);
        company.reportDistance(car);

        System.out.println();

        company.reportFuel(riverBarge);
        company.reportDistance(riverBarge);
    }
}
