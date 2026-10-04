package com.itheima.variable;

import java.util.Scanner;

public class VariableDemo7 {
    static void main() {
        /*
         * 键盘录入练习 - 两数之和
         *
         * 定义两个整数类型的变量num1和num2，键盘录入数据分别为两个变量赋值。
         * 求两个数的和并进行打印。
         *
         */

        Scanner scanner = new Scanner(System.in);

        System.out.println("请键盘录入第一个整数：");
        int num1 = scanner.nextInt();

        System.out.println("请键盘录入第二个整数：");
        int num2 = scanner.nextInt();

        int total = num1 + num2;

        System.out.println(total);
    }
}
