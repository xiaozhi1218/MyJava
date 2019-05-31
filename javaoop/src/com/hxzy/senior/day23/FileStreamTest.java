package com.hxzy.senior.day23;

import org.junit.Test;

import java.io.*;

/**
 * @author chenyongzhi
 * @date 2019/5/24 11:19
 */
public class FileStreamTest {

    public static void main(String[] args) {

        try {
            FileInputStream fis = new FileInputStream("hello.txt");
            FileOutputStream fos = new FileOutputStream("hi.txt");
            int a;
            while ((a = fis.read()) != -1) {
                fos.write(a);
                //System.out.println(a);
            }
            fis.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() throws IOException {
        File file = new File("hello.txt");

        FileReader fr = new FileReader(file);

        int data = fr.read();
        System.out.println(data);
        data = fr.read();
        System.out.println(data);
        data = fr.read();
        System.out.println(data);
        data = fr.read();
        System.out.println(data);
        data = fr.read();
        System.out.println(data);
        data = fr.read();
        System.out.println(data);
        data = fr.read();
        System.out.println(data);
        data = fr.read();
        System.out.println(data);

    }

    @Test
    public void test2() {

        FileReader fr = null;
        try {
            File file = new File("hello.txt");

            fr = new FileReader(file);

        /*int data = fr.read();
        while (data != -1) {
            System.out.print((char) data);
            data = fr.read();
        }*/

            int data;
            while ((data = fr.read()) != -1) {
                System.out.print(((char) data));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test3() {

        FileReader fr = null;
        try {
            File file = new File("hello.txt");

            fr = new FileReader(file);

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

    @Test
    public void test4() {
        FileWriter fw = null;
        try {
            File file = new File("hello1.txt");

            fw = new FileWriter(file, true);

            fw.write("I have a dream!\n");
            fw.write("you need to have a dream!");
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

    @Test
    public void test5() {
        FileReader fr = null;
        try {
            File file = new File("hello.txt");

            fr = new FileReader(file);

            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                /*for (int i = 0; i < len; i++) {
                    System.out.print(cbuf[i]);
                }*/
                String str = new String(cbuf, 0, len);
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

    @Test
    public void test6() {

        FileReader fr = null;
        FileWriter fw = null;
        try {
            File file1 = new File("hello.txt");
            File file2 = new File("hello2.txt");

            fr = new FileReader(file1);
            fw = new FileWriter(file2);

            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
