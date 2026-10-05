package com.itheima.ifdemo;

public class IfDemo3 {
    static void main() {
        /*
         * if 语句的细节：
         *    1. if 语句大括号的位置
         *        左括号写在上一行的末尾，不要单独写一行
         *
         *    2. if 语句大括号的省略
         *        如果大括号中语句体只有一行，大括号可以省略
         *
         *    3. 小括号后面不能有分号
         *        小括号后面不能有分号，这样会拆开if的语句结构
         *
         *    4. 判断布尔类型的变量
         *        判断布尔类型的变量，直接把变量写在小括号中即可
         *
         */

        double temperature = 36;

        // 分号：判断 --- 语句体之间的联系切断
        if (temperature >= 38) ;

        // 独立的代码快，不受上面的if控制
        {
            System.out.println("语音警告，当前体温已经超过了38度！");
        }


        boolean b = false;

        // 直接把变量写在小括号中即可
        if (b) {
            System.out.println("b为真");
        }

    }
}
