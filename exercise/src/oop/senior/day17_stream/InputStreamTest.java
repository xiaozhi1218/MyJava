package oop.senior.day17_stream;

import org.junit.Test;

import java.io.*;

/**
 * @author chenyongzhi
 * @date 2019/5/27 11:48
 */
public class InputStreamTest {

    @Test
    public void Test1() {
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            isr = new InputStreamReader(new FileInputStream("dbc.txt"), "utf-8");

            osw = new OutputStreamWriter(new FileOutputStream("dbc_gbk1.txt"), "gbk");

            char[] cbuf = new char[20];
            int len;
            while ((len = isr.read(cbuf)) != -1) {
                osw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
