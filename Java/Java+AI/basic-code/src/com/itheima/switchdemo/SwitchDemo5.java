package com.itheima.switchdemo;

public class SwitchDemo5 {
    static void main() {
        /*
         * 3. switch 新特性：JDK12预览版  JDK14正式版
         *    一、箭头标签
         *    二、case 后面可以写多个值
         *    三、switch 可以有运行结果
         *    四、yield 关键字 --- 多行代码需要用 yield 返回结果，单行代码 yield 可以省略
         *
         */

        int number = 8;
        String name = switch (number) {
            case 1, 2, 3, 4, 5 -> "一";
            case 6, 7, 8 -> "二";
            case 9, 10 -> "三";
            default -> "没有这个星期";
        };

        System.out.println(name);


        // 练习：利用switch模拟计算器 + - * /
        int a = 10;
        int b = 20;
        String operator = "*";
        int res = switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> 0;
        };

        System.out.println(res);
    }
}
