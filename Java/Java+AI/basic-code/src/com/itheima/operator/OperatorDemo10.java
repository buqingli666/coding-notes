package com.itheima.operator;

import java.util.Scanner;

public class OperatorDemo10 {
    static void main() {
        /*
         * 逻辑运算符 - 与(&) 或(|) 非(!)
         *
         * 练习1：键盘录入一个整数，判断这个数字是否在1～10之间
         *
         */

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int num = scanner.nextInt();

        boolean res = num >= 1 & num <= 10;
        System.out.println(res);

    }
}
