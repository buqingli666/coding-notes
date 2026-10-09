package com.itheima.enumdemo;

public enum OrderState {
    /*
     * 枚举的定义格式
     * 枚举类的对象是有限个的
     *
     * public enum 枚举类名 {
     *     枚举项1, 枚举项2, 枚举项3;
     *     属性
     *     行为
     * }
     *
     * // 使用枚举对象,不要自己创建，直接调用就可以了
     * 枚举类名.枚举项;
     *
     */

    // 枚举项 (状态名称, 中文描述)
    PAYMENT_PENDING("待支付"),
    PROCESSING("处理中"),
    SHIPPED("已发货"),
    OUT_FOR_DELIVERY("配送中"),
    DELIVERED("已送达"),
    CANCELLED("已取消");

    // 属性：中文描述
    private final String description;

    // 构造方法
    OrderState(String description) {
        System.out.println("执行构造方法：" + description);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
