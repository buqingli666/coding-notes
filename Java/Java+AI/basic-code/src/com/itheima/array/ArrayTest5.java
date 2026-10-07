package com.itheima.array;

import java.util.Random;

public class ArrayTest5 {
    static void main() {
        /*
         * 需求：获取10个1-100之间的随机数并存入到数组当中,要求保证数据是唯一的
         * 核心思路：
         *     如果存在，就不存，继续生成下一个随机数
         *     如果不存在，就存入到数组当中
         *
         */

        // 1.创建数组
        int[] arr = new int[10];

        // 2.生成随机数
        Random r = new Random();
        for (int i = 0; i < arr.length; ) {
            int num = r.nextInt(100) + 1;

            // 对 num 进行判断，存在-->不存 不存在-->存入
            int count = 0;
            // 核心优化：j < i，只比较已经存入的有效数据
            for (int j = 0; j < i; j++) {
                if (arr[j] == num) {
                    count++;
                    break;
                }
            }

            // 对 count 进行判断
            if (count == 0) {
                // 不存在-->存入
                arr[i] = num;
                i++; // 只有生成一个满足要求的随机数,索引才会自增
            }

        }

        // 3.遍历
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
