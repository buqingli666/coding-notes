package com.itheima.toolclass;

public class ArrayUtil {
    // 私有化构造方法，目的：不让外界创建对象
    private ArrayUtil() {
    }


    // 提供一个方法printArr，用于遍历数组
    // 格式如下：[10, 20, 50, 34, 100]（只考虑整数数组）
    public static String printArr(int[] arr) {
//        System.out.print("[");
//        for (int i = 0; i < arr.length; i++) {
//            if (i == arr.length - 1) {
//                System.out.println(arr[i] + "]");
//            } else {
//                System.out.print(arr[i] + ", ");
//            }
//        }

        String result = "[";
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                result = result + arr[i] + "]";
            } else {
                result = result + arr[i] + ", ";
            }
        }
        return result;
    }

    // 提供一个方法getAverage，用于返回平均分。（只考虑整数数组）
    public static double getAverage(int[] arr) {
        int sum = 0;
        for (int e : arr) {
            sum += e;
        }
        return sum * 1.0 / arr.length;
    }
}
