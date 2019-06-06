package oop.senior.day11_string;

import org.junit.Test;

import java.util.Date;

/**
 *
 * @author chenyongzhi
 * @create 2019/6/6 9:18
 */
public class DateTimeTest {

    /*
   java.util.Date类
          |---java.sql.Date类

   1.两个构造器的使用
       >构造器一：Date()：创建一个对应当前时间的Date对象
       >构造器二：创建指定毫秒数的Date对象
   2.两个方法的使用
       >toString():显示当前的年、月、日、时、分、秒
       >getTime():获取当前Date对象对应的毫秒数。（时间戳）

   3. java.sql.Date对应着数据库中的日期类型的变量
       >如何实例化
       >如何将java.util.Date对象转换为java.sql.Date对象
    */
    @Test
    public void test1() {
        //构造器一：Date()：创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1);//Thu Jun 06 09:22:45 CST 2019
        System.out.println(date1.getTime());//1559784231099

        //构造器二：创建指定毫秒数的Date对象
        Date date2 = new Date(1559784231099L);
        System.out.println(date2);

        //创建java.sql.Date对象
        java.sql.Date date3 = new java.sql.Date(32132132121L);
        System.out.println(date3);

        //如何将java.util.Date对象转换为java.sql.Date对象
        Date date4 = new java.sql.Date(13242342344L);


    }
}
