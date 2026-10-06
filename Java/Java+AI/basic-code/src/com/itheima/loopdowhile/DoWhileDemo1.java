package com.itheima.loopdowhile;

public class DoWhileDemo1 {
    static void main() {
        /*
         * do...while 循环
         *
         * 初始化语句;
         * do {
         *     循环体语句;
         *     条件控制语句;
         * } while(条件判断语句);
         *
         * 核心特点：先执行后判断，循环体至少执行一次
         *
         */

        int i = 10;
        do {
            System.out.println("Hello World!"); // 输出一次
            i++;
        } while (i <= 5);


        for (int j = 10; j <= 5; j++) {
            System.out.println("Hello World!"); // 没有输出
        }

    }
}
