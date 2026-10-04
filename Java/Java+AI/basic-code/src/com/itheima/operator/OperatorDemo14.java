package com.itheima.operator;

public class OperatorDemo14 {
    static void main() {
        /*
         * 三元运算符
         * 格式：关系表达式 ? 表达式1 : 表达式2;
         * true ---> 表达式1
         * false ---> 表达式2
         *
         * 需求：利用三元运算符，求两个整数的较大值
         *
         */

        int a = 368;
        int b = 265;
        int max = a > b ? a : b;

        System.out.println(max);

    }
}
