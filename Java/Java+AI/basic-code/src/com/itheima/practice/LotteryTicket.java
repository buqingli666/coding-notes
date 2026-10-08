package com.itheima.practice;

import java.util.Random;
import java.util.Scanner;

public class LotteryTicket {
    static void main() {
        /*
         * 彩票规则：
         * 前区：1 ~ 35 选5个号码（唯一）
         * 后区：1 ~ 12 选2个号码（唯一）
         * 跨区可重复
         *
         * 中奖规则：
         *       一等奖：5 + 2
         *       二等奖：5 + 1
         *       三等奖：5 + 0 / 4 + 2
         *       四等奖：4 + 1 / 3 + 2
         *       五等奖：4 + 0 / 3 + 1 / 2 + 2
         *       六等奖：3 + 0 / 1 + 2 / 2 + 1 / 0 + 2
         *
         * 1. 利用Random随机，生成彩票号码
         * 2. 利用Scanner模拟购买彩票
         * 3. 判断中奖
         *
         */

        // 1. 利用Random随机，生成彩票号码
        int[] lotteryNumber = createLotteryNumber();
        printLotteryNumber(lotteryNumber);

        // 2. 利用Scanner模拟购买彩票
        int[] myLotteryNumber = buyLotteryNumber();
        printLotteryNumber(myLotteryNumber);

        // 3.判断中奖
        // 判断中了几个前区（红球）
        // 判断中ア几个后区（蓝球）
        getWinnerNumber(lotteryNumber, myLotteryNumber);

    }

    // 作用:判断arr2里面的数据,在arr1中出现了几次
    // arr1: 真正的彩票号码
    // arr2: 用户购买的彩票号码
    public static void getWinnerNumber(int[] arr1, int[] arr2) {
        // 判断前区中了几个球
        int count1 = getCount(arr1, arr2, 0, 4);

        // 判断后区中了几个球
        int count2 = getCount(arr1, arr2, 5, 6);

        // 判断中了几等奖
        if (count1 == 5 && count2 == 2) {
            System.out.println("恭喜你,中了一等奖");
        } else if (count1 == 5 && count2 == 1) {
            System.out.println("恭喜你,中了二等奖");
        } else if (count1 == 5 && count2 == 0 || count1 == 4 && count2 == 2) {
            System.out.println("恭喜你,中了三等奖");
        } else if (count1 == 4 && count2 == 1 || count1 == 3 && count2 == 2) {
            System.out.println("恭喜你,中了四等奖");
        } else if (count1 == 4 && count2 == 0 || count1 == 3 && count2 == 1 || count1 == 2 && count2 == 2) {
            System.out.println("恭喜你,中了五等奖");
        } else if (count1 == 3 && count2 == 0 || count1 == 2 && count2 == 1 || count1 == 1 && count2 == 2 || count1 == 0 && count2 == 2) {
            System.out.println("恭喜你,中了六等奖");
        } else {
            System.out.println("恭喜你,没有中奖");
        }

    }

    // 判断前区或者后区中了几个球
    public static int getCount(int[] arr1, int[] arr2, int start, int end) {
        int count = 0;

        for (int i = start; i <= end; i++) {
            // arr2[i]到arr1判断，是否存在
            boolean flag = contains(arr2[i], arr1, start, end);
            // 如果当前的数字已存在, 表示中了一个号码
            if (flag) {
                count++;
            }
        }

        // 当循环结束之后,我就知道了,在start ~ end之间,中了几个号码
        return count;
    }

    // 购买彩票
    public static int[] buyLotteryNumber() {
        // 1. 创建数组
        int[] arr = new int[7];

        // 2. 利用Scanner模拟购买彩票，前区的五个号码，1～35选5个号码（唯一）
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; ) {
            System.out.println("请输入第" + (i + 1) + "个彩票号码：");
            int number = sc.nextInt();
            // 范围
            if (number < 1 || number > 35) {
                System.out.println("当前彩票号码不在范围当中，请重新选择~");
                continue;
            }
            // 唯一
            boolean flag = contains(number, arr, 0, 4);
            if (flag) {
                System.out.println("当前彩票号码已存在，请重新选择~");
            }
            arr[i] = number;
            i++;
        }

        // 3. 利用Scanner模拟购买彩票，后区的两个号码，1～12选2个号码（唯一）
        for (int i = 0; i < 2; ) {
            System.out.println("请输入第" + (i + 1) + "个彩票号码：");
            int number = sc.nextInt();
            // 范围
            if (number < 1 || number > 12) {
                System.out.println("当前彩票号码不在范围当中，请重新选择~");
                continue;
            }
            // 唯一
            boolean flag = contains(number, arr, 5, 6);
            if (flag) {
                System.out.println("当前彩票号码已存在，请重新选择~");
            }
            arr[i + 5] = number;
            i++;
        }
        return arr;
    }

    // 生成彩票号码
    public static int[] createLotteryNumber() {
        // 1. 创建数组
        int[] arr = new int[7];

        // 2. 利用Random生成彩票号码，生成前区的五个号码，1～35选5个号码（唯一）
        Random r = new Random();
        for (int i = 0; i < 5; ) {
            int number = r.nextInt(1, 36);
            // 在前面的五个数据中，判断number是否唯一 0～4
            boolean flag = contains(number, arr, 0, 4);
            if (!flag) {
                arr[i] = number;
                i++;
            }
        }

        // 3. 利用Random生成彩票号码，生成后区的五个号码，1～12选2个号码（唯一）
        for (int i = 0; i < 2; ) {
            int number = r.nextInt(1, 12);
            // 在前面的五个数据中，判断number是否唯一 5～6
            boolean flag = contains(number, arr, 5, 6);
            if (!flag) {
                arr[i + 5] = number;
                i++;
            }
        }
        return arr;
    }

    // 判断number是否唯一
    public static boolean contains(int number, int[] arr, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == number) {
                return true;
            }
        }
        return false;
    }

    // 遍历数组
    public static void printLotteryNumber(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.println("]");
    }
}
