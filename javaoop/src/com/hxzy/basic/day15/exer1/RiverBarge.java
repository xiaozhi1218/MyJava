package com.hxzy.basic.day15.exer1;

/**
 * @author chenyongzhi
 * @date 2019/5/14 9:43
 */
public class RiverBarge extends Vehicle {
    @Override
    public double calcFuelEfficiency() {
        return 0.8;
    }

    @Override
    public double calcTripDistance() {
        return 70;
    }
}
