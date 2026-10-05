package com.itheima.ifdemo;

public class IfDemo1 {
    static void main() {
        /*
         * if 语句的第一种格式
         *    if (关系表达式) {
         *        语句体;
         *    }
         *
         * 定义一个变量表示人的体温，对体温进行判断是否大于等于38度，如果超过打印语音警告
         *
         */

        // 1. 定义一个变量表示人的体温
        double temperature = 38.6;

        // 2. 对体温进行判断
        if (temperature >= 38) {
            System.out.println("语音警告，当前体温已经超过了38度！");
        }

    }
}
