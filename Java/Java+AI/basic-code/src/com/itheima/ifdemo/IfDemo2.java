package com.itheima.ifdemo;

import java.util.Scanner;

public class IfDemo2 {
    static void main() {
        /*
         * if 语句练习 - 游戏血条计算
         *
         * 需求：初始最大生命200，受到x点伤害，技能恢复y点血，x和y由键盘录入而来
         * 假设，游戏人物不会死亡，最少1点血
         * 问：最终游戏人物血量是多少？
         *
         */

        // 1. 定义变量记录游戏人物的生命值
        int hp = 200;

        // 2. 键盘录入一个值，表示当前人物受到的伤害
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入当前人物受到的伤害：");
        int hurt = scanner.nextInt();

        // 3. 计算当前的血量
        hp = hp - hurt;

        // 游戏人物不会死亡，最少1点血
        if (hp <= 0) {
            hp = 1;
        }

        System.out.println("当前游戏人物的血量是：" + hp);

        // 4. 键盘录入一个值，表示技能回复的血量
        System.out.println("请输入技能回复的血量：");
        int add = scanner.nextInt();

        // 5. 计算当前游戏人物的血量
        hp = hp + add;

        if (hp > 200) {
            hp = 200;
        }

        System.out.println("当前游戏人物的血量是：" + hp);

    }
}
