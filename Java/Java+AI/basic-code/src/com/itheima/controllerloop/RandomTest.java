package com.itheima.controllerloop;

import java.util.Random;
import java.util.Scanner;

public class RandomTest {
    static void main() {
        /*
         * Random 随机数
         * (了解)第一种写法：小括号里不写 nextInt(); 默认是在int的取值范围之内获取随机数
         * (重要)第二种写法：小括号里写一个数字n，表示随机数的最大值，但是不包含这个数字
         * (重要)第三种写法：小括号里写两个数字a b，表示随机的取值范围是a ~ b，包含a，不包含b 该写法在JDK17版本出现
         *
         * 生成一个1～100之间的随机数，利用键盘录入模拟猜的动作，一直猜，直到猜中为止
         *
         */

        // 1. 生成一个随机数
        Random r = new Random();
        int number = r.nextInt(1, 101);
        System.out.println(number);

        while (true) {
            // 2. 键盘录入模拟猜的动作
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入你要猜的数字： ");
            int guessNumber = sc.nextInt();

            // 3. 比较
            if (guessNumber > number) {
                System.out.println("你猜的数字太大了");
            } else if (guessNumber < number) {
                System.out.println("你猜的数字太小了");
            } else {
                System.out.println("恭喜你猜对了");
                break;
            }
        }
    }
}