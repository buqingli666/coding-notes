package com.itheima.controllerloop;

public class ContinueDemo2 {
    static void main() {
        /*
         * continue 练习
         *
         * 循环打印1～100之间的数字，如果数字包含7或者是7的倍数，输出”过”
         * 分析：
         *     包含7：个位是7或者十位是7
         *     7的倍数：对7取余等于0
         *
         */

        for (int i = 1; i <= 100; i++) {
            if (i % 10 == 7 || i / 10 % 10 == 7 || i % 7 == 0) {
                System.out.println("过");
                continue;
            }
            System.out.println(i);
        }

    }
}
