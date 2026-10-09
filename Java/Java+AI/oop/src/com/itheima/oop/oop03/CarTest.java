package com.itheima.oop.oop03;

public class CarTest {
    static void main() {
        /*
         * 1. private关键字：是一个权限修饰符，可以修饰成员变量和成员方法。
         *    特点：被private修饰的成员只能在本类中才能访问。
         *
         * 2. 针对private修饰的成员变量，需提供以下操作：
         *    提供setXxx(参数)，给成员变量赋值，用public修饰。
         *    提供getXxx()，获取成员变量的值，用public修饰。
         *
         * 3. 就近原则
         *    在方法当中直接使用变量查找顺序：先找局部变量，再找成员变量
         *
         * 4. this的作用？
         *    可以区别成员变量和局部变量
         *    System.out.println(age);      // 触发就近原则
         *    System.out.println(this.age); // 使用成员变量
         *
         */

        // 1. 创建汽车对象
        Car car = new Car();

        // 2. 通过 set 方法给私有属性赋值
        car.setBrand("特斯拉");
        car.setModel("Model 3");
        car.setColor("白色");
        car.setPrice(250000.0);

        // 3. 通过 get 方法获取属性并打印
        System.out.println("品牌：" + car.getBrand());
        System.out.println("型号：" + car.getModel());
        System.out.println("颜色：" + car.getColor());
        System.out.println("价格：" + car.getPrice() + "元");

        // 4. 调用 run 方法
        car.run();
        System.out.println("----------------");
        car.showInfo();

    }
}
