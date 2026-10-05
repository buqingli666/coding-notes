package com.itheima.ifdemo;

import java.util.Scanner;

public class IfDemo11 {
    static void main() {
        /*
         * 练习：是否构成三角形
         *
         * 键盘录入任意三个大于0的小数，判断这三个数值构成什么类型的三角形？
         * 需要判断的类型如下：等边、等腰、直角、普通、无效
         *
         * 条件：两边之和 > 第三边
         *
         */

        // 1. 键盘录入三个小数
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个小数：");
        double a = sc.nextDouble();
        System.out.println("请输入第二个小数：");
        double b = sc.nextDouble();
        System.out.println("请输入第三个数：");
        double c = sc.nextDouble();

        // 2. 校验数据合法性
        if (a > 0 && b > 0 && c > 0) {
            if (a + b > c && b + c > a && a + c > b) {
                // 3. 判断类型（顺序不能乱）
                if (a == b && b == c) {
                    System.out.println("等边三角形");

                } else if (a == b || b == c || a == c) {
                    System.out.println("等腰三角形");

                } else if (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a) {
                    System.out.println("直角三角形");

                } else {
                    System.out.println("普通三角形");
                }
            } else {
                System.out.println("无效三角形");
            }
        } else {
            System.out.println("边长不能小于或等于0");
        }

    }
}
