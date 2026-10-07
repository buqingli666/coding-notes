package com.itheima.array;

public class ArrayTest7 {
    static void main() {
        /*
         * 作业1：两数之和（力扣算法）
         *
         * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为 目标值 target 的那 两个 整数，并输出它们的数组索引。
         *
         * 提示：先不用考虑效率问题，两层循环即可完成
         *
         * 要求1：只要输出第一对满足要求的情况
         * 要求2：输出所有满足要求的情况
         *
         * 举例1：
         * 输入：数组nums = [2, 7, 11, 15]  target = 9
         * 输出：0,1
         * 解释：因为 nums[0] + nums[1] == 9 ，所以结果为0和1
         *
         * 举例2：
         * 输入：数组nums = [3, 2, 4]       target = 6
         * 输出：1,2
         *
         */

        int[] arr = {2, 7, 11, 15, 6, 8, 5};

        int target = 13;

        // 要求1：只要输出第一对满足要求的情况
        // 外层循环：拿起当前这个数
        for (int i = 0; i < arr.length; i++) {
            // 内层循环：看它后面的每一个数
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println(i + "," + j);
                    return; // 找到第一对后，直接结束整个 main 方法！
                }
            }
        }
        System.out.println("没有找到满足条件的两个数");


        // 要求2：输出所有满足要求的情况
        // 标记是否有找到数据
//        boolean isFind = false;
//
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[i] + arr[j] == target) {
//                    System.out.println(i + "," + j);
//                    isFind = true;
//                }
//            }
//        }
//
//        if (!isFind) {
//            System.out.println("没有找到满足条件的两个数");
//        }

    }
}
