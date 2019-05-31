package oop.senior.day18socket.stream;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author chenyongzhi
 * @date 2019/5/27 15:23
 */
public class FileEncryption {

    //图片的加密
    @Test
    public void test() {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("p1.jpg");
            fos = new FileOutputStream("p2.jpg");

            byte[] buffer = new byte[20];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                //fos.write(buffer, 0, len);

                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //图片的解密
    @Test
    public void test1() throws IOException {

        FileInputStream fis = new FileInputStream("p2.jpg");
        FileOutputStream fos = new FileOutputStream("p5.jpg");

        byte[] buffer = new byte[20];
        int len;
        while ((len = fis.read(buffer)) != -1) {
            //fos.write(buffer, 0, len);

            for (int i = 0; i < len; i++) {
                buffer[i] = (byte) (buffer[i] ^ 5);
            }
            fos.write(buffer, 0, len);
        }

        fos.close();
        fis.close();
    }
}
