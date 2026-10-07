package com.itheima.method;

public class MethodDemo4 {
    static void main() {
        /*
         * void：没有返回值，可以省略 return 不写
         * 如果不省略，return 后面不能写具体数据，仅表示结束方法
         *
         */

        // 调用方法
        printMulTable();

    }

    // 定义方法打印99乘法表
    // 没有参数的方法，调用的时候，实参也是空着的
    public static void printMulTable() {
        // 外循环控制行
        for (int i = 1; i <= 9; i++) {
            // 内循环控制列 --- 一行多少
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + j * i + "\t");
            }
            System.out.println();
        }
    }
}
