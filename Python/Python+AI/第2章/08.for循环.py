# for循坏：遍历输入的字符串
msg = input("请输入你要遍历的字符串：")
for char in msg:  # char表示遍历出来的元素；msg表示需要遍历的数据
    print(f"元素：{char}")
else:
    print("遍历结束～")

# 案例1：计算1-100之间所有奇数之和
total = 0
for num in range(1, 101):
    if num % 2 != 0:
        total += num
print(f"1-100之间的所有奇数累加之和：{total}")

# 简化写法
# for num in range(1, 101, 2):
#     total += num

# 案例2：计算100-500之间所有3的倍数的数字之和
total = 0
for num in range(100, 501):
    if num % 3 == 0:
        total += num
print(f"100-500之间所有3的倍数的数字之和：{total}")

# 循环嵌套：根据输入的长方形的长度m，宽度n，打印一个长方形
# print("*")：自带换行效果，每一次执行都会输出新的一行中
# print("*",end="")：end表示的是每一次输出以什么结束；默认 \n，表示换行
m = int(input("请输入长方形的长："))  # 长度
n = int(input("请输入长方形的宽："))  # 宽度
for j in range(n):  # 控制行
    for i in range(m):  # 控制列
        print("*", end="   ")
    print()

# 嵌套循环案例：打印99乘法表
for i in range(1, 10):  # 控制行 1 x 3 中的“3”第二个数
    for j in range(1, i + 1):  # 控制列 1 x 3 中的“1”第一个数
        print(f"{j} x {i} = {j * i}", end="\t")
    print()

# 需求1：根据输入的直角边的边长，打印等腰直角三角形
side = int(input("请输入直角三角形的边长："))
for i in range(1, side + 1):
    for j in range(1, i + 1):
        print("*", end="  ")
    print()

# 需求2：根据输入的数字，打印对应的数字金字塔
num = int(input("请输入数字："))
for i in range(1, num + 1):  # 行
    for j in range(1, i + 1):  # 列
        print(f"{j}", end="\t")
    print()

"""
需求3：打印国际象棋棋盘
■   □   ■   □   ■   □   ■   □
□   ■   □   ■   □   ■   □   ■
■   □   ■   □   ■   □   ■   □
□   ■   □   ■   □   ■   □   ■
■   □   ■   □   ■   □   ■   □
□   ■   □   ■   □   ■   □   ■
■   □   ■   □   ■   □   ■   □
□   ■   □   ■   □   ■   □   ■
"""
for i in range(8):  # 行
    for j in range(8):  # 列
        if (i + j) % 2 == 0:
            print("■", end="  ")
        else:
            print("□", end="  ")
    print()
