package com.itheima.switchdemo;

import java.util.Scanner;

public class SwitchDemo4 {
    static void main() {
        /*
         * 2. case 穿透
         *     在我们写代码的时候，如果 break 没有写，此时就会触发 case 穿透现象
         * 执行流程：
         *     1. 拿着小括号中表达式的值跟下面的 case 进行匹配
         *     2. 如果匹配上了，就会执行 case 里面的语句体，遇到 break 结束整个的 switch（正常情况）
         *     3. 如果在执行语句体的时候没有看到 break，那么程序会继续执行下一个 case 的语句体，直到遇到 break 或者运行完整个的 switch 为止
         * 应用场景：
         *     当多个 case 的语句体重复的时候，利用 case 穿透节省代码
         *
         */

        /*
         * 根据用户输入的月份，输出季节
         * 春季：3 ~ 5月
         * 夏季：6 ~ 8月
         * 秋季：9 ~ 11月
         * 冬季：12月、1月、2月
         *
         */

        // 1. 键盘录入月份
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入月份：");
        int month = sc.nextInt();

        // 2. 利用switch对month进行匹配
        switch (month) {
            case 1:
            case 2:
            case 12:
                System.out.println("冬季");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("春季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏季");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("秋季");
                break;
            default:
                System.out.println("没有这个季节");
                break;
        }

    }
}
