package test;

import java.sql.*;

/**
 * 执行DDL语句
 */
public class JDBCDemo3 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //1. 注册驱动
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("oracle.jdbc.OracleDriver");
            //2.获取连接对象
            //conn = DriverManager.getConnection("jdbc:mysql:///myemployees", "root", "root");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "root");
            //3.定义sql
            String sql  = "select * from jobs";
            //4.获取执行sql对象
            stmt = conn.createStatement();
            //5.执行sql
            rs = stmt.executeQuery(sql);
            //6.处理结果
            //循环判断游标是否是最后一行末尾。
            while(rs.next()){

                //获取数据
                //6.2 获取数据
                String jobId = rs.getString(1);
                String jobTitle = rs.getString(2);
                int minSalary = rs.getInt(3);
                int maxSalary = rs.getInt("max_salary");

                System.out.println("jobId = " + jobId + " jobTitle "
                        + jobTitle + " minSalary "
                        + minSalary + " maxSalary " + maxSalary);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //7.释放资源
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
    }

}
