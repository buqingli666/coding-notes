package com.itheima.variable;

import java.util.Scanner;

public class VariableDemo8 {
    static void main() {
        // BMI = 体重 / 身高的平方

        Scanner scanner = new Scanner(System.in);

        // 1. 键盘录入体重 KG
        System.out.println("请输入您的体重：");
        double weight = scanner.nextDouble();

        // 2. 键盘录入身高 M
        System.out.println("请输入您的身高：");
        double height = scanner.nextDouble();

        // 3. 计算BMI
        double bmi = weight / (height * height);

        System.out.println(bmi);
    }
}
