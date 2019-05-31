package com.hxzy.basic.day15.exer1;

/**
 * @author chenyongzhi
 * @date 2019/5/14 9:43
 */
public class Company {

    public void reportFuel(Vehicle vehicle) {
        double f = vehicle.calcFuelEfficiency();
        System.out.println("燃油效率为："+f);
    }

    public void reportDistance(Vehicle vehicle) {
        double d = vehicle.calcTripDistance();
        System.out.println("行驶距离为："+d);
    }
}
