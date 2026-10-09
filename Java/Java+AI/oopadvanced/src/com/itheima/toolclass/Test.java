package com.itheima.toolclass;

public class Test {
    static void main() {
        /*
         * 静态方法：
         * 多用在测试类和工具类中，Javabean类中很少会用
         *
         * 调用方式：
         * 方式一：类名调用（推荐）
         * 方式二：对象名调用
         *
         * 在实际开发中，经常会遇到一些数组使用的工具类。
         * 请按照如下要求编写一个数组的工具类完成以下需求：
         * 1. 提供一个方法printArr，用于遍历数组。
         *    格式如下：[10, 20, 50, 34, 100]（只考虑整数数组）
         * 2. 提供一个方法getAverage，用于返回平均分。（只考虑整数数组）
         *
         */

        // 创建一个数组
        int[] arr = {10, 20, 30, 40, 50};
        // 遍历
        String res = ArrayUtil.printArr(arr);
        System.out.println(res);

        // 创建一个数组
        int[] arr1 = {1, 2, 3, 4, 7};
        // 求平均值
        double avg = ArrayUtil.getAverage(arr1);
        System.out.println(avg);
    }
}
