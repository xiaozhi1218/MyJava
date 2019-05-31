package com.hxzy.basic.day1;

/**
 * 文档注释
 * public：关键字，公有的
 * class：关键字，类别
 * HelloWorld：自定义的类名，驼峰命名法，每个单词首字母大写
 * {}：表示范围（作用域）
 */
public class HelloWorld {
    /*
   多行注释
   static：关键字，表示静态的
   void：关键字，返回值类型（空，没有返回值）
   main：表示主函数名称
   main后面的()表示函数的参数列表
   String[]：表示字符串数组
   args：表示字符串数组的名称
    */
    public static void main(String[] args) {//出错：main不要打成mian
        //单行注释
        //向控制台输出一句话：Hello,world！
        //一个分号;表示一条语句
        System.out.println("Hello,world!");//出错：System的首字母S不要打成小写，忘打结束;号
    }
}
