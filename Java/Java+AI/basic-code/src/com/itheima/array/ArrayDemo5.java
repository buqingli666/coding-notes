package com.itheima.array;

public class ArrayDemo5 {
    static void main() {
        /*
         * 数组的常见问题：
         * 索引越界
         *
         * 针对与任意一个数组而言，索引的范围：0 ～ 长度 - 1
         *
         */

        // 1.定义数组
        int[] arr = {10, 20, 30, 40, 50};

        int index = 10;

        if (index >= 0 && index < arr.length) {
            System.out.println(arr[index]);
        } else {
            System.out.println("索引 " + index + " 超出数组范围，数组长度为 " + arr.length);
        }
    }
}
