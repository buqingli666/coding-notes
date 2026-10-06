package com.itheima.loopfor;

public class ForDemo6 {
    static void main() {
        /*
         * for 循环练习
         *
         * 有一组特殊的数字，从第三项开始，每一项都是前两项的数字和，请问第10项的数字是多少？
         * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89...
         *
         */

        // 1. 定义两个变量，去记录前两项的值
        int a = 0;
        int b = 1;

        // 2. 定义一个变量，赋值为0，表示a和b后面那一项的值
        int c = 0;

        for (int i = 3; i <= 10; i++) {
            // 求c的值 (求前一组最后一个值)
            c = a + b;
            // 不断的修改a和b记录的值 (求下一组前两个值)
            a = b;
            b = c;
        }

        System.out.println(c);
    }
}
