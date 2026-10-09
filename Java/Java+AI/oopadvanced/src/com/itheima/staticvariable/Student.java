package com.itheima.staticvariable;

public class Student {
    /*
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

    // 姓名
    String name;
    // 年龄
    int age;
    // 老师名字
    static String teacherName;

}
