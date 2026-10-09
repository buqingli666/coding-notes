package com.itheima.oop.oop04;

public class TeacherTest {
    static void main() {
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

        // 创建对象
        Teacher teacher = new Teacher();
        System.out.println(teacher.getName());
        System.out.println(teacher.getAge());
        System.out.println(teacher.getGender());
        System.out.println(teacher.getHeight());

        System.out.println("----------------------");

        Teacher teacher1 = new Teacher("小孙", 33, '男', 1.68);
        System.out.println(teacher1.getName());
        System.out.println(teacher1.getAge());
        System.out.println(teacher1.getGender());
        System.out.println(teacher1.getHeight());

    }
}
