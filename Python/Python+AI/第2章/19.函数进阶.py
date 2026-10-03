# 函数 - 变量作用域
# 全局变量：在函数外部 或 函数的内部都是可以访问的
num = 100


def circle_area(r):
    # 局部变量：只能在函数内部使用
    pi = 3.14
    area = pi * r * r

    # 声明接下来要使用的是全局变量
    global num
    num = 10000
    print("num = ", num)  # 10000

    return area


c_area = circle_area(10)
print(c_area)

print("num = ", num)  # 10000


# =======================================================

# 函数 - 传参方式

def reg_stu(name, age, gender, city):
    print(f"注册成功，姓名：{name}，年龄：{age}，性别：{gender}，城市：{city}")
    return {"name": name, "age": age, "gender": gender, "city": city}


# 传参方式一：位置参数
stu = reg_stu("张三", 18, "男", "北京")
print(stu)

# 传参方式二：关键字参数
stu = reg_stu(name="赵六", age=26, gender="男", city="上海")
print(stu)

stu = reg_stu(gender="女", age=33, name="王五", city="上海")
print(stu)

# 传参方式三：位置参数 + 关键字参数（位置参数在前，关键字参数在后）
stu = reg_stu("李四", 33, gender="女", city="深圳")
print(stu)


# =======================================================

# 函数 - 默认参数
def reg_stu(name, age, gender="男", city="北京"):
    print(f"注册成功，姓名：{name}，年龄：{age}，性别：{gender}，城市：{city}")
    return {"name": name, "age": age, "gender": gender, "city": city}


stu = reg_stu("雷军", 55)
print(stu)

stu = reg_stu("董明珠", 56, "女")
print(stu)

stu = reg_stu("王腾", 42, city="上海")
print(stu)


# =======================================================

# 函数 - 不定长参数 (位置参数 *args -> 元组)
# 根据传入的数据，计算这批数据中的最小值、最大值、平均值
def calc_data(*args):
    max_data = max(args)
    min_data = min(args)
    avg_data = sum(args) / len(args)
    return max_data, min_data, round(avg_data, 1)


print(calc_data(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))


# =======================================================

# 函数 - 不定长参数 (关键字参数 **kwargs -> 字典)
# 根据传入的数据，计算这批数据中的最小值、最大值、平均值
def calc_data(*args, **kwargs):
    """
    根据传入的数据，计算这批数据中的最小值、最大值、平均值
    :param args: 不定长位置参数，需要计算的这批数据
    :param kwargs: 不定长关键字参数
           round: 保留的小数位个数
           print: 是否打印输出
    :return: 最小值，最大值，平均值
    """
    max_data = max(args)
    min_data = min(args)
    avg_data = sum(args) / len(args)

    if kwargs.get("round") is not None:
        avg_data = round(avg_data, kwargs.get("round"))

    if kwargs.get("print"):
        print(f"最大值：{max_data}，最小值：{min_data}，平均值：{avg_data}")
    return max_data, min_data, avg_data


print(calc_data(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, round=3, print=False))


# =======================================================

# 函数的参数类型（函数作为参数）
def add(x, y):
    return x + y


def subtract(x, y):
    return x - y


def multiply(x, y):
    return x * y


def divide(x, y):
    return x / y


def calc(x, y, oper):
    return oper(x, y)


print(calc(10, 20, add))

# =======================================================

# 匿名函数 - lambda 参数列表 : 函数体
# 需求1：打印一个分割线
# def out_line():
#     print("-------------")

out_line = lambda: print("--------------")
out_line()

# 需求2：计算两个数之和
# def add(x, y):
#     return x + y

add = lambda x, y: x + y
print(add(110, 220))

# 需求3：完成如下列表的排序操作，按照每一个元素的字符个数，从小到大排序；
data_list = ["C++", "C", "Python", "Jack", "PHP", "Java", "Go", "JavaScript", "Rust"]

# 匿名函数典型应用场景
data_list.sort(key=lambda item: len(item))
print(data_list)

# =======================================================

# 案例1：计算n的阶乘
# 递归调用(先层层递进，再逐层回归)：指的是在函数中自己调用自己的情况 ----> 一定得有终点

"""
jc(10) = 10 * jc(9) = 10 * 362880 = 3628800
jc(9) = 9 * jc(8) = 9 * 40320 = 362880
jc(8) = 8 * jc(7) = 8 * 5040 = 40320
jc(7) = 7 * jc(6) = 7 * 720 = 5040
jc(6) = 6 * jc(5) = 6 * 120 = 720
jc(5) = 5 * jc(4) = 5 * 24 = 120
jc(4) = 4 * jc(3) = 4 * 6 = 24
jc(3) = 3 * jc(2) = 3 * 2 = 6
jc(2) = 2 * jc(1) = 2 * 1 = 2
jc(1) = 1
"""


def jiecheng(n):
    if n == 1:
        return 1
    else:
        return n * jiecheng(n - 1)


res = jiecheng(10)
print(res)


# 案例2：定义一个用于根据传入的一批商品信息（商品名、价格、数量）、优惠（优惠券、积分抵扣）、运费信息计算订单的总金额的函数。
# 具体规则如下：
#     1. 优惠券需要商品金额满5000才可以使用，且优惠券金额不能超过商品总价。
#     2. 积分抵扣需要商品总金额满5000才可以使用，100积分抵扣1元（且抵扣金额不能超过商品总价，积分只能整百抵扣）。

def calc_order_cost(*args, coupon=0, points=0, express=0.0):
    """
    根据传入的一批商品信息（商品名、价格、数量）、优惠（优惠券、积分抵扣）、运费信息计算订单的总金额
    :param args: 商品信息（商品名、价格、数量）---> ("背包", 88, 3) ("耳机", 498, 1)
    :param coupon: 优惠券
    :param points: 积分抵扣
    :param express: 运费
    :return: 订单的总金额
    """
    # 计算商品的总金额
    total_price = [goods[1] * goods[2] for goods in args]
    total_cost = sum(total_price)

    # 扣减优惠券
    if total_cost >= 5000 and coupon <= total_cost:
        total_cost -= coupon

    # 扣减积分
    if total_cost >= 5000 and points // 100 <= total_cost:
        total_cost -= points // 100

    # 添加运费
    total_cost += express

    return total_cost


# total = calc_order_cost(("背包", 88, 3), ("耳机", 498, 1), ("电脑", 3999, 1), coupon=100, points=3000, express=9.9)
# print(total)

# total = calc_order_cost(("背包", 88, 3), ("耳机", 498, 1), ("电脑", 5999, 1), coupon=100, points=3000, express=9.9)
# print(total)

# total = calc_order_cost(("背包", 88, 3), ("耳机", 498, 1), ("电脑", 5999, 1), express=9.9)
# print(total)

total = calc_order_cost(("背包", 88, 3), ("耳机", 498, 1), ("电脑", 5999, 1))
print(total)
