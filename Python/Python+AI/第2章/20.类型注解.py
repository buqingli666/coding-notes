# Python是动态类型语言，添加的类型注解只是提示，并不是强制约束！！！
# 变量定义 - 未指定类型注解 --> 类型推断
a1 = 596
score1 = 98.5
hobby1 = "Python"
flag1 = True
pic1 = None

names1 = ["A", "C", "E"]
phones1 = {"13309091111", "15209101902", "18809019201"}
options1 = {"count": 2, "total": 10}
goods1 = ("手机", 6999, 1)

# 变量定义 - 指定类型注解
a2: int = 596
score2: float = 98.5
hobby2: str = "Python"
flag2: bool = True
pic2: None = None

names2: list[str | int] = ["A", "C", "E"]
phones2: set[str] = {"13309091111", "15209101902", "18809019201"}
options2: dict[str, int] = {"count": 2, "total": 10}
goods2: tuple[str, int, int] = ("手机", 6999, 1)


# =======================================================

# 函数类型注解
def circle_area_len(r: float) -> tuple[float, float]:
    return round(3.14 * r * r), round(2 * 3.14 * r, 1)


al = circle_area_len(10)
print(al)


def calc_order_cost(*args: tuple[str, float, int], coupon: int = 0, points: int = 0, express: float = 0.0) -> float:
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


total = calc_order_cost(("背包", 88, 3), ("耳机", 498, 1), ("电脑", 5999, 1))
print(total)
