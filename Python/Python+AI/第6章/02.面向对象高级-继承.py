# 继承：描述的是两个类之间的关系，子类继承父类，就可以获取到父类中的属性和方法（非私有）

class Car:
    def __init__(self, brand, model, color, owner):
        # 实例属性
        self.brand = brand  # 品牌 (公有属性)
        self.model = model  # 型号 (公有属性)
        self.color = color  # 颜色 (公有属性)

        self.__owner = owner  # 车主 (私有属性)

    def start(self):  # 启动
        print(f"{self.brand} {self.model} 正在启动...")

    def run(self):  # 行驶
        print(f"{self.__owner}： {self.brand} {self.model} 正在行驶...")
        self.__control_fuel()

    def stop(self):  # 停止
        print(f"{self.brand} {self.model} 停止行驶...")

    def __control_fuel(self):  # 私有方法
        print(f"{self.brand} {self.model} 正在控制油门...")

    def get_owner(self):
        return self.__owner[0:1] + "**"


# 油车
class FuelCar(Car):
    pass


# 电车
class ElectricCar(Car):
    pass


if __name__ == '__main__':
    c1 = ElectricCar('小米', '澎程N90', '车厘子红', 'BUQINGLI')
    c1.start()
    c1.run()
    c1.stop()

    print(c1.brand)
    print(c1.model)
    print(c1.color)
    print(c1.get_owner())
