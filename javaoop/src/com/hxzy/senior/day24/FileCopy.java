package com.hxzy.senior.day24;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class FileCopy extends JFrame implements ActionListener {

    private JTextField[] textFields = new JTextField[2];
    private JButton[] buttons = new JButton[2];
    private File srcFile = null, destFile = null;
    private JProgressBar pb;

    public FileCopy() {
        setTitle("文件复制");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
        setLayout(null);
        String[] str = {"源文件：", "目标位置："};
        int y = 100;
        for (int i = 0; i < str.length; i++) {
            JLabel label = new JLabel(str[i]);
            label.setBounds(50, y, 70, 25);
            add(label);

            textFields[i] = new JTextField();
            textFields[i].setBounds(130, y, 250, 25);
            add(textFields[i]);

            buttons[i] = new JButton("...");
            buttons[i].setBounds(400, y, 50, 25);
            add(buttons[i]);
            buttons[i].addActionListener(this);
            y += 50;
        }
        pb = new JProgressBar();
        pb.setBounds(100, 250, 300, 25);
        pb.setStringPainted(true);
        add(pb);

        JButton button = new JButton("复制");
        button.setBounds(200, 350, 100, 25);
        add(button);
        button.addActionListener(this);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FileCopy();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttons[0]) {
            JFileChooser fc = new JFileChooser();
            int f = fc.showOpenDialog(this);
            if (f == JFileChooser.APPROVE_OPTION) {
                srcFile = fc.getSelectedFile();
                textFields[0].setText(srcFile.getPath());
            }
        } else if (e.getSource() == buttons[1]) {
            JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int f = fc.showOpenDialog(this);
            if (f == JFileChooser.APPROVE_OPTION) {
                destFile = fc.getSelectedFile();
                textFields[1].setText(destFile.getPath());
            }
        } else {
            if (srcFile == null || destFile == null) {
                JOptionPane.showMessageDialog(this, "请选择文件");
            } else {
                destFile = new File(destFile.getPath() + "\\" + srcFile.getName());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        copy(srcFile, destFile);
                    }
                }).start();
            }
        }
    }

    private void copy(File srcFile, File destFile) {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
            byte[] tmp = new byte[8192];
            int len, percent = 0;
            long total = srcFile.length(), copied = 0;
            while ((len = bis.read(tmp)) != -1) {
                bos.write(tmp, 0, len);
                copied += len;
                percent = (int) (copied * 1.0 / total * 100 + 0.5);
                pb.setValue(percent);
            }
            bos.close();
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
