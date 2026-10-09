package com.itheima.oop.oop05;

// 厨师类
public class Cook {
    // 名字
    private String name;
    // 年龄
    private int age;

    // 构造方法
    public Cook() {
    }

    public Cook(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // set/get
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 行为(方法)
    public void cook() {
        System.out.println(name + "正在做饭～");
    }

    public void sleep() {
        System.out.println(name + "正在睡觉～");
    }

    public void eat() {
        System.out.println(name + "正在吃饭～");
    }
}
