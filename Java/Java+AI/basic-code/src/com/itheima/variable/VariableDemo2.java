package com.itheima.variable;

public class VariableDemo2 {
    static void main() {
        /*
            我方：叉子               对方：长手
            攻击：220               攻击：210
            防御：85                防御：80
            血量：1012.5            血量：1223.3
            技能加成：1.2           技能加成：1.3

            技能造成伤害的公式：攻击力 * 技能加成 - 对方防御力
            普攻造成伤害的公式：攻击力 - 对方防御力

            计算：
                我方第一次进行普通攻击，造成多少伤害，对方还剩余多少血量？
                我方第二次进行技能攻击，造成多少伤害，对方还剩余多少血量？
        */

        // 我方属性
        int myAttack = 220;
        int myDefense = 85;
        double myBlood = 1012.5;
        double mySkillMultiplier = 1.2;

        // 敌方属性
        int enemyAttack = 210;
        int enemyDefense = 80;
        double enemyBlood = 1223.3;
        double enemySkillMultiplier = 1.3;

        // 我方第一次进行普通攻击，造成多少伤害，对方还剩余多少血量？
        enemyBlood = enemyBlood - (myAttack - enemyDefense);
        System.out.println(enemyBlood); // 1083.3

        // 我方第二次进行技能攻击，造成多少伤害，对方还剩余多少血量？
        enemyBlood = enemyBlood - (myAttack * mySkillMultiplier - enemyDefense);
        System.out.println(enemyBlood); // 899.3

    }
}
