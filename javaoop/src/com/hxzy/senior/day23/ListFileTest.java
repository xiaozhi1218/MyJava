package com.hxzy.senior.day23;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 遍历指定目录所有文件名称，包括子文件目录中的文件。
 * 拓展1：并计算指定目录占用空间的大小
 * 拓展2：删除指定文件目录及其下的所有文件
 *
 * @author chenyongzhi
 * @create 2019/5/23 23:01
 */
public class ListFileTest {

    public static int level = 1;

    public static void main(String[] args) {

        //1.递归：文件目录

        //1.创建目录对象
        File file = new File("E:\\IdeaProjects");

        //2.获取目录的子文件
        getAllFiles(file);
    }

    public static void getAllFiles(File file) {

        if (file.isFile()) {
            return;
        }
        level++;
        //遍历目录的子文件
        File[] sons = file.listFiles();
        List<File> files = new ArrayList<>();
        for (File f : sons) {
            if (f.isFile()) files.add(f);
            else {
                String space = "";
                for (int i = 1; i < level; i++)
                    space += "--";
                System.out.println(space + f.getName());
                getAllFiles(f);
            }
        }
        for (File f : files) {
            String space = "";
            for (int i = 1; i < level; i++)
                space += "--";
            System.out.println(space + f.getName());
        }
        level--;
    }
}
