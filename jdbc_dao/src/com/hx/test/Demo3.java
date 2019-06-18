package com.hx.test;

import com.hx.dao.CountryDao;
import com.hx.dao.EmployeeDao;
import com.hx.entity.Countries;
import com.hx.entity.Employees;

import java.util.List;

public class Demo3 {

    public static void main(String[] args) {
        CountryDao countryDao=new CountryDao();
        List<Countries> list1= countryDao.findAll();
        for (Countries c:list1){
            System.out.println(c);
        }
        System.out.println("=================================");
        EmployeeDao employeeDao=new EmployeeDao();
        List<Employees> list2= employeeDao.findBySalaryAndDep(10000.0,80);
        for (Employees e:list2){
            System.out.println(e);
        }
        /*Countries c=new Countries();
        c.setCountryId("xx");
        c.setCountryName("云南");
        c.setRegionId(2);
        countryDao.insert(c);*/
        /*Employees e=new Employees();
        employeeDao.insert(e);*/
        //countryDao.delete("xx");
        employeeDao.delete(206);
    }
}
