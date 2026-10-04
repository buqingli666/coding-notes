package com.itheima.operator;

public class OperatorDemo6 {
    static void main() {
        /*
         * 字符运算
         *
         * 实现字母的大小写转换，将大写字母转化为小写字母
         *
         */

        // 1. 定义变量记录大写的字符
        char c = 'A';

        // 2. 转成小写
        // 'A' -> 65 + 32 --> 97 -> a
        char cc = (char) (c + 32);

        System.out.println(cc);

    }
}
