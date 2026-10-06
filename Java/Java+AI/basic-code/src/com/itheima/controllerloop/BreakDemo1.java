package com.itheima.controllerloop;

public class BreakDemo1 {
    static void main() {
        /*
         * break 关键字
         * 不能单独出现，只能写在switch或者循环当中，表示结束、跳出的意思
         *
         */

        for (int i = 1; i <= 100; i++) {
            if (i == 15) {
                break; // 看到break关键字，循环就直接结束了
            }
            System.out.println(i); // 打印 1 - 14
        }
    }
}
