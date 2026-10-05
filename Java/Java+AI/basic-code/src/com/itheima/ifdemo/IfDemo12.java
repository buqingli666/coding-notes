package com.itheima.ifdemo;

import java.util.Scanner;

public class IfDemo12 {
    static void main() {
        /*
         * 练习：直角坐标系位置判断
         *
         * 规则：
         * 输入变量 x, y，判断点所在区域：
         * 情况1：原点 (x=0 且 y=0)
         * 情况2：第1象限、第2象限、第3象限、第4象限
         * 情况3：在 y 轴上 (x=0 且 y!=0)
         * 情况4：在 x 轴上 (y=0 且 x!=0)
         *
         */

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入变量 x：");
        int x = scanner.nextInt();
        System.out.println("请输入变量 y：");
        int y = scanner.nextInt();

        if (x == 0 && y == 0) {
            System.out.println("原点");
        } else if (x > 0 && y > 0) {
            System.out.println("第一象限");
        } else if (x < 0 && y > 0) {
            System.out.println("第二象限");
        } else if (x < 0 && y < 0) {
            System.out.println("第三象限");
        } else if (x > 0 && y < 0) {
            System.out.println("第四象限");
        } else if (x == 0) {
            System.out.println("y轴上");
        } else {
            System.out.println("x轴上");
        }
    }

}
