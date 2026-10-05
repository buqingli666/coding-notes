package com.itheima.ifdemo;

import java.util.Scanner;

public class IfDemo8 {
    static void main() {
        /*
         * 练习：充卡赠送
         *
         * 卡类型   充值金额   赠送金额   附加政策
         * ---------------------------------------------------------------------------------------
         * 次卡     1000元    可结算门票30次   次卡为结算门票专用卡，每日限结10次
         * ---------------------------------------------------------------------------------------
         * 储值卡   1000元    200元     门票39元/位
         * 储值卡   2000元    500元     持卡本人及同行客人门票35元/次
         * 储值卡   3000元    700元     持卡本人及同行客人门票35元/次
         * 储值卡   5000元    1300元    持卡本人及同行客人门票35元/次
         * 储值卡   10000元   2500元    1. 持卡本人及同行客人门票30元/次 2. 送专属更衣柜一个
         * 储值卡   20000元   6000元    1. 持卡本人及同行客人门票30元/次 2. 送专属更衣柜一个
         * 储值卡   50000元   15000元   1. 持卡本人及同行客人门票30元/次 2. 送专属更衣柜一个 3. 送专属浴服一套
         *
         * 要求：忽略次卡规则，请计算充值不同的额度，卡里余额是多少？
         *
         */

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入充值金额：");
        int money = scanner.nextInt();

        // 定义变量记录卡里余额
        int balance = 0;
        if (money > 0) {
            if (money < 1000) {
                balance = money;
            } else if (money < 2000) {
                balance = money + 200;
            } else if (money < 3000) {
                balance = money + 500;
            } else if (money < 5000) {
                balance = money + 700;
            } else if (money < 10000) {
                balance = money + 1300;
            } else if (money < 20000) {
                balance = money + 2500;
            } else if (money < 50000) {
                balance = money + 6000;
            } else {
                balance = money + 15000;
            }

            System.out.println("充值：" + money + "元，您的卡里余额为：" + balance + "元");

        } else {
            System.out.println("充值金额有误！");
        }

    }
}
