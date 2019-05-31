package oop.senior.day17stream;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之一：缓冲流的使用
 * <p>
 * 1.缓冲流：
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 * <p>
 * 2.作用：提供流的读取、写入的速度
 * 提高读写速度的原因：内部提供了一个缓冲区
 * <p>
 * 3. 处理流，就是“套接”在已有的流的基础上。
 *
 * @author chenyongzhi
 * @create 2019/5/25 15:06
 */
public class BufferedTest {

    /*
    实现非文本文件的复制
     */
    @Test
    public void BufferedStreamTest() {

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File file1 = new File("p1.jpg");
            File file2 = new File("p3.jpg");
            //2.造流
            //2.1 造节点流
            FileInputStream fis = new FileInputStream(file1);
            FileOutputStream fos = new FileOutputStream(file2);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.复制的细节：读取、写入
            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);

//                bos.flush();//刷新缓冲区

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //说明：关闭外层流的同时，内层流也会自动的关闭。关于内层流的关闭，我们可以省略
//            fos.close();
//            fis.close();
        }
    }

    //实现文件复制的方法
    public void copyFileWithBufferedStream(String srcPath, String destPath) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testCopyFileWithBufferedStream() {

        long start = System.currentTimeMillis();

        String srcPath = "E:\\Java\\ideaIU-2018.2.5.exe";
        String destPath = "E:\\Java\\ideaIU-2018.2.52.exe";

        copyFileWithBufferedStream(srcPath, destPath);

        long end = System.currentTimeMillis();

        System.out.println("复制花费的时间为：" + (end - start));//18303-2576
    }

    /*
    使用BufferedReader和BufferedWriter实现文本文件的复制
     */
    @Test
    public void testBufferedReaderWriter() {

        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("dbc.txt")));
            bw = new BufferedWriter(new FileWriter(new File("dbc1.txt")));

            //读写操作
            //方式一：使用char[]数组
//        char[] cbuf = new char[1024];
//        int len;
//        while ((len = br.read(cbuf)) != -1) {
//            bw.write(cbuf, 0, len);
//        }
            //方式二：使用String
            String data;
            while ((data = br.readLine()) != null) {
                //方法一：
    //            bw.write(data + "\n");
                //方法二：
                bw.write(data);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
