package jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

/**
 * JdbcTemplate测试
 *
 * @author chenyongzhi
 * @create 2019/6/18 11:46
 */
public class JdbcTemplateDemo1 {

    public static void main(String[] args) {

        //1.导入jar包
        //2.创建JDBCTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        //3.调用方法
        String sql = "update beauty set phone = ? where id = ?";
        int count = template.update(sql, "18888888888", 27);
        System.out.println(count);
    }

}
