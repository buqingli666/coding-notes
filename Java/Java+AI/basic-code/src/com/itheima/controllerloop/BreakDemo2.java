package com.itheima.controllerloop;

import java.util.Scanner;

public class BreakDemo2 {
    static void main() {
        /*
         * break 练习
         *
         * 需求：初始最大生命200，受到X点伤害，技能恢复Y点血，X和Y由键盘录入而来
         * 假设，游戏人物不会死亡，最少1点血
         * 问：最终游戏人物血量是多少？
         *
         * 要考虑的情况：键盘录入必须大于0，否则需要重新输入
         *
         */

        // 1. 定义变量记录游戏人物的生命值
        int hp = 200;

        // 2. 键盘录入一个值，表示当前人物受到的伤害
        Scanner scanner = new Scanner(System.in);

        // 循环 + break
        // 一直录入数据，直到数据符合要求为止
        int hurt = 0;
        while (true) {
            System.out.println("请输入当前人物受到的伤害：");
            hurt = scanner.nextInt();

            // 判断是否符合当前的需求
            if (hurt > 0) {
                break;
            } else {
                System.out.println("当前受到的伤害不能为负数");
            }
        }

        // 3. 计算当前的血量
        hp = hp - hurt;

        // 游戏人物不会死亡，最少1点血
        if (hp <= 0) {
            hp = 1;
        }

        System.out.println("当前游戏人物的血量是：" + hp);

        // 4. 键盘录入一个值，表示技能回复的血量
        int add = 0;
        while (true) {
            System.out.println("请输入技能回复的血量：");
            add = scanner.nextInt();

            if (add > 0) {
                break;
            } else {
                System.out.println("技能回复的血量不能为负数");
            }
        }

        // 5. 计算当前游戏人物的血量
        hp = hp + add;

        if (hp > 200) {
            hp = 200;
        }

        System.out.println("当前游戏人物的血量是：" + hp);
    }
}
