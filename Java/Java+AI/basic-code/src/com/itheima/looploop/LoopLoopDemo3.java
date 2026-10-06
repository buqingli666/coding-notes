package com.itheima.looploop;

public class LoopLoopDemo3 {
    static void main() {
        /*
         * 打印平行四边形
         *
         *     ******
         *    ******
         *   ******
         *
         * 限定：每次只能输出一个*
         *
         */

        // 外循环：控制图形的行数
        for (int i = 1; i <= 3; i++) {

            // 内循环：控制每一行打印多少个*
            for (int j = i; j <= 2; j++) {
                System.out.print(" ");
            }

            // 内循环：平行四边形
            for (int j = 1; j <= 6; j++) {
                System.out.print("*");
            }

            System.out.println();

        }

    }
}
