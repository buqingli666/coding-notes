package com.itheima.oop.oop02;

public class Student {
    /*
     * 面向对象的小细节
     *
     * 1. 描述一类事物的类叫JavaBean类
     * 2. 带有main方法的类叫测试类
     * 3. JavaBean类可以写属性和行为(方法不加 static 关键字)
     *
     */

    // 1. 属性
    // 名字
    String name;
    // 性别
    char gender;
    // 年龄
    int age;
    // 身高
    double height;

    // 2. 行为(方法)
    // 学习
    public void study() {
        System.out.println("学生在学习～");
    }

    // 睡觉
    public void sleep() {
        System.out.println("学生在睡觉～");
    }

    // 吃饭
    public void eat() {
        System.out.println("学生在吃饭～");
    }

}
