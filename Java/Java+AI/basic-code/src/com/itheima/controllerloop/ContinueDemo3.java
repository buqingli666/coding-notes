package com.itheima.controllerloop;

import java.util.Scanner;

public class ContinueDemo3 {
    static void main() {
        /*
         * continue 练习
         *
         * 牛牛在酒桌上玩一个小游戏，第一个人从 1 开始数数，如果遇到数字中含有数字 4 或数字是 4 的倍数，则
         * 跳过这个数字报下一个，谁数错了就要罚酒一杯。
         *
         * 牛牛为了作弊，它想将所有符合规则的数字预先生成出来。请你帮助牛牛列出 1 到 n 之间所有既不包含数字
         * 4 又不是 4 的倍数的整数，按升序输出。
         *
         * 输入描述:
         * 在一行中输入一个正整数 n，满足 1 ≤ n ≤ 10^5。
         *
         * 输出描述:
         * 按升序输出所有满足条件的整数，每个数字占一行。
         *
         * 示例1
         * 输入：9
         * 输出：1
         *      2
         *      3
         *      5
         *      6
         *      7
         *      9
         * 说明：在 1 到 9 中，数字 4 含有数字 4 且 4,8 为 4 的倍数，应跳过，剩余数字按升序输出。
         *
         */

        Scanner scanner = new Scanner(System.in);

        // 1. 判断输入是否满足条件
        int n;
        while (true) {
            System.out.println("输入一个正整数 n，满足 1 ≤ n ≤ 10^5：");
            n = scanner.nextInt();
            if (n >= 1 && n <= 100000) {
                break;
            } else {
                System.out.println("正整数n的范围有误！");
            }
        }

        // 2. 遍历 1 到 n
        for (int i = 1; i <= n; i++) {

            // 3. 判断条件一：是否是 4 的倍数
            boolean isMultipleOfFour = (i % 4 == 0);

            // 4. 判断条件二：是否包含数字 4 (拆位逻辑)
            boolean hasFour = false;
            int temp = i; // 用临时变量拆位
            while (temp > 0) {
                if (temp % 10 == 4) {
                    hasFour = true;
                    break; // 只要找到 4 就立刻结束拆位循环，提高效率
                }
                temp = temp / 10; // 去掉最后一位
            }

            // 5. 最终判断：既不是4的倍数，也不包含4，才输出
            if (!isMultipleOfFour && !hasFour) {
                System.out.println(i);
            }
        }
    }
}
