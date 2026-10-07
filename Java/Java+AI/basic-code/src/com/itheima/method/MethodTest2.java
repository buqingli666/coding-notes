package com.itheima.method;

import java.util.Scanner;

public class MethodTest2 {
    static void main() {
        /*
         * 需求：
         * 统计10名学生的数学成绩（0-100分），计算及格率、平均分，并找出最高分。
         *
         * 要求1：键盘录入10名学生的成绩，存入数组。超出范围，提示“成绩无效，请重新输入”。
         * 要求2：定义方法求及格人数，根据及格人数，求及格率。
         * 要求3：定义方法求总分，根据总分求平均分。
         * 要求4：定义方法求最大值。
         *
         */

        // 1. 创建长度为10的数组
        int[] scores = new int[10];
        Scanner sc = new Scanner(System.in);

        // 2. 键盘录入10个成绩
        for (int i = 0; i < scores.length; ) {
            System.out.print("请输入第 " + (i + 1) + " 名学生的成绩：");
            int score = sc.nextInt();
            // 校验分数是否在合法范围
            if (score >= 0 && score <= 100) {
                // 输入成绩有效，存入数组
                scores[i] = score;
                i++;
            } else {
                // 输入成绩无效
                System.out.println("成绩无效，请重新输入");
            }
        }

        // 3. 调用方法获取及格人数、总分、最高分
        int passCount = getPassCount(scores);
        int sum = getSum(scores);
        int max = getMax(scores);

        // 4. 计算及格率和平均分
        // 重点：除数写成 10.0 或 (scores.length * 1.0)，保留小数精度
        double passRate = passCount / (scores.length * 1.0) * 100;
        double avgScore = sum / (scores.length * 1.0);

        // 5. 输出结果
        System.out.println("及格人数：" + passCount + " 人");
        System.out.println("及格率：" + passRate + "%");
        System.out.println("总分：" + sum + " 分");
        System.out.println("平均分：" + avgScore + " 分");
        System.out.println("最高分：" + max + " 分");


    }

    // 求及格人数的方法
    public static int getPassCount(int[] arr) {
        int count = 0; // 记录及格人数
        for (int score : arr) {
            if (score >= 60) {
                count++;
            }
        }
        return count;
    }

    // 求总分的方法
    public static int getSum(int[] arr) {
        int sum = 0;
        for (int score : arr) {
            sum += score;
        }
        return sum;
    }

    // 求最大值的方法
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
}
