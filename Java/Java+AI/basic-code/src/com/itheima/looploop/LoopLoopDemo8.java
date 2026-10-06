package com.itheima.looploop;

public class LoopLoopDemo8 {
    static void main() {
        /*
         * 制表符：\t
         *
         * 简单理解：长度可变的大空格，打印表格类数据的时候，可以让上下对齐。（99乘法表）
         *
         * 真正的含义：
         *         在前面的字符后面补1-4个空格，让这个整体的长度凑成4的整数倍 ----- idea
         *         在前面的字符后面补1-8个空格，让这个整体的长度凑成8的整数倍
         *
         * name        age        gender
         * zhangsan    23         nan
         * lisi        24         nv
         *
         */

        System.out.println("name\t\tage\t\tgender");
        System.out.println("zhangsan\t23\t\tnan");
        System.out.println("lisi\t\t24\t\tnv");

        System.out.println("------------------");
        System.out.println("----\t-----");

    }
}
