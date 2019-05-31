package com.hxzy.senior.day22;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

/**
 * @author chenyongzhi
 * @date 2019/5/23 9:55
 */
public class ExceptionTest {

    @Test
    public void test() {
        Integer[] arr = new Integer[1024*1024*1024];
    }

    @Test
    public void test1() {
        File file = new File("hello.txt");
        try {
            FileInputStream fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test2() {
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        System.out.println(score);
    }

    @Test
    public void test3() {
        String str = "123";
        str = "abc";
        int num = Integer.parseInt(str);
    }

    @Test
    public void test4() {
        Object obj = new Date();
        String str = (String) obj;
    }

    @Test
    public void test5() {
        //int[] arr = new int[10];
        //System.out.println(arr[10]);

        String str = "abc";
        System.out.println(str.charAt(3));
    }

    @Test
    public void test6() {
        //int[] arr = null;
        //System.out.println(arr[3]);

        String str = "abc";
        str = null;
        System.out.println(str.charAt(0));
    }

}
