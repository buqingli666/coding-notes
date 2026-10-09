package com.itheima.finaldemo;

public class Circle {

    // 属性：半径
    private double radius;

    // 属性：圆周率（常量）
    private final double PI = 3.14;

    // 无参构造方法
    public Circle() {
    }

    // 全参构造方法
    public Circle(double radius) {
        this.radius = radius;
    }

    // get/set
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getPI() {
        return PI;
    }

    /*
     * 行为：计算圆的面积
     * 公式：面积 = 圆周率 * 半径 * 半径
     */
    public double getArea() {
        return PI * radius * radius;
    }

    /*
     * 行为：计算圆的周长
     * 公式：周长 = 2 * 圆周率 * 半径
     */
    public double getPerimeter() {
        return 2 * PI * radius;
    }

}
