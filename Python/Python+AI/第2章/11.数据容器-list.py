# 列表操作
# 特点：可以存放不同类型元素、可重复、有序、元素可以修改

# =======================================================

# 1.定义列表
s = [30, 66, 89, "A", "Hello", True]
print(type(s))

# =======================================================

# 2.访问列表元素
# 获取
print(s[0])  # 正向索引，从0开始
print(s[-6])  # 反向索引，从-1开始

# 修改
s[4] = "Python"
print(s)

# 注意：如果指定的索引，超出范围，将会报错 list assignment index out of range
# s[8] = "Java"
# print(s)

# 删除
del s[2]
print(s)

# 遍历
for item in s:
    print(item)

# =======================================================

# 3.列表切片
s = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"]

# 切片操作：[开始索引:结束索引:步长]
print(s[0:5:1])
print(type(s[0:5:1]))

# 开始索引不指定默认为0；结束索引不指定默认为列表长度-1；步长不指定默认为1
print(s[:5:1])
print(s[:5:])
print(s[:5])

print(s[0:5:2])

print(s[0:-3:1])

# =======================================================

# 4.列表list常用方法
s = [56, 90, 88, 65, 90, 100, 209, 72, 145]
print(s)

# append()：在列表尾部追加元素
s.append(188)
print(s)

# insert()：在指定索引之前，插入元素
s.insert(2, 80)
print(s)

# remove()：移除列表中第一个匹配到的元素
s.remove(90)
print(s)

# pop()：删除列表中指定索引位置的元素并返回（如果未指定，默认删除最后一个）
e = s.pop(1)
print(e)

e = s.pop()
print(e)

print(s)

# sort()：排序
s.sort()
print(s)

# reverse()：反转列表元素
s.reverse()
print(s)

# =======================================================

# 5.案例：将用户输入的10个数字，存储到一个列表中，并将列表中的数字进行排序，输出其中的最小值、最大值和平均值
num_list = []
for i in range(10):
    num = int(input(f"请输入第{i + 1}个数字："))
    num_list.append(num)
print(f"输入的列表：{num_list}")

num_list.sort()
print(f"列表排序后：{num_list}")

# min()：获取最小值
print(f"最小值：{num_list[0]}")
# max()：获取最大值
print(f"最大值：{num_list[-1]}")
# sum()：求和
# len()：获取元素的个数（列表的长度）
print(f"平均值：{sum(num_list) / len(num_list)}")

# 6.案例：合并两个列表中的元素，并对合并的结果进行去重处理（去除列表中的重复元素）
num_list1 = [19, 23, 54, 64, 875, 20, 109, 232, 123, 54]
num_list2 = [55, 80, 72, 35, 60, 123, 54, 29, 91]
for num in num_list2:
    num_list1.append(num)
print(f"合并后的原始列表：{num_list1}")
new_list = []  # 去重后的列表
for num in num_list1:
    # 判断元素是否存在于列表中，如果存在，则返回True；不存在，返回False
    if num not in new_list:
        new_list.append(num)
print(f"去重后的列表：{new_list}")

# 6.案例（简化）：合并两个列表中的元素，并对合并的结果进行去重处理（去除列表中的重复元素）
num_list1 = [19, 23, 54, 64, 875, 20, 109, 232, 123, 54]
num_list2 = [55, 80, 72, 35, 60, 123, 54, 29, 91]

# 合并后的列表
# 解包：使用*进行解包操作（解包指将列表这一类数据容器解开成独立的元素）
# 组包：将多个值合并到一个容器
num_list = [*num_list1, *num_list2]
# num_list = num_list1 + num_list2 也可以完成列表合并
print(f"合并后的原始列表：{num_list}")

# 去重后的列表
new_list = []
for num in num_list:
    # 判断new_list中是否存在num元素，如果不存在，再添加
    # 判断元素是否存在于列表中，语法为：元素 in 列表 如果存在，则返回True；不存在，返回False
    if num not in new_list:
        new_list.append(num)
print(f"去重后的列表：{new_list}")

# 7.案例：生成1-20的平方列表
# 方式一：传统方式
num_list = []
for i in range(1, 21):
    num_list.append(i ** 2)
print(num_list)

# 方式二：列表推导式 ---＞ 按照一定的规则快速生成一个列表的方法 --> 语法格式1：列表名称 = [要插入的值 for i in 列表]
num_list2 = [i ** 2 for i in range(1, 21)]
print(num_list2)

# 案例：从一个数字列表中提取所有偶数，并计算其平方，组成一个新的列表
# 列表推导式 ---＞ 按照一定的规则快速生成一个列表的方法 --> 语法格式2：列表名称 = [要插入的值 for i in 列表 if 条件]
num_list = [12, 32, 45, 77, 80, 92, 33, 57, 97, 98, 110, 111, 122]
new_list = [num ** 2 for num in num_list if num % 2 == 0]
print(new_list)

# 需求1：将如下多个列表合并为一个列表，并去重重复元素，排好序（升序）后输出到控制台
list1 = ['M', 'A', 'C', 'E', 'F', 'G', 'H', 'L', 'N', 'I', 'J', 'K', 'O']
list2 = ['X', 'Z', 'T', 'Y', 'D', 'E', 'F', 'G']
list3 = ['W', 'A', 'S', 'D']

merge_list = [*list1, *list2, *list3]
print(f"合并后的原始列表为：{merge_list}")

new_list = []
for i in merge_list:
    if i not in new_list:
        new_list.append(i)
print(f"去重后的新列表为{new_list}")
new_list.sort()
print(f"去重并排序后的列表：{new_list}")

# 需求2：将如下列表中能被3 或 5整除的元素提出来，并获取这些数字对应的平方，组成一个新的列表
list4 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30]
new_list = [i ** 2 for i in list4 if i % 3 == 0 or i % 5 == 0]
print(new_list)

# 需求3：将如下列表中的正数提取出来，封装为一个新的列表
list5 = [11, 2, 31, 4, -5, 15, 17, 28, 49, 10, -11, 16, 54, -14, 36, -16, 87, -39]
new_list = [i for i in list5 if i > 0]
print(new_list)
