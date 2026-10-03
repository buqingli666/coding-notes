# 案例2：猜数字游戏
# 1.系统随机生成一个随机数
# 2.用户根据提示猜数字，并将所猜的数字输入系统
# 3.如果猜错，系统给出提示是猜大了，还是猜小了，然后继续输入猜的数字
# 4.如果猜对，系统自动退出，游戏结束
import random

random_num = random.randint(1, 100)  # 生成随机数
while True:
    input_num = int(input("请输入所猜数字："))
    if input_num > random_num:
        print("猜的数有点大～")
    elif input_num < random_num:
        print("猜的数有点小～")
    else:
        print("恭喜你猜中啦～")
        break

# 需求1：将1-1000之间（含1000）所有的5的倍数的数字累加起来
total = 0
for i in range(1, 1001):
    if i % 5 == 0:
        total += i
print(f"1-1000之间（含1000）所有的5的倍数的数字累加为：{total}")

# 需求2：统计字符串 "akiwksjakdiklowiqaamnvbamvaxnsjdsjkaaxkjd" 字符串中有多少个a和k
msg = "akiwksjakdiklowiqaamnvbamvaxnsjdsjkaaxkjd"
total = 0
for i in msg:
    if i == "a" or i == "k":
        total += 1
print(f"字符串中a和k出现的次数: {total}")
