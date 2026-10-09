package com.itheima.oop.oop05;

public class CookTest {
    static void main() {

        // 创建对象
        Cook cook = new Cook();
        cook.setName("zhangsan");
        cook.setAge(33);
        System.out.println(cook.getName());
        System.out.println(cook.getAge());
        cook.cook();
        cook.sleep();
        cook.eat();

        // 创建对象
        Cook cook1 = new Cook("lisi", 26);
        System.out.println(cook1.getName());
        System.out.println(cook1.getAge());
        cook1.cook();
        cook1.sleep();
        cook1.eat();

    }
}
