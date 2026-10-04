package com.itheima.operator;

import java.util.Scanner;

public class OperatorDemo2 {
    static void main() {
        /*
         * 运算符练习 - 数值拆分
         *
         * 键盘录入一个三位数，将其拆分为个位、十位、百位后，打印在控制台
         *
         */

        // 1. 键盘录入
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个三位数：");
        int number = scanner.nextInt();
        System.out.println(number);

        // 2.拆分
        // 个位 123 % 10 = 12...3
        int ge = number % 10;
        System.out.println("个位：" + ge);

        // 十位 123 / 10 = 12 % 10 = 1...2
        int shi = (number / 10) % 10;
        System.out.println("十位：" + shi);

        // 百位 123 / 100 = 1 % 10 = 0...1
        int bai = (number / 100) % 10;
        System.out.println("百位：" + bai);

    }
}
