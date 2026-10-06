package com.itheima.loopwhile;

public class WhileDemo1 {
    static void main() {
        /*
         * while 循环
         * 语法格式：
         *     初始化语句;
         *     while (条件判断语句) {
         *         循环体语句;
         *         条件控制语句;
         *     }
         *
         */

        // 利用while循环，实现游戏中连续跳跃10次，用输出语句模拟跳跃的逻辑
        int i = 1;
        while (i <= 10) {
            System.out.println("游戏人物跳跃了" + i + "次");
            i++;
        }

    }
}
