package com.itheima.looploop;

public class LoopLoopDemo7 {
    static void main() {
        /*
         * 循环嵌套
         *
         * 打印99乘法表
         *
         */

        // 外循环控制行
        for (int i = 1; i <= 9; i++) {

            // 内循环控制列
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + j * i + "\t");
            }

            System.out.println();

        }

    }
}
