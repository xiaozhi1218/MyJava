package test;


import domain.employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyongzhi
 * @create 2019/6/17 13:37
 */
public class JDBCDemo4 {

    public static void main(String[] args) {

        List<employee> list = new JDBCDemo4().findAll();
        for (employee e : list) {
            System.out.println(e);
        }
    }

    public List<employee> findAll() {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<employee> list = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql:///myemployees", "root", "root");

            stmt = conn.createStatement();

            rs = stmt.executeQuery("select * from employees");

            employee employee = null;
            list = new ArrayList<>();

                while (rs.next()) {
                    employee = new employee();
                    employee.setEmployee_id(rs.getInt(1));
                    employee.setFirst_name(rs.getString(2));
                    employee.setLast_name(rs.getString(3));
                    employee.setEmail(rs.getString(4));
                    employee.setPhone_number(rs.getString(5));
                    employee.setJob_id(rs.getString(6));
                    employee.setSalary(rs.getDouble(7));
                    employee.setCommission_pct(rs.getDouble(8));
                    employee.setManager_id(rs.getInt(9));
                    employee.setDepartment_id(rs.getInt(10));
                    employee.setHiredate(rs.getDate(11));

                list.add(employee);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{

            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

}
