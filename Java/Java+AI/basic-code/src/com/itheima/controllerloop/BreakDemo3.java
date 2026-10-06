package com.itheima.controllerloop;

import java.util.Scanner;

public class BreakDemo3 {
    static void main() {
        /*
         * break 练习
         *
         * 键盘录入一个大于等于2的整数，判断是否为质数
         * 质数：
         *    必须大于1（0和1都不是质数）
         *    只能被1和自身整除：
         *       2 = 1 × 2 （是质数，且是唯一的偶质数）
         *       3 = 1 × 3 （是质数）
         *       5 = 1 × 5 （是质数）
         *       7 = 1 × 7 （是质数）
         *       4 = 1 × 4 = 2 × 2 （不是质数，因为它还能被 2 整除，这种数叫“合数”）
         *       6 = 1 × 6 = 2 × 3 （不是质数）
         *
         */

        // 1.键盘录入一个大于等于2的整数
        Scanner scanner = new Scanner(System.in);

        int number = 0;
        while (true) {
            System.out.println("请输入一个大于等于2的整数：");
            number = scanner.nextInt();
            if (number >= 2) {
                break;
            } else {
                System.out.println("数字不合法");
            }
        }

        // 2.判断number记录的数据，是否为一个质数
        int count = 0;
        for (int i = 2; i <= number - 1; i++) {
            if (number % i == 0) {
                count++;
                // 只要找到了一个数字能被number整除，那么number就不是质数，后面的数据就没有必要再判断了
                break;
            }
        }

        //3.判断count
        if (count == 0) {
            System.out.println(number + "是质数");
        } else {
            System.out.println(number + "不是质数");
        }

    }
}
