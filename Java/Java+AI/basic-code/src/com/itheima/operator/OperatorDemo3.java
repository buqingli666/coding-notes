package com.itheima.operator;

public class OperatorDemo3 {
    static void main() {
        /*
         * 运算符练习 - 时间转换
         *
         */

        // 1. 定义变量记录秒数
        int seconds = 3661;

        // 2. 获取小时数 3661 / 3600 = 1...61
        int hour = seconds / 3600;
        System.out.println(hour);

        // 3. 获取分钟数
        // 3661 % 3600 = 1...61
        // 61 / 60 = 1...1
        int min = seconds % 3600 / 60;
        System.out.println(min);

        // 4. 获取秒数
        int second = seconds % 3600 % 60;
        System.out.println(second);

        // 字符串拼接的形式打印数据
        System.out.println(hour + "小时" + min + "分钟" + second + "秒");

    }
}
