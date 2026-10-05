package com.itheima.ifdemo;

import java.util.Scanner;

public class IfDemo6 {
    static void main() {
        /*
         * if 语句练习 - 卡拉兹函数
         *
         * 定义：
         * 给定正整数 n，
         * 若 n 为奇数，则 f(n) = 3n + 1
         * 若 n 为偶数，则 f(n) = n / 2
         *
         * 示例1：
         * 输入：1
         * 说明：奇数，3 * 1 + 1 = 4
         * 输出：4
         *
         * 示例2：
         * 输入：2
         * 说明：偶数，2 * / 2 = 1 (注：这里原图有笔误，应该是 2 / 2 = 1)
         * 输出：1
         *
         */

        // 1. 键盘录入一个正整数 n
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个正整数 n：");
        int n = sc.nextInt();

        // 2. 定义变量记录结果
        int result;

        // 3. 判断奇偶并计算
        if (n % 2 != 0) {
            // 奇数：3n + 1
            result = 3 * n + 1;
            System.out.println("说明：奇数，3 * " + n + " + 1 = " + result);
        } else {
            // 偶数：n / 2
            result = n / 2;
            System.out.println("说明：偶数，" + n + " / 2 = " + result);
        }

        // 4. 输出结果
        System.out.println("输出：" + result);

    }
}
