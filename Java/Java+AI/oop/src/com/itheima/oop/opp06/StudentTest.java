package com.itheima.oop.opp06;

public class StudentTest {
    static void main() {
        /*
         * 一、 创建对象的七步 (以 Student stu = new Student(); 为例)
         * ① 加载 class 字节码文件
         * ② 声明等号左边的局部变量
         * ③ 在堆里面开辟一个空间（对象）
         * ④ 给对象中的属性进行默认初始化
         * ⑤ 给对象中的属性进行显示初始化
         * ⑥ 给对象中的属性利用构造方法进行初始化
         * ⑦ 把对象的内存地址赋值给等号左边的变量
         *
         * 二、 内存生命周期
         * 1. 方法出栈之后，方法里面的变量全部消失。
         * 2. 如果没有任何地方使用堆里面的对象，那么对象也会从堆里面消失（被垃圾回收器 GC 回收）。
         * 3. 方法区里面字节码信息一般不会消失，除非关闭虚拟机。
         *
         * 三、 对象传递与引用
         * 1. 把一个对象传递给方法，实际传递的是对象的内存地址。
         * 2. 当多个变量指向同一个对象的时候，只要有一个变量修改了对象中的属性，其他变量再次访问就是修改之后的结果了。
         *
         * 四、 this 的本质
         * this 代表所在方法调用者的内存地址。
         *
         */

        // 验证：多个变量指向同一个对象
        Student s1 = new Student("小明", 18);
        Student s2 = s1; // 地址赋值

        System.out.println("s1的地址：" + s1);
        System.out.println("s2的地址：" + s2); // 打印出来的地址一模一样

        s2.setName("小红");
        System.out.println("s1的名字：" + s1.getName()); // 输出：小红（s1也跟着变了）

        // 验证：this 的地址就是调用者的地址
        s1.printThisAddress();

        // 验证：把对象传递给方法
        Student.changeStudent(s1);
        System.out.println("方法传递修改后 s1的名字：" + s1.getName()); // 输出：被修改了
    }
}
