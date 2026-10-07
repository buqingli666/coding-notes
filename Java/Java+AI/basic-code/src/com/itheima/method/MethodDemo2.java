package com.itheima.method;

import java.util.Random;

public class MethodDemo2 {
    static void main() {
        // 获取10个1-100之间的随机数并存入到数组当中,要求保证数据是唯一的

        // 1.创建数组
        int[] arr = new int[10];

        // 2.生成随机数
        Random r = new Random();
        for (int i = 0; i < arr.length; ) {
            int num = r.nextInt(100) + 1;

            // 对 num 进行判断，存在-->不存 不存在-->存入
            if (!contains(num, arr)) {
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

    // 定义一个方法，判断num在数组arr中是否存在
    public static boolean contains(int num, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                // 如果遇到一个符合条件的，直接返回true
                // 此时方法直接结束
                return true;
            }
        }
        // 如果循环结束了，数组里面所有的元素都判断完毕了，还没有找到一样的，直接返回false，表示num在arr当中是不存在的。
        return false;
    }
}
