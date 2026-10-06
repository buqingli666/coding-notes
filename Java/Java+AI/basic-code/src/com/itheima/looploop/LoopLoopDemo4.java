package com.itheima.looploop;

public class LoopLoopDemo4 {
    static void main() {
        /*
         * 打印梯形
         *
         *   ***
         *  *****
         * *******
         *
         */

        // 外层控制行数 - 3行
        for (int i = 1; i <= 3; i++) {

            // 内层1：打印前置空格
            for (int j = 1; j <= 3 - i; j++) {
                System.out.print(" ");
            }

            // 内层2：打印星号
            for (int k = 1; k <= 2 * i + 1; k++) {
                System.out.print("*");
            }

            System.out.println();

        }
    }
}
