package com.hxzy.senior.day26;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Calendar;

/**
 * @author chenyongzhi
 * @create 2019/6/3 14:17
 */
public class Test1 {

    @Test
    public void test2() {

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.MONTH, 11);
        System.out.println(calendar1);
    }
}
