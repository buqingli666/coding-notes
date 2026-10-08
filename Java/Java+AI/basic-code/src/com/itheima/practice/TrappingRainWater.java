package com.itheima.practice;

public class TrappingRainWater {
    static void main() {
        /*
         * 接雨水 - 动态规划思想DP
         *
         * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水
         *
         * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
         * 输出：6
         * 解释：下面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）
         *
         * 柱子的高度 = 数组的数据
         *
         */

        // 1. 定义数组
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        // 2. 从左往右遍历,记录雨水 + 柱子的面积总和
        // 2.1 定义数组记录从左往右看的数据
        int[] leftMax = new int[arr.length];

        // 2.2 定义第三方变量temp, 记录当前最高的柱子
        int temp = arr[0];

        // 2.3 遍历数组
        for (int i = 0; i < arr.length; i++) {
            if (temp > arr[i]) {
                // 判断 temp 数组里面的数据
                leftMax[i] = temp;
            } else {
                leftMax[i] = arr[i];
                temp = arr[i];
            }
        }

        // 3. 从右往左遍历,记录雨水 + 柱子的面积总和
        int[] rightMax = new int[arr.length];

        temp = arr[arr.length - 1];

        for (int i = arr.length - 1; i >= 0; i--) {
            if (temp > arr[i]) {
                rightMax[i] = temp;
            } else {
                rightMax[i] = arr[i];
                temp = arr[i];
            }
        }

        // 4. 取交集
        int[] res = new int[arr.length];

        for (int i = 0; i < rightMax.length; i++) {
            // leftMax[i]：从左到右数组中的数据
            // rightMax[i]：从右到左数组中的数据
            if (leftMax[i] < rightMax[i]) {
                res[i] = leftMax[i];
            } else {
                res[i] = rightMax[i];
            }
        }

        // 5. 求和
        int sum = 0;
        for (int i = 0; i < res.length; i++) {
            sum = sum + res[i];
        }

        // 6. 去掉柱子的面积 --> arr
        for (int i = 0; i < arr.length; i++) {
            sum = sum - arr[i];
        }

        System.out.println(sum);

    }
}
