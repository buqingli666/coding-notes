package com.itheima.loopwhile;

import java.util.Scanner;

public class WhileDemo5 {
    static void main() {
        /*
         * while 循环练习
         *
         * 描述
         * 给定一个整数n，请计算其所有数位之和。若n为负数，请先取其绝对值。
         * 示例1
         * 输入：12
         * 说明：1 + 2 = 3
         * 输出：3
         * 示例2
         * 输入：-305
         * 说明：获取绝对值305，再求和3 + 0 + 5 = 8
         * 输出：8
         *
         */

        // 1. 键盘录入一个整数
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数： ");
        int number = sc.nextInt();

        // 2.获取number的绝对值
        // 正数 0 本身 负数 相反数
        if (number < 0) {
            number = -number;
        }

        // 3. 定义求和变量
        int sum = 0;
        // 4. 利用循环获取number上的每一位数字
        // 305:
        //   个位: number % 10 --- 5
        //   去掉个位: number / 10 --- 30
        //   个位: number % 10 --- 0
        //   去掉个位: number / 10 --- 3
        //   个位: number % 10 --- 3
        //   去掉个位: number / 10 --- 0
        while (number != 0) {
            // 获取个位
            int ge = number % 10;
            sum = sum + ge;

            // 去掉个位
            number = number / 10;
        }

        // 5. 输出结果
        System.out.println("各数位之和为：" + sum);

    }
}
