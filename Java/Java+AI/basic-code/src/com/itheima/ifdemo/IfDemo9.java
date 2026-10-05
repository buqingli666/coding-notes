package com.itheima.ifdemo;

import java.util.Scanner;

public class IfDemo9 {
    static void main() {
        /*
         * 练习：计算BMI
         *
         * 键盘录入你的身高和体重，计算BMI
         * BMI身体质量指数计算公式：BMI = 体重 ÷ 身高² （体重单位：千克，身高单位：米）
         *
         * BMI 数值(kg/m²)   身体状态   健康风险
         * -------------------------------------------
         * < 18.5            消瘦      部分增加
         * 18.5 - 23.9       正常      正常
         * 24.0 - 26.9       偏胖      增加
         * 27.0 - 29.9       肥胖      中度增加
         * >= 30             严重肥胖   严重增加
         *
         */

        // 1. 键盘录入身高体重
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的身高(M)：");
        double height = scanner.nextDouble();
        System.out.println("请输入你的体重(KG)：");
        double weight = scanner.nextDouble();

        // 2. 计算BMI
        double bmi = weight / (height * height);

        // 3. 定义变量记录状态和风险
        String status = "";
        String risk = "";

        // 4. 判断身体状态
        if (bmi < 18.5) {
            status = "消瘦";
            risk = "部分增加";
        } else if (bmi < 24.0) {
            status = "正常";
            risk = "正常";
        } else if (bmi < 27.0) {
            status = "偏胖";
            risk = "增加";
        } else if (bmi < 30.0) {
            status = "肥胖";
            risk = "中度增加";
        } else {
            status = "严重肥胖";
            risk = "严重增加";
        }

        // 5. 输出结果 (保留两位小数)
        System.out.printf("您的BMI数值为：%.2f，身体状态：%s，健康风险：%s%n", bmi, status, risk);

    }
}
