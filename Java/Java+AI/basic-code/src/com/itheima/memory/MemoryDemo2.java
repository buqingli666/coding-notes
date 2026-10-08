package com.itheima.memory;

public class MemoryDemo2 {
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

        // 定义数组
        int[] arr = {1, 2, 3, 4, 5};

        // 交换前遍历数组
        System.out.println("交换前:");
        printArray(arr);

        // 交换数组首位元素
        change(arr);

        // 交换后遍历数组
        System.out.println("交换后:");
        printArray(arr);
    }

    public static void change(int[] arr) {
        int temp = arr[0];
        arr[0] = arr[4];
        arr[4] = temp;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
