package com.itheima.controllerloop;

public class ContinueDemo1 {
    static void main() {
        /*
         * continue 关键字
         *
         * 不能单独书写，只能写循环中，结束本次循环，继续下次循环
         *
         */

        for (int i = 1; i <= 10; i++) {

            if (i == 3) {
                continue;
            }

            System.out.println(i);
        }
    }
}
