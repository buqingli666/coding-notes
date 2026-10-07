package com.itheima.array;

public class ArrayDemo3 {
    static void main() {
        /*
         * 数组的遍历
         *
         * 定义一个整数数组，里面存储任意数据，并将数组遍历并打印
         *
         */

        // 1.利用静态初始化定义一个数组
        int[] arr = {12, 34, 56, 68, 78, 89, 90, 39};

        // 获取数组的长度
        System.out.println(arr.length);

        System.out.println("------------------");

        // 2.遍历获取数组中的内容
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
