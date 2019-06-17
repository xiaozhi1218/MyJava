package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author chenyongzhi
 * @create 2019/6/17 14:06
 */
public class JDBCUtils {

    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    /**
     * 文件的读取，只需要读取一次即可获取到这些值。使用静态代码块
     */
    static {
        //读取资源文件，获取值。
        try {
            //1.读取资源文件，获取值
            Properties pros = new Properties();
            //获取src路径下的文件的方式--->ClassLoader 类加载器
//            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
//            URL res = classLoader.getResource("jdbc.properties");
//            String path = res.getPath();
            //或者下面方式：这种方式配置文件默认识别为：当前module的src路径下
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            InputStream is = classLoader.getResourceAsStream("jdbc.properties");
            //InputStream is = JDBCUtils.class.getResourceAsStream("jdbc.properties");

            //2. 加载文件
            //pro.load(new FileReader(path));
            pros.load(is);
            //3.获取数据，赋值
            url = pros.getProperty("url");
            user = pros.getProperty("user");
            password = pros.getProperty("password");
            driver = pros.getProperty("driver");
            //4.注册驱动
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    /**
     * 获取连接
     *
     * @return 连接对象
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 释放资源
     *
     * @param stmt
     * @param conn
     */
    public static void close(Statement stmt, Connection conn) {
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

    /**
     * 释放资源
     *
     * @param rs
     * @param stmt
     * @param conn
     */
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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
