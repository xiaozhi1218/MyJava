package jdbctemplate;

import domain.employee;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import utils.JDBCUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 方法测试
 *
 * @author chenyongzhi
 * @create 2019/6/18 11:54
 */
public class JdbcTemplateDemo2 {

    //1.获取JDBCTemplate对象
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 1.修改100号数据的 salary 为10000
     */
    @Test
    public void test1() {

        //2.定义sql
        String sql = "update employees set salary = ? where employee_id = ?";
        //3.执行sql
        int count = template.update(sql, 10000, 100);
        System.out.println(count);
    }

    /**
     * 2. 添加一条记录
     */
    @Test
    public void test2() {
        String sql = "insert into jobs values(?,?,?,?)";
        int count = template.update(sql, "it_pro", "program", 5000, 20000);
        System.out.println(count);
    }

    /**
     * 3.删除刚才添加的记录
     */
    @Test
    public void test3() {
        String sql = "delete from jobs where job_id = ?";
        int count = template.update(sql, "it_pro");
        System.out.println(count);
    }

    /**
     * 4.查询id为101的记录，将其封装为Map集合
     * 注意：这个方法查询的结果集长度只能是1
     */
    @Test
    public void test4() {
        String sql = "select * from employees where employee_id = ?";
        Map<String, Object> map = template.queryForMap(sql, 101);
        System.out.println(map);
        //{employee_id=101, first_name=Neena, last_name=Kochhar, email=NKOCHHAR, phone_number=515.123.4568, job_id=AD_VP, salary=17000.0, commission_pct=null, manager_id=100, department_id=90, hiredate=1992-04-03 00:00:00.0}
    }

    /**
     * 5. 查询所有记录，将其封装为List
     */
    @Test
    public void test5() {
        String sql = "select * from employees";
        List<Map<String, Object>> list = template.queryForList(sql);

        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap);
        }
    }

    /**
     * 6. 查询所有记录，将其封装为Emp对象的List集合
     */
    @Test
    public void test6() {
        String sql = "select * from employees";
        List<employee> list = template.query(sql, new RowMapper<employee>() {//自己实现RowMapper接口
            @Override
            public employee mapRow(ResultSet rs, int i) throws SQLException {
                employee emp = new employee();
                emp.setEmployee_id(rs.getInt("employee_id"));
                emp.setFirst_name(rs.getString("first_name"));
                emp.setLast_name(rs.getString("last_name"));
                emp.setEmail(rs.getString("email"));
                emp.setPhone_number(rs.getString("phone_number"));
                emp.setJob_id(rs.getString("job_id"));
                emp.setSalary(rs.getDouble("salary"));
                emp.setCommission_pct(rs.getDouble("commission_pct"));
                emp.setManager_id(rs.getInt("manager_id"));
                emp.setDepartment_id(rs.getInt("department_id"));
                emp.setHiredate(rs.getDate("hiredate"));

                return emp;
            }
        });
        System.out.println(list.size());
        for (employee emp : list) {
            System.out.println(emp);
        }
    }


    /**
     * 6. 查询所有记录，将其封装为Emp对象的List集合
     */
    @Test
    public void test7() {
        String sql = "select * from employees";
        List<employee> list = template.query(sql, new BeanPropertyRowMapper<employee>(employee.class));
        for (employee emp : list) {
            System.out.println(emp);
        }
    }

    /**
     * 7. 查询总记录数(聚合函数)
     */
    @Test
    public void test8() {
        String sql = "select count(*) from employees";
        Long total = template.queryForObject(sql, Long.class);
        System.out.println(total);
    }
}
