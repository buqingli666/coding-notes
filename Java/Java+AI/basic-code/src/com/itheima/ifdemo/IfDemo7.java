package com.itheima.ifdemo;

public class IfDemo7 {
    static void main() {
        /*
         * if 语句的第三种格式
         *    if (关系表达式A) {
         *        语句体A;
         *    } else if(关系表达式B){
         *        语句体B;
         *    } else if(关系表达式C){
         *        语句体C;
         *    }
         *    ...
         *    else {
         *        语句体N;
         *    }
         *
         * 需求：很多App都有不同的优惠券，假设，现在有以下优惠券
         * 　　全场商品满10减8
         * 　　全场商品满50减30
         * 　　全场商品满100减50
         * 　　全场商品满200减90
         *
         * 　　会员卡：全场8折
         * 请问： 会员卡和优惠券不能同时使用，最优惠的价格是多少？
         *
         */

        // 1. 定义商品价格
        double price = 1000;

        // 2. 计算使用优惠券后的价格
        double couponPrice = 0;
        if (price > 0) {
            if (price < 10) {
                couponPrice = price;
            } else if (price < 50) {
                couponPrice = price - 8;
            } else if (price < 100) {
                couponPrice = price - 30;
            } else if (price < 200) {
                couponPrice = price - 50;
            } else {
                couponPrice = price - 90;
            }
        } else {
            System.out.println("商品价格有误");
        }

        // 3. 计算使用会员卡后的价格
        double memberPrice = price * 0.8;

        // 4. 比较并输出最优惠的最终价格
        if (couponPrice < memberPrice) {
            System.out.println("使用优惠券的价格更低：" + couponPrice);
        } else if (memberPrice < couponPrice) {
            System.out.println("使用会员卡的价格更低：" + memberPrice);
        } else {
            System.out.println("两者价格一样，都是：" + couponPrice);
        }

    }
}
