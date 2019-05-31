package oop.basic.day07.exer2;

/**
 * 请使用继承的思想，设计CommonEmployee类和Manager类，要求类中提供必要的方法进行属性访问。
 * @author chenyongzhi
 * @create 2019/5/19 21:12
 */
public class EmployeeTest {

    public static void main(String[] args) {

        Employee manager = new Manager("库克", 1001, 5000, 50000);

        manager.work();

        CommonEmployee commonEmployee = new CommonEmployee();
        commonEmployee.work();
    }
}
