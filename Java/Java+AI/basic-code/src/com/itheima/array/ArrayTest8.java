package com.itheima.array;

public class ArrayTest8 {
    static void main() {
        /*
         * 作业2：合并有序数组（力扣算法）
         *
         * 给你两个有序数组 arr1 和 arr2
         * 将两个数组中的数据合并到一个大数组中。
         *
         * 要求：合并之后的大数组也是有序的
         *
         * 举例1：
         * arr1: 1 3 5 7 9
         * arr2: 2 4 6 8 10
         * arr3: 1 2 3 4 5 6 7 8 9 10
         *
         */

        // 1. 准备原数组
        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {2, 4, 6, 8, 10};

        // 2. 准备新数组（长度是两者之和）
        int[] arr3 = new int[arr1.length + arr2.length];

        // 3. 定义三个指针
        int i = 0; // 指向 arr1 的开始
        int j = 0; // 指向 arr2 的开始
        int k = 0; // 指向 arr3 的开始

        // 4. 第一阶段：两个数组都还没空，进行“比大小”
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                // 如果 arr1 当前数字更小（或相等），把它放进 arr3
                arr3[k] = arr1[i];
                // arr1 的指针往后走
                i++;
            } else {
                // 否则 arr2 当前数字更小
                arr3[k] = arr2[j];
                // arr2 的指针往后走
                j++;
            }
            // 每次放完数据，arr3 的指针都要往后走
            k++;
        }

        // 5. 第二阶段：处理尾巴（最容易漏掉的地方！）
        // 如果 arr1 还有剩下没放完的
        while (i < arr1.length) {
            arr3[k] = arr1[i];
            i++;
            k++;
        }

        // 如果 arr2 还有剩下没放完的
        while (j < arr2.length) {
            arr3[k] = arr2[j];
            j++;
            k++;
        }

        // 6. 打印结果
        for (int n = 0; n < arr3.length; n++) {
            System.out.print(arr3[n] + " ");
        }
    }
}
