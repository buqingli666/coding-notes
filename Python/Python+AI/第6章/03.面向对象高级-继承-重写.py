# 重写是指子类继承父类后，如果父类中的方法不满足需求，可以在子类中重新定义父类中已有的方法（方法名相同），从而用子类的实现替换父类的实现。
# 注意：如果子类在重写父类的方法时，需要调用父类的方法，可以通过 父类名.方法名(self) / super().方法名() 方式来调用。

class Car:
    def __init__(self, brand, model, color, owner):
        self.brand = brand  # 品牌(公有属性)
        self.model = model  # 型号(公有属性)
        self.color = color  # 颜色(公有属性)
        self.__owner = owner  # 车主(私有属性)

    def start(self):  # 启动
        print(f'{self.brand} {self.model} 正在启动...')

    def run(self):  # 行驶
        print(f'{self.__owner} : {self.brand} {self.model} 正在行驶...')

    def stop(self):  # 停止
        print(f'{self.brand} {self.model} 停止行驶...')

    def get_owner(self):
        return self.__owner[0:1] + "**"

    def charge(self):
        print(f'{self.brand} {self.model} 正在补充燃料...')


# 燃油车
class FuelCar(Car):
    def charge(self):
        # 方式一：父类名.方法名(self)
        Car.run(self)

        # 方式二：super().方法名()
        super().stop()

        print(f"{self.brand} {self.model} 正在加油中...")


class ElectricCar(Car):
    def charge(self):
        # 方式一：父类名.方法名(self)
        Car.run(self)

        # 方式二：super().方法名()
        super().stop()

        print(f"{self.brand} {self.model} 正在充电中...")


if __name__ == '__main__':
    c1 = FuelCar("沃尔沃", "XC60", "黑色", "BUQINGLI")
    c1.charge()
