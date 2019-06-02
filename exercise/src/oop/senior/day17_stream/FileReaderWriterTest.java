package oop.senior.day17_stream;

import org.junit.Test;

import java.io.*;

/**
 * 一、流的分类：
 * * 1.操作数据单位：字节流、字符流
 * * 2.数据的流向：输入流、输出流
 * * 3.流的角色：节点流、处理流
 * *
 * * 二、流的体系结构
 * * 抽象基类         节点流（或文件流）                               缓冲流（处理流的一种）
 * * InputStream     FileInputStream   (read(byte[] buffer))        BufferedInputStream (read(byte[] buffer))
 * * OutputStream    FileOutputStream  (write(byte[] buffer,0,len)  BufferedOutputStream (write(byte[] buffer,0,len) / flush()
 * * Reader          FileReader (read(char[] cbuf))                 BufferedReader (read(char[] cbuf) / readLine())
 * * Writer          FileWriter (write(char[] cbuf,0,len)           BufferedWriter (write(char[] cbuf,0,len) / flush()
 *
 * @author chenyongzhi
 * @create 2019/5/25 13:37
 */
public class FileReaderWriterTest {

    public static void main(String[] args) {

        File file = new File("hello.txt");//相对于当前project的位置
        System.out.println(file.getAbsolutePath());

        File file1 = new File("day17_stream\\hello.txt");
        System.out.println(file1.getAbsolutePath());
    }

    /*
    将hello.txt文件内容读入程序中，并输出到控制台

    说明点：
    1. read()的理解：返回读入的一个字符。如果达到文件末尾，返回-1
    2. 异常的处理：为了保证流资源一定可以执行关闭操作。需要使用try-catch-finally处理
    3. 读入的文件一定要存在，否则就会报FileNotFoundException。

     */
    @Test
    public void testFileReader() {
        FileReader fr = null;
        try {
            File file = new File("hello.txt");

            fr = new FileReader(file);

//        int data = fr.read();
//        while (data != -1) {
//            System.out.print((char)data);
//            data = fr.read();
//        }

            int data;
            while ((data = fr.read()) != -1) {
                System.out.print(((char) data));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //对read()操作升级：使用read的重载方法
    @Test
    public void testFileReader1() {

        FileReader fr = null;
        try {
            File file = new File("hello.txt");

            fr = new FileReader(file);

            char[] cbuf = new char[10];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                //方式一：
                //错误写法
    //            for (int i = 0; i < cbuf.length; i++) {
    //                System.out.print(cbuf[i]);
    //            }
                //正确写法
    //            for (int i = 0; i < len; i++) {
    //                System.out.print(cbuf[i]);
    //            }
                //方式二：
                //错误的写法
    //            String str = new String(cbuf);
    //            System.out.print(str);
                //正确的写法
                String str = new String(cbuf, 0, len);
                System.out.print(str);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    从内存中写出数据到硬盘的文件里。

    说明：
    1. 输出操作，对应的File可以不存在的。并不会报异常
    2.
         File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件。
         File对应的硬盘中的文件如果存在：
                如果流使用的构造器是：FileWriter(file,false) / FileWriter(file):对原有文件的覆盖
                如果流使用的构造器是：FileWriter(file,true):不会对原有文件覆盖，而是在原有文件基础上追加内容
     */
    @Test
    public void testFileWriter() {

        FileWriter fw = null;
        try {
            File file = new File("hi.txt");

            fw = new FileWriter(file, true);

            fw.write("i have a dream!\n");
            fw.write("you have a dream!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //复制文本文件
    @Test
    public void testFileReaderFileWriter() {

        FileReader fr = null;
        FileWriter fw = null;
        try {
            File file1 = new File("hello.txt");
            File file2 = new File("hello1.txt");

            fr = new FileReader(file1);
            fw = new FileWriter(file2);

            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                fw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
