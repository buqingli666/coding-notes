package com.itheima.ifdemo;

import java.util.Scanner;

public class IfDemo5 {
    static void main() {
        /*
         * if 语句练习
         *
         * 需求：小明在每次订外卖都会在多家平台对比，看谁的优惠力度更大
         * 已知：
         * 　　饱了么App：全场9折优惠
         * 　　美单App：满30减10元
         * 请问1：
         * 　　小明买了一顿烧烤50元，在哪家下单更划算
         * 请问2：
         * 　　如果价格不确定，数据由键盘录入而来呢？
         *
         * 细节：变量只在所属的大括号中是有效的
         *
         */

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入订单的价格：");
        double price = sc.nextDouble();

        // 1. 定义一个变量记录价格
        // double price = 50;

        // 2. 计算两个APP优惠之后的价格
        double baoleme = price * 0.9;
        System.out.println("饱了么App价格" + baoleme);

        double meidan = 0;
        if (price >= 30) {
            meidan = price - 10;
        } else {
            meidan = price; // 原价
        }
        System.out.println("美单App价格" + meidan);

        if (meidan < baoleme) {
            System.out.println("美单App更划算");
        } else {
            System.out.println("饿了么App更划算");
        }

    }
}
