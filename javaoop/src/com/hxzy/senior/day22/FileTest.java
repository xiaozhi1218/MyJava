package com.hxzy.senior.day22;

import java.io.File;

/**
 * @author chenyongzhi
 * @date 2019/5/24 8:53
 */
public class FileTest {

    public static int count = 0;

    public static void main(String[] args) {

        File file = new File("E:\\IdeaProjects\\exercise");

        getAllFiles(file);
        System.out.println(count);


    }

    public static void getAllFiles(File file) {

        File[] files = file.listFiles();

        for (File f : files) {
            count++;
            if (f.isDirectory()) {
                getAllFiles(f);
            } else {
                System.out.println(f.getAbsolutePath());
            }
        }
    }
}

