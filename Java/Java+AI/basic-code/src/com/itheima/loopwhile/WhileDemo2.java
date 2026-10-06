package com.itheima.loopwhile;

import java.util.Scanner;

public class WhileDemo2 {
    static void main() {
        /*
         * for 和 while 的区别：
         *
         * 1. for循环中：知道循环次数或者循环的范围
         *    （比如：求1-100的和、遍历数组、打印5次Hello）
         *
         * 2. while循环：不知道循环的次数和范围，只知道循环的结束条件。
         *    （比如：未知次数的登录密码验证、读取文件直到文件末尾）
         *
         */

        // 场景一：适合用 for 循环（次数明确）
        int sum = 0;
        for (int i = 1; i <= 100; i++) { // 范围明确：1~100
            sum += i;
        }

        // 场景二：适合用 while 循环（次数未知，条件明确）
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入密码：");
        int password = sc.nextInt();

        // 只要密码不对，就一直让用户重新输入
        while (password != 123456) {
            System.out.println("密码错误，请重新输入：");
            password = sc.nextInt();
        }
        System.out.println("登录成功！");
    }
}
