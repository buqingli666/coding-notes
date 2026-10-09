package com.itheima.oop.oop03;

public class Car {
    /*
     * 1. private关键字：是一个权限修饰符，可以修饰成员变量和成员方法。
     *    特点：被private修饰的成员只能在本类中才能访问。
     *
     * 2. 针对private修饰的成员变量，需提供以下操作：
     *    提供setXxx(参数)，给成员变量赋值，用public修饰。
     *    提供getXxx()，获取成员变量的值，用public修饰。
     *
     * 3. 就近原则
     *    在方法当中直接使用变量查找顺序：先找局部变量，再找成员变量
     *
     * 4. this的作用？
     *    可以区别成员变量和局部变量
     *    System.out.println(age);      // 触发就近原则
     *    System.out.println(this.age); // 使用成员变量
     *
     */

    // 品牌
    private String brand;

    // 型号
    private String model;

    // 颜色
    private String color;

    // 价格
    private double price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand; // this.brand 是成员变量，= 后面的 brand 是局部变量（参数）
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void run() {
        System.out.println(this.brand + " " + this.model + " 汽车正在行驶");
    }

    public void showInfo() {
        String brand = "这是一个局部变量品牌"; // 局部变量，与成员变量同名
        double price = 999.9;              // 局部变量，与成员变量同名

        // 1. 触发就近原则（直接使用变量名，优先找局部的）
        System.out.println("直接访问 brand: " + brand); // 打印：这是一个局部变量品牌
        System.out.println("直接访问 price: " + price); // 打印：999.9

        // 2. 使用 this 访问成员变量
        System.out.println("this.brand: " + this.brand); // 打印：真实的汽车品牌
        System.out.println("this.price: " + this.price); // 打印：真实的汽车价格
    }

}
