package com.itheima.loopfor;

import java.util.Scanner;

public class ForDemo7 {
    static void main() {
        /*
         * for 循环练习
         *
         * 描述：
         * 牛牛开始学习数列啦。现在他想计算以下数列前n项的和：
         * S(n) = 1 - 2 + 3 - 4 + ...
         *
         * 示例1：
         * 输入：4
         * 说明：S(4) = 1 - 2 + 3 - 4 = -2
         * 输出：-2
         *
         */

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入n的值：");
        int n = scanner.nextInt();

        // 2. 定义求和变量
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                // 偶数
                sum = sum - i;
            } else {
                // 奇数
                sum = sum + i;
            }
        }

        System.out.println(sum);
    }
}
