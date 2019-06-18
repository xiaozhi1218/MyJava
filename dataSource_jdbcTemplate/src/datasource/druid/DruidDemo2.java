package datasource.druid;

import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author chenyongzhi
 * @create 2019/6/18 9:54
 */
public class DruidDemo2 {

    public static void main(String[] args) {

        /**
         * 完成添加操作：给beauty表添加一条记录
         */
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            //1.获取连接
            conn = JDBCUtils.getConnection();
            //2.定义sql
            String sql = "insert into beauty values(null, ?, ?, null, ?, null, null)";
            //3.获取pstmt对象
            pstmt = conn.prepareStatement(sql);
            //4.给?赋值
            pstmt.setString(1, "张三");
            pstmt.setString(2, "男");
            pstmt.setString(3, "18487256338");
            //5.执行sql
            int count = pstmt.executeUpdate();
            System.out.println(count);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            JDBCUtils.close(pstmt, conn);
        }
    }
}
