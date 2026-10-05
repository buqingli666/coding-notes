package com.itheima.ifdemo;

public class IfDemo4 {
    static void main() {
        /*
         * if 语句的第二种格式
         *    if (关系表达式){
         *        语句体A;
         *    } else {
         *        语句体B;
         *    }
         *
         * 需求：定义一个小数表示考试成绩
         * 判断学生的考试成绩，如果大于等于60分输出通过，否则不通过
         *
         */

        double score = 101;

        if (score >= 0 && score <= 100) {
            if (score >= 60) {
                System.out.println("通过");
            } else {
                System.out.println("不通过");
            }
        } else {
            System.out.println("不合理");
        }

    }
}
