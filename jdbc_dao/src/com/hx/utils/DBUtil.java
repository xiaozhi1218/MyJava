package com.hx.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtil {

    private static Connection conn;
    private static String url,user,pwd;
    private DBUtil() {
    }

    static {
        InputStream inputStream = DBUtil.class.getResourceAsStream("/jdbc.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            String driver = properties.getProperty("driver");
            Class.forName(driver);
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            pwd = properties.getProperty("password");
            conn = DriverManager.getConnection(url, user, pwd);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
            if(conn==null||conn.isClosed()){
                conn=DriverManager.getConnection(url,user,pwd);
            }
            return conn;
        } catch (SQLException e) {
            //e.printStackTrace();
            return null;
        }
    }

    public static ResultSet query(String sql){
        Connection connection=getConnection();
        try {
            Statement stm=connection.createStatement();
            ResultSet rs=stm.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            //e.printStackTrace();
            return null;
        }
    }
    public static ResultSet query(String sql,Object...param){
        Connection connection=getConnection();
        try {
            PreparedStatement stm=connection.prepareStatement(sql);
            for(int i=0;i<param.length;i++){
                stm.setObject(i+1,param[i]);
            }
            ResultSet rs=stm.executeQuery();
            return rs;
        } catch (SQLException e) {
            //e.printStackTrace();
            return null;
        }
    }

    public static int save(String sql,Object[] param){
        Connection connection=getConnection();
        try {
            PreparedStatement stm=connection.prepareStatement(sql);
            for(int i=0;i<param.length;i++){
                stm.setObject(i+1,param[i]);
            }
            return stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}