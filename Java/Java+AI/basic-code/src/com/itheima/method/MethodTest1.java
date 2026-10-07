package com.itheima.method;

import java.util.Scanner;

public class MethodTest1 {
    static void main() {
        /*
         * 跳水比赛有五个评委打分，分数在0～100之间。最终得分会去掉一个最高分，去掉一个最低分，
         * 剩余的分数再求平均数，改平均数为选手最终得分。
         *
         * 要求1：利用键盘录入5个整数存入数组当中，如果分数超出范围需要重新录入
         * 要求2：定义方法分别求数组的最大值和最小值
         * 要求3：计算五名评委的总分
         * 要求4：总分 - 最大值 - 最小值，求选手最终平均分
         *
         */

        // 1. 创建数组，用于存储评委打分
        int[] scores = new int[5];
        Scanner sc = new Scanner(System.in);

        // 2. 键盘录入5个整数
        for (int i = 0; i < scores.length; ) {
            System.out.print("请输入第 " + (i + 1) + " 位评委的分数：");
            int score = sc.nextInt();

            // 判断分数是否合法
            if (score >= 0 && score <= 100) {
                scores[i] = score;
                i++; // 只有分数合法时，索引才自增
            } else {
                System.out.println("输入分数超出范围，请重新录入！");
            }
        }

        // 3. 调用方法获取最大值、最小值和总分
        int max = getMax(scores);
        int min = getMin(scores);
        int sum = getSum(scores);

        System.out.println("最高分：" + max);
        System.out.println("最低分：" + min);
        System.out.println("总分：" + sum);

        // 4. 计算最终得分
        double finalScore = (sum - max - min) / (scores.length - 2.0);
        System.out.println("选手最终得分：" + finalScore);

    }

    // 获取数组最大值
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    // 获取数组最小值
    public static int getMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    // 获取数组总和
    public static int getSum(int[] arr) {
        int sum = 0;
        for (int score : arr) {
            sum += score;
        }
        return sum;
    }

}
