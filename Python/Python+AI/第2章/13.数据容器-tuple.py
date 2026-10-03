# 元组操作 - tuple
# 特点：
# 可以存储不同类型的元素
# 元素可以重复、有序、不可以修改（支持索引访问、切片）

# =======================================================

# 定义元组
# 元组名称 = (元素1, 元素2, ...)
# 元组名称 = ()
# 元组名称 = tuple()
t1 = (35, 23, 16, 64, 32, 81, 63, 16)
print(type(t1))

# 索引访问
print(t1[0])  # 35
print(t1[-1])  # 63

# 切片
print(t1[0:4:1])  # (35, 23, 16, 64)

# count()：统计某元素在元组中出现的次数
print(t1.count(16))  # 2
# index()：查找某个元素在元组中的索引位置（第一次出现的位置）
print(t1.index(23))  # 1

# 注意：如果定义单元素的元组，单个元素之后需要加上逗号，比如(100,)
t2 = ()
print(type(t2))
t3 = (100,)
print(type(t3))

# 元组 tuple 组包与解包
# 组包（Packing）：将多个值合并到一个容器（元组、列表）中
t4 = (65, 76, 32, 65, 12, 43, 78)
print(t4)  # (65, 76, 32, 65, 12, 43, 78)

t5 = 65, 76, 32, 65, 12, 43, 78
print(t5)  # (65, 76, 32, 65, 12, 43, 78)
# 解包（Unpacking）：将容器（元组、列表）解开成独立的元素，分别赋值给多个变量
# 基础解包（变量数量与容器的元素个数一致）
a, b, c, d, e, f, g = t5
print(a, b, c, d, e, f, g)  # 65 76 32 65 12 43 78
# * 扩展解包（*表示收集剩余的所有元素，允许我们处理不确定数量的元素（生成列表，以便于可以进行进一步的处理））
first, second, *other, last = t5
print(first, second)  # 65 76
print(other)  # [32, 65, 12, 43]
print(last)  # 78

# =======================================================

# 案例：现有两个变量，分别为：a=10，b=20，现需要将这两个变量值交换，然后输出到控制台
a = 10
b = 20
# 组包
# t = a, b
# 解包
# b, a = t
# 合并
b, a = a, b
print(a)  # 20
print(b)  # 10
# 案例：现有三个变量，分别为：a=100，b=200，c=300，现需要将这三个变量值进行交换，将a,b,c的值分别赋值给c，a，b，并将其输出到控制台
a = 100
b = 200
c = 300
# 组包与解包操作
c, a, b = a, b, c
print(a)  # 200
print(b)  # 300
print(c)  # 100

# 根据提供的学生成绩单，完成如下需求：
# 1.计算每个学生的总分、各科平均分，然后一并输出出来
# 2.统计各科成绩的最低分、最高分、平均分，并输出
# 3.查找成绩优秀（平均分大于90）的学生，并输出
students = (
    ("S001", "王林", 85, 92, 78),
    ("S002", "李慕婉", 92, 88, 95),
    ("S003", "十三", 78, 85, 82),
    ("S004", "周轶", 95, 96, 89),
    ("S005", "曾牛", 88, 79, 91),
    ("S006", "王卓", 76, 82, 77),
    ("S007", "紅蝶", 89, 91, 94),
    ("S008", "徐立国", 75, 69, 82),
    ("S009", "许木", 86, 89, 98),
    ("S010", "遁天", 66, 59, 72)
)
# 1.计算每个学生的总分、各科平均分 {avg:.1f} ---> 保留1位小数
# 方式一：
# for student in students:
#     total = student[2] + student[3] + student[4]
#     avg = total / 3
#     print(
#         f"{student[0]} {student[1]} "
#         f"语文：{student[2]} "
#         f"数学：{student[3]} "
#         f"英语：{student[4]} "
#         f"总分：{total} 平均分：{avg:.1f}")
# 方式二：元组解包
for id, name, chinese, match, english in students:
    total = chinese + match + english
    avg = total / 3
    print(f"{id} {name} 语文：{chinese} 数学：{match} 英语：{english} 总分：{total} 平均分：{avg:.1f}")
print("--------------------------------------------------------")
# 2.统计各科成绩的最低分、最高分、平均分
chinese_score = [i[2] for i in students]
match_score = [i[3] for i in students]
english_score = [i[4] for i in students]
print(f"语文最低分：{min(chinese_score)} 最高分：{max(chinese_score)} 平均分：{sum(chinese_score) / len(chinese_score)}")
print(f"数学最低分：{min(match_score)} 最高分：{max(match_score)} 平均分：{sum(match_score) / len(match_score)}")
print(f"英语最低分：{min(english_score)} 最高分：{max(english_score)} 平均分：{sum(english_score) / len(english_score)}")
print("--------------------------------------------------------")
# 3.查找成绩优秀（平均分大于90）的学生，并输出
# 方式一：
# for student in students:
#     total = student[2] + student[3] + student[4]
#     avg = total / 3
#     if avg > 90:
#         print(f"学号：{student[0]} 姓名：{student[1]} 平均分：{avg:.1f}")
# 方式二：元组解包
for id, name, chinese, match, english in students:
    total = chinese + match + english
    avg = total / 3
    if avg > 90:
        print(f"学号：{id} 姓名：{name} 平均分：{avg:.1f}")
