# 1.获取键盘上输入的数据 --> input(...)
name = input("请输入你的姓名：")
age = input("请输入你的年龄：")
print(f"你输入的姓名是{name}，年龄是{age}岁")

# 案例：银行卡 ATM 取款
# 总金额
total = 10000
# 输入密码
password = input("请输入您的银行卡密码")
# 输入取款金额
num = input("请输入您要取款的金额")
# 计算余额并输出 ---> num 转为 int 类型 ---> int（...）
print(f"您的银行卡剩余余额为：{total - int(num)}")

# 需求：根据用户输入的两个数字，计算两个数之和，并将其输出到控制台
num1 = int(input("请输入第一个数："))
num2 = int(input("请输入第二个数："))
print(f"{num1} + {num2} = {num1 + num2}")
