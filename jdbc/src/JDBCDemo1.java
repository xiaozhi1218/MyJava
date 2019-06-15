import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author chenyongzhi
 * @create 2019/6/15 11:40
 */
public class JDBCDemo1 {

    public static void main(String[] args){

        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String sql = "insert into jobs values('it_pro','it',10000,20000)";

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myemployees", "root", "root");

            stmt = conn.createStatement();

            int count = stmt.executeUpdate(sql);

            System.out.println(count);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
