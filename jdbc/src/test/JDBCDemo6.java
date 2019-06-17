package test;

import util.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * 练习：
 * * 需求：
 * 1. 通过键盘录入用户名和密码
 * 2. 判断用户是否登录成功
 *
 * @author chenyongzhi
 * @create 2019/6/17 15:54
 */
public class JDBCDemo6 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();

        boolean flag = new JDBCDemo6().login2(username, password);

        if (flag) {
            System.out.println("登录成功！");
        } else {
            System.out.println("用户名或密码错误！");
        }

    }


    /**
     * 登录方法
     *
     * @param username
     * @param password
     * @return
     */
    public boolean login(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        //连接数据库判断是否登录成功
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //1.获取连接
            conn = JDBCUtils.getConnection();
            //2.定义sql
            String sql = "select * from admin where username = '" + username + "' and password = '" + password + "'";
            System.out.println(sql);
            //3.获取执行sql的对象
            stmt = conn.createStatement();
            //4.执行查询
            rs = stmt.executeQuery(sql);

            //5.判断
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, stmt, conn);
        }
        return false;
    }


    /**
     * 登录方法，使用PreparedStatement实现
     *
     * @param username
     * @param password
     * @return
     */
    public boolean login2(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        //连接数据库判断是否登录成功
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            //1.获取连接
            conn = JDBCUtils.getConnection();
            //2.定义sql
            String sql = "select * from admin where username = ? and password = ?";
            //3.获取执行sql的对象
            pstmt = conn.prepareStatement(sql);
            //给?赋值
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            //4.执行查询,不需要传递sql
            rs = pstmt.executeQuery();
            //5.判断
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return false;
    }
}
