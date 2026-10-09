package com.itheima.oop.oop01;

public class DogTest {
    static void main() {
        /*
         * 创建对象的格式：
         * 类名 对象名 = new 类名();
         *
         */

        // 创建对象，记录第一只小狗的信息
        Dog dog1 = new Dog();

        // 赋值
        dog1.name = "黑子";
        dog1.age = 3;
        dog1.weight = 15;
        dog1.color = "黑色";

        // 获取第一只小狗的信息
        System.out.println(dog1.name);
        System.out.println(dog1.age);
        System.out.println(dog1.weight);
        System.out.println(dog1.color);


        // 创建第二个对象，管理第二只小狗的信息
        Dog dog2 = new Dog();

        // 赋值
        dog2.name = "小白";
        dog2.age = 2;
        dog2.weight = 4;
        dog2.color = "白色";

        // 获取第二只小狗的信息
        System.out.println(dog2.name);
        System.out.println(dog2.age);
        System.out.println(dog2.weight);
        System.out.println(dog2.color);

    }
}
