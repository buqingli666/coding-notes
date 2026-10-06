package com.itheima.loopwhile;

public class WhileDemo3 {
    static void main() {
        /*
         * while 循环练习
         *
         * 假设你在银行投资了100000元，银行给出的复利是1.7%，问多少年后能实现本金翻倍？
         * 请问：用什么循环呢？代码如何实现？
         *
         * for：范围、次数
         * while：结束条件
         *
         */

        // 1. 定义变量记录本金
        double money = 100000;

        // 2. 定义变量记录期望的本金
        double expectMoney = 200000;

        // 3. 定义变量记录年数
        int year = 0;

        // 4. 利用循环计算需要多少年本金才能翻倍
        // while: 条件判断语句 money < expectMoney
        while (money < expectMoney) {
            // 计算一年的本金 + 利息
            money = money + money * 0.017;
            // 年 + 1
            year++;
        }

        System.out.println(year);

        // 单利
        // 计算一年的利息
        // System.out.println(100000 / (money * 0.017));
    }
}
