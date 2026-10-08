package com.itheima.memory;

public class MemoryDemo1 {
    static void main() {
        /*
         * Java虚拟机把内存分成：栈、堆、方法区、本地方法栈、程序计数器
         *
         * Java中的内存分配（三大核心区域）
         *
         * 一、方法区 (Method Area)
         *   1. 存放：字节码信息（如 Test.class、main方法代码指令）
         *   2. 特点：好比“剧本与图纸”，是所有线程共享的区域。
         *
         * 二、栈内存 (Stack)
         *   1. 存放：方法、局部变量（基本类型的值、引用类型的内存地址）
         *   2. 特点：方法执行时进栈，执行完毕出栈（先进后出）。
         *      程序从 main 方法开始进栈执行。
         *
         * 三、堆内存 (Heap)
         *   1. 存放：new 关键字开辟的空间（数组/对象的真实数据）
         *   2. 特点：分配唯一的内存地址（如 10f87f48），是垃圾回收(GC)的主要区域。
         *
         */

        int a = 10;
        int b = 20;

        System.out.println("交换前:" + a + ", " + b);
        change(a, b);
        System.out.println("交换后:" + a + ", " + b);

    }

    public static void change(int a, int b) {
        // 交换变量
        int temp = a;
        a = b;
        b = temp;
    }
}
