package com.itheima.method;

public class MethodDemo6 {
    static void main() {
        /*
         * 方法重载
         * 同一个类，方法名相同，参数不同的方法，无需看返回值。
         *
         * 1. 参数个数不同   方法一：int / 方法二：int int
         * 2. 参数类型不同   方法一：int / 方法二：double
         * 3. 参数顺序不同   方法一：int double / 方法二：double int
         *
         */

        int a = 10;
        int b = 20;

        // 调用方法会优先调用形参和实参一一对应的，如果没有才会进行隐式转换
        System.out.println(getSum(a, b));

    }

    public static double getSum(int a, int b) {
        return a + b;
    }

    public static double getSum(int a, double b) { // no usages
        return a + b;
    }

    public static double getSum(double a, int b) { // no usages
        return a + b;
    }

    public static double getSum(double a, double b) { // no usages
        return a + b;
    }
}
