package com.hxzy.basic.day15.exer1;

/**
 * @author chenyongzhi
 * @date 2019/5/14 9:43
 */
public class Car extends Vehicle {
    @Override
    public double calcFuelEfficiency() {
        return 0.9;
    }

    @Override
    public double calcTripDistance() {
        return 90;
    }
}
