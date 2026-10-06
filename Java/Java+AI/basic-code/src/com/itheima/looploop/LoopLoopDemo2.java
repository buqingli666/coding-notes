package com.itheima.looploop;

public class LoopLoopDemo2 {
    static void main() {
        /*
         * 循环嵌套
         *
         * 打印正三角形
         *   *
         *   **
         *   ***
         *   ****
         *   *****
         * 打印倒三角形
         *   *****
         *   ****
         *   ***
         *   **
         *   *
         *
         * 限定：每次只能输出一个*
         */

        // 打印正三角形
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("-------------------------");

        // 打印倒三角形
        for (int i = 1; i <= 5; i++) {
            for (int j = i; j <= 5; j++) { // i = 1 2 3 4 5
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
