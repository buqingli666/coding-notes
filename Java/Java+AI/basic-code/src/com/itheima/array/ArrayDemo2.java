package com.itheima.array;

public class ArrayDemo2 {
    static void main() {
        /*
         * 数组的元素访问 --- 获取 修改
         *
         * 一、获取数组元素
         *    语法格式：变量 = 数组名[索引]
         *    代码示例：int num = arr[5]
         *
         * 二、修改数组元素
         *    语法格式：数组名[索引] = 数据值;
         *    代码示例：arr[5] = 10;
         *
         */

        // 1. 利用静态初始化创建数组
        int[] arr = {10, 20, 30, 40, 50};

        // 2. 获取数组中的元素
        // 索引：从0开始，连续+1，中间不间断
        int num = arr[0];
        System.out.println(num);

        // 修改数组元素
        // 注意：一旦修改完毕，原来的数据就被覆盖了
        arr[4] = 88;
        System.out.println(arr[4]);

    }
}
