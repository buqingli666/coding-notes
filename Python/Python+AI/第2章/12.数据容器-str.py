# 字符串操作
# 特点：不可变性（无法修改）、有序性、可重复、可迭代性

# =======================================================

# 定义字符串
s = "Deepseek-v4-flash"

# 正向索引
print(s[3])
# 反向索引
print(s[-5])

for i in s:
    print(i)

# =======================================================

# 切片 [开始索引:结束索引:步长]
print(s[0:8:1])
print(s[:8:1])
print(s[:8:])
print(s[:8])

print(s[9:17:1])
print(s[9::1])

# 步长 ---＞ 正数：从前往后截取；负数：从后往前截取
print(s[-1:-6:-1])

# =======================================================

# 字符串常用方法
s = " Hello-World-Hello-Python"

# find() 在字符串中查找子串，返回第一次出现的索引位置，找不到返回-1
index_first = s.find("-")
print(index_first)

# count() 统计子串在字符串中出现的次数
c = s.count("l")
print(c)

# upper() 将字符串中的所有字母转换为大写
up = s.upper()
print(up)

# lower() 将字符串中的所有字母转换为小写
low = s.lower()
print(low)

# split() 将字符串按指定分隔符分割成列表
split = s.split("-")
print(split)

# strip() 去除字符串两端的空白字符或指定字符
ss = s.strip()
print(ss)

# replace() 将字符串中的指定子串替换为新的子串
sr = s.replace("-", "_")
print(sr)

# startswith()/endswith() 检查字符串是否以指定子串开头/结尾，返回布尔值
print(s.startswith("Hello"))
print(s.endswith("World"))

# =======================================================

# 案例：邮箱格式验证：用户输入一个邮箱，验证邮箱格式是否正确（包含一个@和至少一个.），如果输入正确，输出"邮箱格式正确"，否则输出"邮箱格式错误"
# 方式一：
mail = input("请输入你的邮箱：")
if mail.count("@") == 1 and mail.count(".") >= 1:
    print(f"邮箱格式正确✓：{mail}")
else:
    print(f"邮箱格式错误✗：{mail}")

# 方式二：in 运算符 ---> 判断子串是否存在字符串中，存在，返回True；否则，返回False
mail = input("请输入你的邮箱：")
if mail.count("@") == 1 and "." in mail:
    print(f"邮箱格式正确✓：{mail}")
else:
    print(f"邮箱格式错误✗：{mail}")

# 需求1：输入一个字符串, 判断该字符串是否是回文(两边对称)
# "黄山落叶松叶落山黄"
# "上海自来水来自海上"
msg = input("输入一个字符串：")
if msg == msg[::-1]:
    print(f"{msg}：是回文✓")
else:
    print(f"{msg}：不是回文✗")

# 需求2：将用户输入的10个字符串, 反转后全部转换为大写, 然后记录在列表中, 最后将列表内容，遍历输出出来
lst = []
for i in range(10):
    s = input(f"请输入第{i + 1}个字符串：")
    lst.append(s[::-1].upper())
print(f"输入、反转、大写后的字符串列表：{lst}")

print("遍历后的结果：")
for s in lst:
    print(s)
