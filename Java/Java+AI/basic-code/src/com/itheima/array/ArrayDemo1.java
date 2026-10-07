package com.itheima.array;

public class ArrayDemo1 {
    static void main() {
        /*
         * 数组的静态初始化
         *
         * 语法格式：
         *    完整格式：数据类型[] 数组名 = new 数据类型[]{数据值, 数据值...}
         *    简写格式：数据类型[] 数组名 = {数据值, 数据值...}
         *
         * 数组的特点：
         *    特点1：连续的空间
         *    特点2：一旦定义，长度不可变
         *
         */

        // 1.定义数组存储3位同学的年龄
        int[] ageArr1 = new int[]{18, 19, 20};
        int[] ageArr2 = {18, 19, 20};

        // 2.定义数组存储5位同学的身高
        double[] heightArr1 = new double[]{1.93, 1.92, 1.21, 1.70, 1.75};
        double[] heightArr2 = {1.93, 1.92, 1.21, 1.70, 1.75};

        // 3.定义数组存储3位同学的名字
        String[] nameArr1 = new String[]{"zhangsan", "lisi", "wangwu"};
        String[] nameArr2 = {"zhangsan", "lisi", "wangwu"};

    }
}
