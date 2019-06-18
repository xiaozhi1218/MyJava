package oop.senior.day12_date;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author chenyongzhi
 * @create 2019/6/18 20:37
 */
public class OtherClassTest {

    @Test
    public void test1() {
        /*
        1.8.0_191
        D:\Program Files\Java\jdk1.8.0_191\jre
        Windows 10
        10.0
        chenyongzhi
        C:\Users\chenyongzhi
        E:\IdeaProjects\myjava\exercise
         */
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.dir"));
    }

    @Test
    public void test2() {
        BigInteger bi = new BigInteger("1231231243423423432131554654654123");
        BigDecimal bd = new BigDecimal("1231414.45");
        BigDecimal bd2 = new BigDecimal("11");
        System.out.println(bi);
        System.out.println(bd.divide(bd2, BigDecimal.ROUND_HALF_UP));//111946.77
        System.out.println(bd.divide(bd2, 25, BigDecimal.ROUND_HALF_UP));//111946.7681818181818181818181818
    }
}
