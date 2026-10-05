package com.itheima.switchdemo;

public class SwitchDemo3 {
    static void main() {
        /*
         * 1. default 的位置和省略
         *    位置：case 和 default 是没有标准的上下之分，位置可以任意的书写
         *         为了观看比较方便，提高代码的阅读性。一般来讲，case 从小到大依次书写的，default 是写在最下面的
         *    省略：default 是可以省略不写的，在此时如果所有的 case 都不匹配，则没有任何的输出结果
         *
         */

        int week = 10;
        switch (week) {

            case 2:
                System.out.println("星期二");
                break;
            case 4:
                System.out.println("星期四");
                break;
            case 3:
                System.out.println("星期三");
                break;
            default:
                System.out.println("没有这个星期");
                break;
            case 6:
                System.out.println("星期六");
                break;
            case 5:
                System.out.println("星期五");
                break;
            case 7:
                System.out.println("星期日");
                break;
            case 1:
                System.out.println("星期一");
                break;

        }
    }
}
