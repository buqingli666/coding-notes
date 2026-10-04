package com.itheima.variable;

public class VariableDemo5 {
    static void main() {

        // BMI = 体重 / 身高的平方

        // 1. 定义变量记录我的体重 55.6KG
        double weight = 55.6;

        // 2. 定义变量记录我的身高 1.75M
        double height = 1.75;

        // 3. 计算BMI
        double bmi = weight / (height * height);

        System.out.println(bmi);

        // 扩展：
        // 计算出你当前的身高，在标准BMI下，最多是多少千克？

        // 标准（正常）BMI的上限是 23.9
        double maxStandardBmi = 23.9;

        // 公式：体重 = BMI * 身高的平方
        double maxWeight = maxStandardBmi * (height * height);

        System.out.println("在标准BMI下，我的最大体重是：" + maxWeight + "千克");

    }
}
