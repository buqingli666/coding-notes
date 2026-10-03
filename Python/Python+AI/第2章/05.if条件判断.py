# if...条件判断：如果分数超过680，我就去清华读书
score = 686
if score > 680:
    print("欢迎你来清华读书")
    print("恭喜你即将踏入精彩的大学生活")

print("---------------------------")

# 案例：结合前面学习的输入输出及 if 条件判断的知识，完成B站登录功能的实现（正确账号和密码为18888888888/666888）
ok_account = "18888888888"
ok_password = "666888"
# 1.接收用户输入的账号和密码
account = input("请输入账号：")
password = input("请输入密码：")
# 2.判断账号和密码是否全部正确，如果都正确，则登录成功，进入B站首页
if account == ok_account and password == ok_password:
    print("登陆成功 ~")
    print("正在进入B站首页 ~")
# 3.判断账号和密码是否有错误的，如果有任何一个错误，则登录失败，提示错误信息
if account != ok_account or password != ok_password:
    print("登陆失败 ！")
    print("账号或密码错误 ！")

# =======================================================

# if...else...案例：结合前面学习的输入输出及 if 条件判断的知识，完成B站登录功能的实现（正确账号和密码为18888888888/666888）
ok_account = "18888888888"
ok_password = "666888"
# 1.接收用户输入的账号和密码
account = input("请输入账号：")
password = input("请输入密码：")
# 2.判断账号和密码是否全部正确，如果都正确，则登录成功，进入B站首页
if account == ok_account and password == ok_password:
    print("登陆成功 ~")
    print("正在进入B站首页 ~")
else:
    print("登陆失败 ！")
    print("账号或密码错误 ！")

# 案例：根据用户输入的年份，判断这一年是闰年还是平年（非整百年份，且能被4整除的年份是闰年；整百年份（如1900、2000）必须被400整除才是闰年）
year = int(input("请输入年份："))
if (year % 4 == 0 and year % 100 != 0) or (year % 400 == 0):
    print(f"{year}年是闰年")
else:
    print(f"{year}年是平年")

# 需求1：根据用户输入的数字，判断该数字是奇数还是偶数
num = int(input("请输入一个数字:"))
if num % 2 == 0:
    print(f"{num}是偶数！")
else:
    print(f"{num}是奇数！")

# 需求2：根据用户输入的年龄，判断该用户是否已经成年（>=18，成年；否则，未成年）
age = int(input("请输入年龄:"))
if age >= 18:
    print("已成年！")
else:
    print("未成年！")

# 需求3：根据用户输入的数字，判断该数字是正数还是负数（不考虑0）
num = int(input("请输入一个数字:"))
if num > 0:
    print(f"{num}是正数")
else:
    print(f"{num}是负数")

# 需求4：根据用户输入的考试分数，判断该分数是否及格了（大于等于60就是及格了）
score = float(input("请输入考试分数:"))
if score >= 60:
    print("及格了！")
else:
    print("未及格！")

# =======================================================

# if...elif...else... 案例：根据用户输入的数字，判断该数字是正数、负数还是0
num = int(input("请输入一个数字:"))
if num > 0:
    print(f"{num}是正数")
elif num < 0:
    print(f"{num}是负数")
else:
    print(f"{num}是0")

# 案例：根据输入用户名、密码进行登录系统 admin/666888 root/547527 zhang/123456
username = input("请输入用户名：")
password = input("请输入密码：")
if username == "admin" and password == "666888":
    print("登陆成功1")
elif username == "root" and password == "547527":
    print("登陆成功2")
elif username == "zhang" and password == "123456":
    print("登陆成功3")
else:
    print("登陆失败，用户名或密码错误")

# 案例：根据输入的考试成绩，判断成绩等级
#   1. 大于等于85分为优秀
#   2. 60-85分为及格
#   3. 否则就是不及格
score = float(input("请输入考试成绩:"))
if score >= 85:
    print(f"{score}分，优秀")
elif score >= 60:
    print(f"{score}分，及格")
else:
    print(f"{score}分，不及格")

# 案例：购物折扣计算：根据输入的购物车的商品总额，以及如下的折扣规则，计算实际应付的金额
#   1. 金额 >= 500: 8折
#   2. 300 <= 金额 < 500: 9折
#   3. 100 <= 金额 < 300: 95折
#   4. 金额 < 100: 无折扣
total_price = float(input("请输入购物车商品总额: "))
if total_price >= 500:
    print(f"实际应付金额：{total_price * 0.8}元")
elif total_price >= 300:
    print(f"实际应付金额：{total_price * 0.9}元")
elif total_price >= 100:
    print(f"实际应付金额：{total_price * 0.95}元")
else:
    print(f"实际应付金额：{total_price}元")

"""
案例：三角形类型判断：根据输入的三个边的边长（正整数），判定是等边三角形、等腰三角形、普通三角形，还是不能构成三角形
构成三角形的条件：两边之和大于第三边
三角形判定规则：
三个边都相等：等边三角形
两个边相等：等腰三角形
三个边都不相等：普通三角形
"""
# 1)接收三个边的边长
a = int(input("请输入第一个边的边长："))
b = int(input("请输入第二个边的边长："))
c = int(input("请输入第三个边的边长："))
# 2)判定三角形的类型 --- pass 是一个空语句，起到一个语法占位的作用
if a + b > c and a + c > b and b + c > a:
    if a == b and b == c:
        print(f"{a}，{b}，{c}这三个边长构成等边三角形 ～")
    elif a == b or b == c or a == c:
        print(f"{a}，{b}，{c}这三个边长构成等腰三角形 ～")
    else:
        print(f"{a}，{b}，{c}这三个边长构成普通三角形 ～")

else:
    print(f"{a}，{b}，{c}这三个边长不能构成三角形！")

""""
北京市居民年度用电电费计算：根据输入的用电度数，计算电费
北京市居民电费采用阶梯电价计价方式，所谓阶梯电价是指按照用户消费的电量分段定价，用电价格随用电量增加呈阶梯状逐级递增的一种电价定价机制。
- 阶梯电价规则：
  1. 第一档：2880度以下，电费单价0.4883元/度
  2. 第二档：2880-4800度，电费单价0.5383元/度
  3. 第三档：4800度以上，电费单价0.7883元/度
"""
usage_elec = float(input("请输入用电度数："))
# 定义阶梯电价
first_max = 2880  # 第一档上限
second_max = 4800  # 第二档上限

first_price = 0.4883  # 第一档单价
second_price = 0.5383  # 第二档单价
third_price = 0.7883  # 第三档单价

total_cost = 0.0  # 总电费

# 使用if语句进行阶梯电价计算
if usage_elec <= first_max:
    # 全部在第一档
    total_cost = usage_elec * first_price
elif usage_elec <= second_max:
    # 第一档部分
    first_cost = first_max * first_price

    # 第二档部分
    second_usage = usage_elec - first_max
    second_tier_cost = second_usage * second_price
    total_cost = first_cost + second_tier_cost
else:
    # 第一档部分
    first_cost = first_max * first_price

    # 第二档部分
    second_usage = second_max - first_max
    second_cost = second_usage * second_price

    # 第三档部分
    third_usage = usage_elec - second_max
    third_cost = third_usage * third_price
    total_cost = first_cost + second_cost + third_cost

print(f"{usage_elec} 度的电费是: {total_cost} 元")
