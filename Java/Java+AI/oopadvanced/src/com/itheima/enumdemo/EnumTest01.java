package com.itheima.enumdemo;

public class EnumTest01 {
    static void main() {
        /*
         * 电商项目中，订单的状态只有以下6种，请编写代码实现。
         *
         * 待支付   PAYMENT_PENDING
         * 处理中   PROCESSING
         * 已发货   SHIPPED
         * 配送中   OUT_FOR_DELIVERY
         * 已送达   DELIVERED
         * 已取消   CANCELLED
         *
         */

        // 获取枚举类的对象
        // 细节：所有的枚举项，默认使用public static final修饰的
        OrderState o1 = OrderState.PAYMENT_PENDING;
        System.out.println(o1);
        System.out.println(o1.getDescription());

        // 匹配
        switch (o1) {
            case PAYMENT_PENDING -> System.out.println("待支付");
            case PROCESSING -> System.out.println("处理中");
            case SHIPPED -> System.out.println("已发货");
            case OUT_FOR_DELIVERY -> System.out.println("配送中");
            case DELIVERED -> System.out.println("已送达");
            case CANCELLED -> System.out.println("已取消");
        }

    }
}
