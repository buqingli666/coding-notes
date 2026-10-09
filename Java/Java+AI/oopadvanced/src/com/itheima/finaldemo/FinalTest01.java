package com.itheima.finaldemo;

public class FinalTest01 {
    static void main() {
        /*
         * final 修饰变量，此时叫做常量
         *     特点1：只能被赋值一次，一旦赋值，无法再次修改。
         *     特点2：常量名大写，多个单词之间用下划线隔开
         *
         * 细节：
         *     基本数据类型：
         *         byte short int long float double char boolean
         *         变量里面记录的是真实的数据
         *         final int a = 10; 此时变量里面记录的数据无法发生改变
         *
         *     引用数据类型：
         *         除了上面四类八种，其他所有的数据类型都是引用类型
         *         int[] Student Teacher...
         *         stu里面的记录对象的内存地址，不可改变的是stu记录的内存地址
         *         而对象里面的属性值，是可以发生改变
         *         final Student stu = new Student();
         *
         * 综上所述：
         *     final修饰哪个变量，这个变量里面记录的内容就无法再次发生改变
         *
         */

        // 1. 定义一个常量
        final int NUMBER = 100;

        // 2. 使用常量
        System.out.println(NUMBER + 100);

        // 3. 定义一个引用数据类型的变量
        // final Student STU = new Student("zhangsan", 23);
        // STU = new Student();

        // STU.setName("lisi");
        // STU.setAge(24);

        // System.out.println(STU.getName());
        // System.out.println(STU.getAge());

        // 定义一个引用数据类型的变量
        final Student STU = new Student();
        // STU.name = "aaa";
        System.out.println(STU.getName());

    }
}
