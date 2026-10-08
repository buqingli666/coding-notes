package com.itheima.practice;

public class MergeAndFindMedian {
    static void main() {
        /*
         * 给定两个正序数组 arr1 和 arr2，请先合并数组，并找出合并之后数组的中位数。
         *
         * 【举例】：
         *  数组1: 1 2 3 4 5 6 7 8 9  ->  中位数: 5
         *  数组2: 1 2 3 4 5 6        ->  中位数: (3 + 4) / 2
         *
         * 【核心思想】：二路归并思想
         *
         */
        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {2, 4};

        double number = findMedianSortedArrays(arr1, arr2);
        System.out.println(number);
    }

    public static double findMedianSortedArrays(int[] arr1, int[] arr2) {
        // 1. 定义一个大数组
        int[] arr3 = new int[arr1.length + arr2.length];

        // 把两个小数组中的数据，放到大数组当中，而且要保证正序
        // 粗暴的办法：不管顺序，直接把arr1和arr2里面的数据添加到arr3中。添加完毕，再排序。思路最简单，但是效率太低

        // 快捷的思路：在添加的过程中，保证顺序。前提：arr1，arr2必须是正序的

        // 2. 定义两个指针，分别指向 arr1 和 arr2 的起始位置
        int index1 = 0;
        int index2 = 0;

        // 3. 遍历新数组，依次填入最小的数
        for (int i = 0; i < arr3.length; i++) {

            // 情况 A: arr1 已经遍历完了，只剩下 arr2 的元素
            if (index1 == arr1.length) {
                arr3[i] = arr2[index2];
                index2++;
                continue;
            }

            // 情况 B: arr2 已经遍历完了，只剩下 arr1 的元素
            if (index2 == arr2.length) {
                arr3[i] = arr1[index1];
                index1++;
                continue;
            }

            // 情况 C: 两个数组都还有元素，比较当前指针指向的值，谁小取谁
            if (arr1[index1] < arr2[index2]) {
                arr3[i] = arr1[index1];
                index1++;
            } else {
                arr3[i] = arr2[index2];
                index2++;
            }
        }

        // 4. 计算并返回中位数
        if (arr3.length % 2 == 0) {
            // 偶数
            int num1 = arr3[arr3.length / 2];
            int num2 = arr3[arr3.length / 2 - 1];
            return (num1 + num2) / 2.0;
        } else {
            // 奇数
            int num3 = arr3[arr3.length / 2];
            return num3 / 1.0;
        }

    }
}
