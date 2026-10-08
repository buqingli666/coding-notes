package com.itheima.practice;

import java.util.Random;

public class RedPacket {
    static void main() {
        /*
         * 给你两个整数 M 和 N，M 表示红包的总额，N 表示红包的个数。
         * 现在有 N 个人来抽红包，每个人都是随机的，打印每个人领的红包金额。
         *
         * 要求1：每个人最少1分钱
         * 要求2：每个人领完红包之后，至少预留 1 * N 分钱
         * 要求3：最后一个人是拿剩余的总额
         *
         */

        // 1.定义变量表示红包的总额
        int money = 20000; // 分

        // 2.定义变量表示红包的个数
        int n = 5;

        // 判断红包的金额要足够
        if (money < n) {
            System.out.println("红包金额不够，请充值~");
        } else {
            // 3.利用循环抽取红包
            Random r = new Random();
            for (int i = 1; i <= n - 1; i++) {
                // 利用Random进行随机抽取
                // 1 2 3 4 表示当前是第几个人抽取
                // 4 3 2 1 表示最少预留的钱,单位分
                // 第一个人抽取红包: 20000 - (5 - 1)

                // money - (n - i) : 目的为了给后面的人预留至少一分钱
                // +1 : 目前保证自己最少抽取一分钱
                int myMoney = r.nextInt(money - (n - i)) + 1;

                // 从总额中减去当前抽取到的钱
                money = money - myMoney;

                System.out.println("第" + i + "个人, 抢到" + myMoney + "分");
            }

            // 4. 输出最后一个人抢到的钱
            System.out.println("第" + n + "个人, 抢到" + money + "分");
        }

    }
}
