package com.itheima.variable;

import java.util.Scanner;

public class VariableDemo6 {
    static void main() {
        /*
         * 键盘录入 - Scanner
         *
         */

        // 1. 找到 Scanner 这个打工人
        Scanner sc = new Scanner(System.in);

        // 2. 让 Scanner 干活
        // 接收键盘录入的整数 - nextInt()
//        int num = sc.nextInt();
//        System.out.println(num);

        // 接收键盘录入的小数 - nextDouble()
//        double num2 = sc.nextDouble();
//        System.out.println(num2);

        // 接收键盘录入的文本（字符串） - next()
        String str = sc.next();
        System.out.println(str);
    }
}
