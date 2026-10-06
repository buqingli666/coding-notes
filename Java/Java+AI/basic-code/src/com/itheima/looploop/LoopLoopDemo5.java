package com.itheima.looploop;

public class LoopLoopDemo5 {
    static void main() {
        /*
         * 打印菱形
         *
         *    *
         *   ***
         *  *****
         * *******
         *  *****
         *   ***
         *    *
         *
         */

        // 上半部分 --- 4行
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4 - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 下半部分 --- 3行
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 7 - 2 * i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
