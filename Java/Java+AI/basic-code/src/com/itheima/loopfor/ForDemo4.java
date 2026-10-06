package com.itheima.loopfor;

public class ForDemo4 {
    static void main() {
        /*
         * for 循环练习
         *
         * 需求：在实际开发中，如果要获取一个范围中的每一个数据时，会用到循环。
         * 但是，如果不想获取所有的数据，而是获取其中符合要求的数据。
         * 此时就需要循环和其他语句结合使用了。
         * 比如：求1-100之间的偶数和
         *
         */

        int sum1 = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                // sum1 = i + sum1;
                sum1 += i;
            }
        }
        System.out.println(sum1);

        int sum2 = 0;
        for (int i = 2; i <= 100; i += 2) {
            sum2 += i;
        }
        System.out.println(sum2);

    }
}
