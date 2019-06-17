package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * jdbc使用
 *
 * @author chenyongzhi
 * @create 2019/6/15 11:40
 */
public class JDBCDemo1 {

    public static void main(String[] args){

        Connection conn = null;
        Statement stmt = null;
        try {
            //1. 导入驱动jar包
            //2.注册驱动
            Class.forName("com.mysql.jdbc.Driver");//mysql驱动
            //Class.forName("oracle.jdbc.OracleDriver");//oracle驱动

            //2. 定义sql
            String sql = "update boys set userCP = 20 WHERE id = 2";

            //3.获取Connection对象
            //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myemployees", "root", "root");//mysql的url
            conn = DriverManager.getConnection("jdbc:mysql:///girls", "root", "root");//mysql的url，本机可以省略地址
            //conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "root");//oracle的url

            //4.获取执行sql的对象 Statement
            stmt = conn.createStatement();


            //5.执行sql
            int count = stmt.executeUpdate(sql);//返回影响的行数

            //6.处理结果
            System.out.println(count);
            if(count > 0){
                System.out.println("更新成功！");
            }else{
                System.out.println("更新失败！");
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //7. 释放资源
            //避免空指针异常
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
