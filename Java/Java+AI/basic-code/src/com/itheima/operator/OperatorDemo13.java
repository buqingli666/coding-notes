package com.itheima.operator;

public class OperatorDemo13 {
    static void main() {
        /*
         * 短路逻辑运算符 - 短路与(&&) 短路或(||)
         * 运行规则：和单个的 & | 是一样的，只不过提高了效率
         *
         * 需求2：寻找7的有缘数，定义一个两位整数，只要该数字包含7或者是7的倍数，就是7的有缘数
         *
         */

        // 1. 定义一个两位数
        int num = 22;

        // 包含7：个位或十位是7即可
        // 7的倍数：num % 7 == 0

        // 2. 数字拆分
        int ge = num % 10;
        int shi = num / 10 % 10;

        // 3. 判断当前数字是否是7的有缘数
        // ge == 7 || shi == 7 || num % 7 == 0
        boolean res = ge == 7 || shi == 7 || num % 7 == 0;

        System.out.println(res);

    }
}
