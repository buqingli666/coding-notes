package com.itheima.operator;

public class OperatorDemo7 {
    static void main() {
        /*
         * 赋值运算符
         *
         * =       直接赋值
         * +=      加后赋值
         * -=      减后赋值
         * *=      乘后赋值
         * /=      除后赋值
         *
         */

        int a = 10;
        int b = 20;

        a += b; // 底层会有隐式的强制类型转换 a = (a的数据类型)(a + b);

        System.out.println(a);
        System.out.println(b);

    }
}
