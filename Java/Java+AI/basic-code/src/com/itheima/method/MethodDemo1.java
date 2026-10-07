package com.itheima.method;

public class MethodDemo1 {
    static void main() {
        /*
         * 方法
         *
         * 定义格式：
         *      public static 返回值类型 方法名 (参数1, 参数2...) {
         *          方法体;
         *          return 返回值;
         *      }
         *
         * 调用格式：
         *      方法名(参数1, 参数2...);
         *
         * 注意点：
         *      1.方法跟方法之间是平级关系，不能互相嵌套
         *      2.方法是不会主动运行的，需要被调用才可以
         *      3.小括号中的参数需要一一对应（个数、类型）
         *      4.return: (1)结束方法 (2)将结果返回给调用者
         *
         */

        // 调用方法
        int res = getSum(5, 10);
        System.out.println(res);

    }

    // 定义一个方法，求两个数的和
    public static int getSum(int a, int b) {
        return a + b;
    }

}
