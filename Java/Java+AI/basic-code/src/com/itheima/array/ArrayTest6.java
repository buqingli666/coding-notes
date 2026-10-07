package com.itheima.array;

public class ArrayTest6 {
    static void main() {
        /*
         * 快慢指针
         *
         * 慢指针：存入的位置
         * 快指针：找不重复的数据
         *
         * 相等 --> 舍弃快指针位置的数据
         * 不等 --> 快指针的数据存入慢指针位置
         *
         */

        // 给定一个递增有序数组，去除其中重复元素
        int[] arr = {1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3};

        // 1. 定义两个指针
        int slow = 0;
        int fast = 1;

        // 2. 利用循环不断的移动快慢指针，找不重复的元素
        while (fast < arr.length) {
            // 判断两个指针指向数据是否相同
            if (arr[slow] != arr[fast]) {
                slow++;
                arr[slow] = arr[fast];
            }
            fast++;
        }

        // 3. 输出结果
        for (int i = 0; i <= slow; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
