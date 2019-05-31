package com.hxzy.basic.day15.exer2;

/**
 * @author chenyongzhi
 * @date 2019/5/14 10:10
 */
public class CommonEmployee extends Employee {

    public static void main(String[] args) {

        Manager manager = new Manager("slj", 12, 5444, 1000);
        manager.work();

        CommonEmployee commonEmployee = new CommonEmployee();
        commonEmployee.work();
    }

    @Override
    public void work() {
        System.out.println("CommonEmployee work");
    }
}
