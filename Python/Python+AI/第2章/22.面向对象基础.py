# 定义类 -> 不推荐动态的为对象添加属性
# 说明：类名的命名规范，遵循大驼峰命名法，每个单词的首字母都是大写，单词之间没有分隔符，比如：UserInfo, UserAccount
# class Car:
#     pass


# 创建对象
# car = Car()

# 动态的为对象添加属性
# car.brand = "BWM"
# car.name = "X5"
# car.price = 500000

# print(car)
# print(car.brand)
# 说明：__dict__是Python中用户自定义类实例的一个特殊属性，用于以字典形式存储对象的属性
# print(car.__dict__)

# 定义类 -> 推荐
class Car:
    # __init__：初始化方法，对象创建后自动调用，主要用于设置对象的初始状态（设置对象属性）
    # self：方法的第一个参数，表示当前创建的实例对象
    def __init__(self, c_brand: str, c_name: str, c_price: float):
        self.brand = c_brand
        self.name = c_name
        self.price = c_price
        print("Car类型的对象初始化完毕，对象属性已经添加完毕")


# 创建对象
car = Car("澎程", "N90", 269999)
print(car.__dict__)


# =======================================================

# 实例方法
class Car1:
    def __init__(self, c_brand: str, c_name: str, c_price: float):
        self.brand = c_brand
        self.name = c_name
        self.price = c_price

    # 定义实例方法
    def running(self):
        print(f"{self.brand} {self.name} 正在行驶中...")

    def total_cost(self, discount: float, rate: float):
        """
        计算提车的总费用，包含两个部分：车的价格，税费
        :param discount: 折扣
        :param rate: 税率
        :return: 提车的总费用
        """
        return self.price * discount + rate * self.price


car1 = Car1("小米", "SU7", 219999)
print(car1.__dict__)

# 调用对象中的方法
car1.running()
total = car1.total_cost(discount=0.9, rate=0.1)
print("提车的总费用为：", total)


# =======================================================

# 魔法方法
class Car2:
    def __init__(self, c_brand: str, c_name: str, c_price: float):
        self.brand = c_brand
        self.name = c_name
        self.price = c_price

    # 定义实例方法
    def running(self):
        print(f"{self.brand} {self.name} 正在行驶中...")

    def total_cost(self, discount: float, rate: float):
        """
        计算提车的总费用，包含两个部分：车的价格，税费
        :param discount: 折扣
        :param rate: 税率
        :return: 提车的总费用
        """
        return self.price * discount + rate * self.price

    # 魔法方法
    def __str__(self) -> str:
        return f"{self.brand} {self.name} {self.price}"

    def __eq__(self, other: object) -> bool:
        # 判断类型，如果不是当前类的实例，返回 NotImplemented
        if not isinstance(other, self.__class__):
            return NotImplemented

        return self.brand == other.brand and self.name == other.name and self.price == other.price

    def __lt__(self, other):
        return self.price < other.price


car2 = Car2("BYD", "汉", 188000)
print(car2)

car3 = Car2("BYD", "汉", 188008)
print(car3)

print(car2 == car3)
print(car2 < car3)


# =======================================================

# 实例属性 与 类属性
# 通过实例对象，查找属性时，会先查找实例属性；实例属性不存在，再查找类属性
class Car3:
    # 类属性（所有实例对象共享的）
    wheel = 4  # 轮胎数量
    tax_rate = 0.1  # 购置税税率

    def __init__(self, c_brand: str, c_name: str, c_price: float):
        # 实例属性
        self.brand = c_brand
        self.name = c_name
        self.price = c_price

    # 定义实例方法
    def running(self):
        print(f"{self.brand} {self.name} 正在行驶中...")

    def total_cost(self, discount: float, rate: float):
        """
        计算提车的总费用，包含两个部分：车的价格，税费
        :param discount: 折扣
        :param rate: 税率
        :return: 提车的总费用
        """
        return self.price * discount + rate * self.price


car4 = Car3("BYD", "汉", 188000)
print(car4.brand)
print(car4.wheel)

# 通过类名访问类属性
print(Car3.wheel)
