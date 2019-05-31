package com.hxzy.basic.day5;

import java.util.Scanner;

public class SwichTest {
    public static void main(String[] args) {
        String s;
        Scanner scanner = new Scanner(System.in);
        s = scanner.nextLine();
        /*switch (s) {
            case "你好":
                System.out.println("你好");
                break;
            case "你喜欢什么？":
                System.out.println("这是秘密。");
                break;
            case "你多大了":
                System.out.println("不告诉你");
                break;
            default:
                System.out.println("我不知道你在说什么");
        }*/
        if (s.equals("你好")) {
            System.out.println("你好");
        } else if (s.equals("你喜欢什么")) {
            System.out.println("这是秘密");
        } else if (s.equals("你多大了")) {
            System.out.println("不告诉你");
        } else System.out.println("我不知道你在说什么");

    }
}
