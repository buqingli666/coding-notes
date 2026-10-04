package com.itheima.variable;

public class VariableDemo3 {
    static void main() {
        /*
        变量的注意事项：
            1. 只能存一个值
            2. 变量名不允许重复定义
            3. 变量在使用之前一定要进行赋值
            4. 一条语句可以定义多个变量，也可以连续赋值
        */

        // 变量在使用之前一定要进行赋值
        // int a;
        // System.out.println(a);

        // 一条语句可以定义多个变量
        int a, b, c, d;
        // a = 10;
        // b = 20;
        // c = 30;
        // d = 40;

        a = b = c = d = 10;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

        int aaa = 10; // 推荐方式
    }
}
