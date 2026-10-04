package com.itheima.operator;

import java.util.Scanner;

public class OperatorDemo9 {
    static void main() {
        /*
         * 关系运算符/比较运算符 == != > >= < <=
         *
         * 练习2：键盘录入一个3位数，判断是否能被3整除
         *
         */

        // 1.键盘录入一个三位数
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一位三位数：");
        int num = scanner.nextInt();

        // 2.拆分
        int ge = num % 10;
        int shi = num / 10 % 10;
        int bai = num / 100 % 10;

        // 3.求和
        int sum = ge + shi + bai;

        // 4.判断是否能被3整除
        boolean res = sum % 3 == 0;
        System.out.println(res);

    }
}
