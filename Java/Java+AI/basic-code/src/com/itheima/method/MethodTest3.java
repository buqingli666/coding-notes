package com.itheima.method;

import java.util.Scanner;

public class MethodTest3 {
    static void main() {
        /*
         * 需求：某快递公司的运费规则如下（首重1kg，超出部分按kg计算，不足1kg按1kg算）：
         * 首重1kg：10元；
         * 超出1-5kg：每kg加2元；
         * 超出5kg以上：每kg加1.5元。
         *
         * 要求1：快递重量必须大于0，否则重新输入
         * 要求2：不同价位的计算，单独定义一个方法
         *
         */

        Scanner sc = new Scanner(System.in);
        double weight;

        // 1. 键盘录入并校验
        while (true) {
            System.out.print("请输入快递重量(kg)：");
            weight = sc.nextDouble();
            if (weight > 0) {
                break; // 重量合法，跳出循环
            } else {
                System.out.println("快递重量必须大于0，请重新输入！");
            }
        }

        // 2. 调用方法计算运费
        double freight = getFreight(weight);

        // 3. 输出结果
        System.out.println("您的快递最终运费为：" + freight + " 元");

    }


    /**
     * 单独定义的计费方法
     *
     * @param weight 用户输入的原始重量（可能是小数）
     * @return 计算出的最终运费
     */
    public static double getFreight(double weight) {

        // 核心：不足1kg按1kg算，这里进行向上取整
        // Math.ceil(5.1) = 6.0，强转为 int 变成 6
        int w = (int) Math.ceil(weight);

        double price = 0.0;

        if (w <= 1) {
            // 首重 1kg 及以内
            price = 10.0;
        } else if (w <= 5) {
            // 超出 1-5kg 的部分
            // 首重10元 + (超出1kg的部分 * 2元)
            price = 10.0 + (w - 1.0) * 2.0;
        } else {
            // 超出 5kg 以上
            // 首重10元 + (1-5kg的4kg * 2元) + (超出5kg的部分 * 1.5元)
            price = 10.0 + 8.0 + (w - 5.0) * 1.5;
        }
        return price;
    }
}
