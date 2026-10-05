package com.itheima.operator;

import java.util.Scanner;

public class OperatorDemo12 {
    static void main() {
        /*
         * 短路逻辑运算符 - 短路与(&&) 短路或(||)
         * 运行规则：和单个的 & | 是一样的，只不过提高了效率
         *
         * 需求1：键盘录入一个四位整数，判断这个数字是否为回文数
         *
         */

        // 1. 键盘录入
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个四位的整数：");
        int num = scanner.nextInt();

        // 2. 数字拆分
        int ge = num % 10;
        int shi = num / 10 % 10;
        int bai = num / 100 % 10;
        int qian = num / 1000 % 10;
        System.out.println(ge);
        System.out.println(shi);
        System.out.println(bai);
        System.out.println(qian);

        // 3. 判断是否为回文数
        boolean res = ge == qian && shi == bai;
        System.out.println(res);

    }
}
