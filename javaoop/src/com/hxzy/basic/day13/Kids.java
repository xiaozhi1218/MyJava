package com.hxzy.basic.day13;

/**
 * @author chenyongzhi
 * @description
 * @date 2019/5/10 14:45
 */

public class Kids extends ManKind {
    private int yearsOld;

    public static void main(String[] args) {
        Kids someKid = new Kids();
        someKid.setSalary(20);
        someKid.setSex(1);
        someKid.manOrWomen();
        someKid.employeed();
        someKid.setYearsOld(20);
        someKid.printAge();
    }

    public void printAge() {
        System.out.println(yearsOld);
    }

    public int getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }
}
