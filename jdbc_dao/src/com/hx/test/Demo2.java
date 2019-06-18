package com.hx.test;

import com.hx.entity.Employees;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.time.LocalDate;

/**
 * 反射（reflect）
 */
public class Demo2 {
    public static void main(String[] args) throws Exception {

        Class  emp1= Employees.class;
        Employees employee= (Employees) emp1.newInstance();
        employee.setEmployeeId(220);
        employee.setFirstName("xxxx");
        employee.setLastName("yyyy");
        employee.setSalary(15000.0);
        Class  emp2=employee.getClass();
        //反射类名
        System.out.println(emp1.getName());
        System.out.println(emp2.getName());
        System.out.println(emp1.getSimpleName());
        //反射属性(Field)
        Field[] fields=emp1.getDeclaredFields();
        fields[3].setAccessible(true);
        fields[3].set(employee,"abc@qq.com");
        String qq= (String) fields[3].get(employee);
        System.out.println(qq);
        System.out.println(fields.length);
        for (Field f:fields){
            f.setAccessible(true);
            System.out.println(f.getType().getName()+"  "+f.getName()+"  "+f.get(employee));
        }
        System.out.println("========================================");
        //反射方法（Method）
        Method[] methods=emp1.getDeclaredMethods();

        for (Method m:methods){
            Parameter[] parameters= m.getParameters();
            System.out.println(m.getReturnType().getName()+"   "+m.getName());
            for (Parameter p:parameters){
                System.out.println(p.getType().getName()+"  "+p.getName());
            }
            System.out.println("--------------------------");
        }
        System.out.println("=====================");
        LocalDate localDate=LocalDate.of(2008,8,8);
        Method setHireDate=emp1.getDeclaredMethod("setHireDate",LocalDate.class);
        setHireDate.invoke(employee,localDate);//employee.setHireDate(LocalDate)
        String str= (String) methods[0].invoke(employee);//String str=employee.toString()
        System.out.println(str);
    }
}