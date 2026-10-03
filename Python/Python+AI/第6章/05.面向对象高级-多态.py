# 多态是指同一个方法，具有不同的形态、行为、表现
# 例如：定义函数时，参数类型指定为父类类型，在执行的时候传入不同的子类对象，就具有不同的形态

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
        print(f'{self.brand} {self.model} 正在加油...')


# 电车
class ElectricCar(Car):
    def charge(self):
        print(f'{self.brand} {self.model} 正在充电...')


# 补充燃料函数
def handel_charge(car: Car):  # 函数参数类型声明 -> 指定的是父类型
    car.charge()


if __name__ == '__main__':
    handel_charge(FuelCar('奥迪', 'A6', '黑色', 'BUQINGLI'))
    handel_charge(ElectricCar('理想', 'L9', '黑色', 'BUQINGLI'))
