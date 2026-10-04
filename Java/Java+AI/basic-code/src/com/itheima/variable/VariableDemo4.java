package com.itheima.variable;

public class VariableDemo4 {
    static void main() {
        /*
         * 1. Java语言数据类型的分类：
         *    - 基本数据类型
         *    - 引用数据类型
         *
         * 2. 基本数据类型的四类八种：
         *    - 整数：byte / short / int / long
         *    - 浮点数：float / double
         *    - 字符：char
         *    - 布尔：boolean
         *
         * 3. 整数、小数取值范围大小关系：
         *    double > float > long > int > short > byte
         *
         * 4. long、float类型的变量加后缀：
         *    - long 需要加 L 后缀 (推荐大写 L，避免和数字 1 混淆)
         *    - float 需要加 F 后缀
         *
         */

        // 1. 定义byte类型的变量
        byte b = 127;
        System.out.println(b);

        // 2. 定义short类型的变量
        short s = 32767;
        System.out.println(s);

        // 3. 定义int类型的变量
        int i = 2147483647;
        System.out.println(i);

        // 4. 定义long类型的变量
        // 细节：long类型数据必须以L结尾，可以是大写的，也可以是小写
        // 建议：一般写成大写的
        long l = 1000000000000000000L;
        System.out.println(l);

        // 5. 浮点数类型：float、double
        // 细节：浮点数类型的变量，必须以f或者F结尾
        // 建议：一般写成大写的
        float f = 1.1F;
        System.out.println(f);

        double d = 1.1;
        System.out.println(d);

        // 6. 字符类型：char
        char c = '中';
        System.out.println(c);

        // 7. 布尔类型：boolean
        boolean bb = false;
        System.out.println(bb);
    }
}
