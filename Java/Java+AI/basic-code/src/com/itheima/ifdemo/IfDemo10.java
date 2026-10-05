package com.itheima.ifdemo;

import java.util.Scanner;

public class IfDemo10 {
    static void main() {
        /*
         * 练习：计算电费
         *
         * 用电量计算采取阶梯计费原则，规则如下：
         * 1. [0 ~ 100] 度，按 0.5 元/度计费
         * 2. (100 ~ 200] 度，按 0.8 元/度计费
         * 3. (超过 200] 度，按 1.2 元/度计费
         *
         * 输入变量 usage 表示实际用电量，
         * 输出总电费 cost。
         *
         * 示例输入：usage = 150
         * 示例输出：cost = 100 * 0.5 + 50 * 0.8 = 90
         *
         */

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入实际用电量：");
        int usage = scanner.nextInt();

        double cost = 0;
        if (usage > 0) {
            if (usage <= 100) {
                cost = usage * 0.5;
                System.out.println("cost = " + usage + " * 0.5 = " + cost);
            } else if (usage <= 200) {
                cost = 100 * 0.5 + (usage - 100) * 0.8;
                System.out.println("cost = 100 * 0.5 + " + (usage - 100) + " * 0.8 = " + cost);
            } else {
                cost = 100 * 0.5 + 100 * 0.8 + (usage - 200) * 1.2;
                System.out.println("cost = 100 * 0.5 + 100 * 0.8 + " + (usage - 200) + " * 1.2 = " + cost);
            }
        } else {
            System.out.println("实际用电量有误！");
        }

    }
}
