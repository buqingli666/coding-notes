package com.itheima.array;

public class ArrayTest2 {
    static void main() {
        /*
         * 需求：已知数组元素为 {33，5,22,44,55}
         * 请找出数组中最大值并打印在控制台
         *
         * 细节1：
         *     循环的开始条件，如果为0。请问：对结果有没有影响？
         *     对结果没有任何影响，只不过，循环多执行一次
         *
         * 细节2：
         *     max的初始化值，能不能赋值为0？
         *     max的初始化值，不能赋值为0
         *     max记录的值，一定要是数组里面的元素
         *
         */

        // 1. 创建数组
        int[] arr = {33, 5, 22, 44, 55};

        // 2. 定义一个变量（擂台），默认记录第一个值
        int max = arr[0];

        // 3. 让后面的人依次跟擂台的人比较一下
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        // 4.输出最大值
        System.out.println("最大值：" + max);

        System.out.println("----------------");

        // 定义变量记录最小值
        int min = arr[0];

        // 遍历数组
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }

        // 输出最小值
        System.out.println("最小值：" + min);

    }
}
