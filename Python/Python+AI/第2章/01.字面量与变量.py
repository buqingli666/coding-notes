# 1.字面量
print(100)  # 整数（int）
print(3.13)  # 浮点数/小数（float）
print(True)  # 布尔（bool）
print(False)  # 布尔（bool）
print("Hello Python")  # 字符串（str）
print("============")  # 字符串（str）
print(None)  # 空值（NoneType）

# 布尔类型本质也是整数类到（True -> 1；False -> 0）
print(True + 1)  # 2
print(False - 1)  # -1

# =======================================================

# 2.变量
# Python 是动态类型语言，一个变量是可以存储不同类型的数据的（项目开发中，推荐变量只存储一种类型的数据）
num = 1234.5
print(num)

num = num + 1
print(num)

num = "Hello Python"
print(num)

num = True
print(num)

# 案例（变量）：
base = 20.7  # 基础播放量
incr = 50  # 每一个月的新增播放量
print("未来第一个月的播放总量：", base + incr)
print("未来第二个月的播放总量：", base + incr + incr)

# 案例（升级）：
# 一次性可以定义多个变量
base, incr = 20.8, 50
print("未来第一个月的播放总量：", base + incr)
print("未来第二个月的播放总量：", base + incr + incr)

# =======================================================

# 3.标识符
# 命名规则（规定）：
# 1.只能包含字母（a-z,A-Z）、数字（0-9）、下划线（_）
# 2.不能以数字开头
# 3.不能使用关键字：True、False、None、and、or、if、else、elif、 for、while等
# 4.严格区分大小写，比如：age，Age，AGE 是三个变量

# 命名规范（变量）：
# 1.见名知意
# 2.多个部分使用下划线连接
# 3.英文字母全小写

# =======================================================

# 4.案例：现有两个变量，分别为：a=10，b=20，现需要将这两个变量值交换，然后输出到控制台
a = 10
b = 20
c = a  # c = 10
a = b  # a = 20
b = c  # b = 10
print("a 的值是：", a)
print("b 的值是：", b)

# 5.案例：现有三个变量，分别为：a=100，b=200，c=300，现需要将这三个变量值进行交换，将a，b，c的值分别赋值给c，a，b，并将其输出到控制台
a = 100
b = 200
c = 300

temp = a  # temp = 100
a = b
b = c
c = temp

print("c = ", c)
print("a = ", a)
print("b = ", b)
