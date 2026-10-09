package com.itheima.oop.oop04;

public class Teacher {
    /*
     * 构造方法
     *
     * 特点：
     * 1. 方法名与类名相同，大小写也要一致
     * 2. 没有返回值类型，连void都没有
     * 3. 没有具体的返回值（不能由return带回结果数据）
     *
     * 执行时机：
     * 1. 创建对象的时候由虚拟机调用，不能手动调用构造方法
     * 2. 每创建一次对象，就会调用一次构造方法
     *
     * 构造方法注意事项
     * 1. 如果没有定义构造方法，系统将给出一个默认的无参数构造方法。
     * 2. 如果自己写了任意构造方法，系统将【不再提供】默认的构造方法。
     *
     */

    // 属性
    private String name;
    private int age;
    private char gender;
    private double height;

    // 构造方法 ---> 空参
    public Teacher() {
    }

    // 构造方法 ---> 全参
    public Teacher(String name, int age, char gender, double height) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.height = height;
    }

    // get/set 方法
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public char getGender() {
        return gender;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

}
