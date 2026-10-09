package com.itheima.staticvariable;

public class Test {
    static void main() {
        /*
         * 需求：利用static模拟以下效果
         * 学生有如下属性：姓名，年龄，老师
         * 一个班级中，所有学生都是共享同一个老师
         *
         * 第一名学生：小诗诗，19岁
         * 第二名学生：小丹丹，20岁
         * 最初都是小雯老师上课，有一天小丹丹申请换老师，换成了阿玮老师
         *
         * -----------------------------------------
         *
         * 关于static需要重点掌握的内容：
         *
         * 1. 静态变量，被当前类所有的对象共享
         *    共享：
         *        赋值只要赋值一次
         *        只要有一个对象修改了静态变量，其他对象再次访问的时候就是修改之后的结果了
         *
         * 2. 调用方式：
         *    方式一：类名调用（推荐）
         *    方式二：对象名调用
         *
         * 3. 随着类的加载而加载，优先于对象而存在。不属于对象，属于类。
         *
         */

        // Student这个类所有对象的teacherName都是小雯老师
        Student.teacherName = "小雯老师";

        // 创建第一个学生对象
        Student stu1 = new Student();
        stu1.name = "小诗诗";
        stu1.age = 19;

        // 创建第二个学生对象
        Student stu2 = new Student();
        stu2.name = "小丹丹";
        stu2.age = 20;
        stu2.teacherName = "阿玮老师";

        System.out.println(stu1.name + "，" + stu1.age + "，" + stu1.teacherName);
        System.out.println(stu2.name + "，" + stu2.age + "，" + stu2.teacherName);

    }
}
