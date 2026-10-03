# 函数使用的注意事项
# - 函数必须先定义，再调用
# - 函数定义时，并不会执行，只有在调用函数时，函数体的逻辑才会运行
# - 函数中通过缩进来描述归属关系

# =======================================================

# 函数的定义
def out_line():
    print("----------")


# 函数的调用
out_line()


# =======================================================

# 函数的参数与返回值
# 计算圆的面积 - 半径
def circle_area(r):
    """
    根据圆的半径，计算圆的面积
    :param r: 半径
    :return: 圆的面积
    """
    area = 3.14 * r * r
    return area


c_area = circle_area(10)
print(f"圆的面积：{c_area}")


# 计算长方形的面积 - 长、宽
def rectangle_area(l, w):
    """
    根据长方形的长度、宽度，计算长方形的面积
    :param l: 长度
    :param w: 宽度
    :return: 长方形的面积
    """
    area = l * w
    return area


# help(rectangle_area)
r_area = rectangle_area(10, 5)
print(f"长方形的面积：{r_area}")


# 计算圆的面积和周长 - 半径
# 如果返回值有多个，多个返回值之间逗号分隔
# 多个返回值会封装到 元组(tuple) 之中
def circle_area_length(r):
    """
    根据圆的半径，计算圆的面积和周长
    :param r: 半径
    :return: 圆的面积，圆的周长
    """
    # round(要处理的数字, 保留的小数位数)
    return round(3.14 * r * r, 1), round(2 * 3.14 * r, 1)


# 解包
cir_area, perimeter = circle_area_length(10)
print(f"圆的面积：{cir_area}，周长：{perimeter}")


# =======================================================

# 函数的嵌套调用
# 函数调用遵循栈结构，后进先出（LIFO）
def function_a():
    print("a ... before")
    function_b()
    print("a ... after")


def function_b():
    print("b ... before")
    function_c()
    print("b ... after")


def function_c():
    print("c ...")


# 最外层调用
function_a()
