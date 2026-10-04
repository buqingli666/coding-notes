package com.itheima.variable;

public class VariableDemo1 {
    static void main() {
        /*
         * 变量
         *
         * 微信余额：100元
         * 支付宝余额：10元
         * 银行卡余额：20元
         * 问题一：请问现在一共有多少钱？
         * 问题二：微信收了10元红包，又发了2元红包，余额多少？
         *
         */

        // 1. 定义一个变量记录微信的余额
        double a = 100;
        // 2. 定义一个变量记录支付宝的余额
        double b = 10;
        // 3. 定义一个变量记录银行卡的余额
        double c = 20;

        // 4. 输出现在总共有多少钱？
        System.out.println(a + b + c);

        // 5. 微信收了10元红包
        a = a + 10;
        a = a - 2;

        // 6. 最终余额
        System.out.println(a);
    }
}
