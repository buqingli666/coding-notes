package com.itheima.operator;

public class OperatorDemo4 {
    static void main() {
        /*
         * 类型转化 - 练习一
         *
         */

        byte b = 100;
        short s = 200;
        double d = 10.3;

        // 请说出下面代码在计算的时候，类型转换的情况
        /*
         * 1. b + s
         * 先把 byte 类型的 100，和 short 类型的 200 提升为 int 类型
         * 结果：300（int）
         *
         * 2. 300（int） + d
         * int 类型的 300 会提升为 double 类型，变成 300.0
         * 结果：310.3（double）
         *
         */

        double result1 = b + s + d;
        System.out.println(result1);

    }
}
