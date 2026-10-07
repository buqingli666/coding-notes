package com.itheima.array;

public class ArrayTest9 {
    static void main() {
        /*
         * 作业3：查找元素（力扣算法）
         *
         * 给定一个递增的有序数组和一个目标值，在数组中找到目标值，打印其索引。
         * 如果目标值不存在于数组中，打印应插入的位置
         *
         * 举例1：
         * 数据：nums = [1,3,5,6];      target = 5
         * 输出：2
         *
         * 举例2：
         * 数据：nums = [1,3,5,6],      target = 2
         * 输出：1
         *
         * 举例3：
         * 数据：nums = [1,3,5,6],      target = 7
         * 输出：4
         *
         */

        int[] nums = {1, 3, 5, 6};

        int target = 2;

        // 1. 定义左右边界指针
        int left = 0;
        int right = nums.length - 1;

        // 2. 开始二分查找
        while (left <= right) { // 只要搜索区间还有元素，就继续找

            // 计算中间位置
            // 更严谨的写法是 mid = left + (right - left) / 2，防止极端情况下 left + right 导致 int 数据溢出。
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                // 情况A：正好找到
                System.out.println(mid);
                return;
            } else if (nums[mid] < target) {
                // 情况B：中间的数比目标小，目标在右半区
                // 抛弃左半区（包括mid自己），left移动到mid右边
                left = mid + 1;

            } else {
                // 情况C：中间的数比目标大，目标在左半区
                // 抛弃右半区（包括mid自己），right移动到mid左边
                right = mid - 1;
            }

        }

        // 3. 循环结束，没找到目标。此时 left 就是恰好应该插入的位置
        System.out.println(left);
    }
}
