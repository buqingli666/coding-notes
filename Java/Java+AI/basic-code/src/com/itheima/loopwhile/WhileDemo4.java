package com.itheima.loopwhile;

public class WhileDemo4 {
    static void main() {
        /*
         * while 循环练习
         *
         * 需求：世界最高山峰珠穆朗玛峰高度是：8848.86米=8848860毫米，
         *      假如我有一张足够大的纸，它的厚度是0.1毫米。
         *      请问：该纸张折叠多少次，可以折成珠穆朗玛峰的高度？
         *
         * 分析：
         *      1. 纸张折叠：paper * 2
         *      2. while 条件判断语句 paper < 8848860
         *
         */

        // 1. 定义变量表示纸张的厚度
        double paper = 0.1;

        // 2. 定义变量表示山的高度
        double height = 8848860;

        // 3. 定义变量记录折叠的次数
        int count = 0;

        // 利用循环折叠纸张
        while (paper < height) {
            paper = paper * 2;
            count++;
        }

        System.out.println(count);

    }
}
