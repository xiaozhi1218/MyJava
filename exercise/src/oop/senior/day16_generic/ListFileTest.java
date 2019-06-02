package oop.senior.day16_generic;

import java.io.File;

/**
 * 遍历指定目录所有文件名称，包括子文件目录中的文件。
 * 拓展1：并计算指定目录占用空间的大小
 * 拓展2：删除指定文件目录及其下的所有文件
 *
 * @author chenyongzhi
 * @create 2019/5/23 23:01
 */
public class ListFileTest {

    public static void main(String[] args) {

        //1.递归：文件目录

        //1.创建目录对象
        File file = new File("E:\\IdeaProjects\\myjava\\exercise");

        //2.获取目录的子文件
        getAllFiles(file);
    }

    public static void getAllFiles(File file) {

        if (file.isFile()) {
            return;
        }
        //遍历目录的子文件
        File[] files = file.listFiles();//创建一个File[]数组获取名称

        for (File f : files) {
            if (f.isDirectory()) {//文件目录
                System.out.println(f.getName());
                getAllFiles(f);//继续递归调用此方法遍历文件目录
            } else {//文件
                System.out.println(f.getName());//打印文件路径
            }
        }
    }
}
