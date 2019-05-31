package oop.senior.day10thread.exer;

import javax.swing.*;
import java.awt.*;

/**
 * @author chenyongzhi
 * @date 2019/5/29 14:31
 */
public class WindowTest extends JFrame{     //需要继承JFrame

    public WindowTest(String title)
    {
        JFrame jf = new JFrame(title);
        Container conn = jf.getContentPane();    //得到窗口的容器

        Label label1 = new Label("源文件");

        jf.setBounds(200,200,300,200); //设置窗口的属性 窗口位置以及窗口的大小
        jf.setVisible(true);//设置窗口可见
        jf.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //设置关闭方式 如果不设置的话 似乎关闭窗口之后不会退出程序
    }

    public static void main(String[] args) {
        WindowTest test = new WindowTest("复制文件");//创建窗口
    }

}
