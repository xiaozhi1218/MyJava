package com.hxzy.senior.day20;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author chenyongzhi
 * @date 2019/5/21 9:57
 */
public class DateTest {

    @Test
    public void test() {
        //日期 + 时间
        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println(localDateTime1);

        //日期
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        //时间
        LocalTime now = LocalTime.now();
        System.out.println(now);

        //格式化
        String format = localDateTime1.format(DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss"));
        System.out.println(format);
    }

    @Test
    public void test1() {
        //LocalDateTime与String日期互相转换
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");//DateTime的格式
        LocalDateTime time = LocalDateTime.now();//获取当前时间
        String localTime = df.format(time);//
        LocalDateTime ldt = LocalDateTime.parse("2008-08-08 10:21:05", df);
        System.out.println("LocalDateTime转成String类型的时间："+localTime);
        System.out.println("String类型的时间转成LocalDateTime："+ldt);
    }
}
