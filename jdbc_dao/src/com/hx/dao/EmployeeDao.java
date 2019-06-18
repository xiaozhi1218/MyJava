package com.hx.dao;

import com.hx.entity.Employees;
import com.hx.utils.DBUtil;

import java.sql.ResultSet;
import java.util.List;

public class EmployeeDao extends BaseDao<Employees>{

    public List<Employees> findBySalaryAndDep(Double salary,Integer departmentId){
        String sql="select * from employees where salary>? and department_id=?";
        ResultSet rs= DBUtil.query(sql,salary,departmentId);
        return resultSetToList(rs);
    }
}
