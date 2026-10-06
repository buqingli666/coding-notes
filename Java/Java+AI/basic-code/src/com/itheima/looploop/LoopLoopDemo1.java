package com.itheima.looploop;

public class LoopLoopDemo1 {
    static void main() {
        /*
         * 循环嵌套
         *
         * 打印4行5列的 *
         *
         * *****
         * *****
         * *****
         * *****
         *
         * 限定：每次只能输出一个 *
         *
         */

        // 外循环：把在一行打印5个*的事情，重复执行4次
        for (int i = 1; i <= 4; i++) {

            // 内循环：一行打印5个 *
            for (int j = 1; j <= 5; j++) {
                System.out.print("*");
            }
            //换行
            System.out.println();

        }
    }
}
