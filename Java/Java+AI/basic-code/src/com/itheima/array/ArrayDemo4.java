package com.itheima.array;

import java.util.Scanner;

public class ArrayDemo4 {
    static void main() {
        /*
         * 数组的动态初始化：
         *
         * 动态初始化的格式：
         *     数据类型[] 数组名 = new 数据类型[数组的长度];
         *
         * 一个循环，一个判断，只做一件事情
         *
         */

        // 需求：键盘录入5个整数，存入数组当中，并进行遍历

        // 1. 创建数组（动态初始化）
        int[] arr = new int[5];

        // 2. 键盘录入
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入一个整数：");
            int num = scanner.nextInt();
            // 把接收到的数据赋值给数组
            arr[i] = num;
        }

        // 3. 遍历数组
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
