package com.itheima.operator;

import java.util.Scanner;

public class OperatorDemo8 {
    static void main() {
        /*
         * 关系运算符/比较运算符 == != > >= < <=
         *
         * 练习1：键盘录入你和你好基友的身高，比一比谁更高？
         *
         */

        // 1. 键盘录入两个小数，分别表示我和好基友的身高
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的身高：");
        double myHeight = sc.nextDouble();
        System.out.println("请输入你好基友的身高：");
        double friendHeight = sc.nextDouble();

        // 2.比较
        boolean result = myHeight >= friendHeight;
        System.out.println(result);

    }
}
