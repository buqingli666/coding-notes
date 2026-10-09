package com.itheima.finaldemo;

public class FinalTest02 {
    static void main() {
        /*
         * 定义一个Javabean类描述圆
         * 属性：半径和圆周率
         * 行为：计算圆的面积和周长
         *
         */

        // 创建对象
        Circle c = new Circle(1.5);

        // 获取属性
        System.out.println(c.getRadius());
        System.out.println(c.getPI());

        // 获取圆的面积
        System.out.println(c.getArea());

        // 获取圆的周长
        System.out.println(c.getPerimeter());

    }
}
