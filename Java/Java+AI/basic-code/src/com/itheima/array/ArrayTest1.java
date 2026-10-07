package com.itheima.array;

import java.util.Scanner;

public class ArrayTest1 {
    static void main() {
        /*
         * 需求：已知数组元素为 {33,5,22,44,55,33}
         * 键盘录入任意一个数据，查找这个数据在数组中是否存在
         * 如果数组中要查找的数据出现多次，只要显示第一次的索引即可
         *
         * 输出要求：
         * 如果存在打印索引
         * 如果不存在，提示：“该数据不存在”
         *
         */

        // 1. 定义数组
        int[] arr = {33, 5, 22, 44, 55, 33};

        // 2. 键盘录入任意一个数据
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int number = scanner.nextInt();

        // 作用：记录数组当中是否存在number false：不存在 true：存在
        // boolean flag = false;

        // 作用：统计number在数组中出现多少次
        int count = 0;

        // 3. 拿着number跟数组里面每一个元素一一比较
        for (int i = 0; i < arr.length; i++) {
            // i：索引  arr[i]：元素/数据
            if (number == arr[i]) {
                System.out.println(i);
                count++;
                // flag = true;
                // 如果找到了，循环直接结束，后面的数据不用在比较了
                break;
            }
        }

        // 4. 判断
//        if (!flag) {
//            System.out.println("该数据不存在");
//        }

        if (count == 0) {
            System.out.println("该数据不存在");
        }

    }
}
