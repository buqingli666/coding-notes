package com.itheima.oop.opp06;

public class Student {

    private String name;
    private int age;

    // 构造方法
    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

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

    // 测试方法：验证对象传递
    public static void changeStudent(Student s) {
        // 这里接收到的 s 也是地址的拷贝，指向堆里的同一个对象
        s.setName("被修改了");
    }

    // 测试方法：验证 this
    public void printThisAddress() {
        System.out.println("这个方法的调用者(this)的地址是：" + this);
    }
}
