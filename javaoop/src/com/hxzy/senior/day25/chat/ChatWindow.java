package com.hxzy.senior.day25.chat;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author chenyongzhi
 * @create 2019/5/31 14:57
 */
public class ChatWindow extends JFrame implements ActionListener {

    private JButton button;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel label;

    public ChatWindow() throws HeadlessException {

        setTitle("多人聊天室");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
        setLayout(null);

        textField1 = new JTextField();
        textField1.setBounds(10, 10, 460, 350);
        textField1.setBackground(Color.lightGray);
        add(textField1);

        textField2 = new JTextField();
        textField2.setBounds(10, 370, 380, 80);
        add(textField2);

        button = new JButton("发送");
        button.setBounds(400, 370, 70, 80);
        add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button) {
            new Client();
        }

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChatWindow();
            }
        });
    }
}
