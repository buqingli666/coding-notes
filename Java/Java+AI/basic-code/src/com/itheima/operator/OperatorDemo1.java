package com.itheima.operator;

public class OperatorDemo1 {
    static void main() {
        /*
         * 算数运算符 + - * / %
         *
         * 整数运算、小数运算
         *
         */

        // 1. 整数计算
        // 细节：整数相除结果还是整数，就是商
        //      其他运算跟数学中是一模一样的
        int a = 10;
        int b = 3;

        System.out.println(a + b); // 13
        System.out.println(a - b); // 7
        System.out.println(a * b); // 30
        System.out.println(a / b); // 3
        System.out.println(a % b); // 1

        System.out.println("---------------------------");

        // 2.小数计算
        // 细节：小数直接参与计算，结果有可能不精确的
        double c = 10.0;
        double d = 3.0;

        System.out.println(c + d); // 13.0
        System.out.println(c - d); // 7.0
        System.out.println(c * d); // 30.0
        System.out.println(c / d); // 3.3333333333333335
        System.out.println(c % d); // 1.0
    }
}
