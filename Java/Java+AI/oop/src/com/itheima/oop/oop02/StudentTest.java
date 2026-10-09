package com.itheima.oop.oop02;

public class StudentTest {
    static void main() {
        /*
         * 面向对象的小细节
         *
         * 1. 描述一类事物的类叫JavaBean类
         * 2. 带有main方法的类叫测试类
         * 3. JavaBean类可以写属性和行为(方法不加 static 关键字)
         *
         */

        // 创建学生对象
        Student stu = new Student();

        // 赋值
        stu.name = "小刘";
        stu.gender = '男';
        stu.age = 18;
        stu.height = 1.73;

        // 获取学生信息
        System.out.println(stu.name);
        System.out.println(stu.gender);
        System.out.println(stu.age);
        System.out.println(stu.height);

        // 获取学生的行为
        stu.study();
        stu.sleep();
        stu.eat();

    }
}
