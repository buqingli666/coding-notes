# 集合 - set
# 特点：set 是一种无序的、不可重复、可修改的数据容器

# =======================================================

# 定义集合
s1 = {"A", "D", "C", "B", "W", "M"}
print(s1)
print(type(s1))

# 定义空集合
# 空集合的定义不可以使用 {}，{} 表示的是空字典；由于集合是无序的，因此是不支持下标索引访问的
s2 = set()
print(s2)  # set()
print(type(s2))

# =======================================================

# 集合常见方法
# add(..)：添加元素到集合中
s1.add("OP")
print(s1)

# remove(..)：移除集合中的指定元素（指定元素不存在将报错）
s1.remove("OP")
print(s1)

# pop() 随机删除集合中的元素并返回
e = s1.pop()
print(e)
print(s1)

# clear() 清空集合
s1.clear()
print(s1)

s3 = {"A", "D", "C", "B", "W", "M"}
s4 = {"D", "F", "I", "W"}
# difference() 求取两个集合的差集（包含在第一个集合但不包含在第二个集合的元素）-- A 有、B 没有 -> "-" 符号
print(s3.difference(s4))
print(s4.difference(s3))

# union() 求取两个集合的并集 -- 两边加起来 -> "|" 符号
print(s3.union(s4))
print(s4.union(s3))

# intersection() 求取两个集合的交集 -- 两边都有 -> "&" 符号
print(s3.intersection(s4))

# =======================================================

# 案例：根据提供的班级学生的选课情况，完成如下需求：
# 1.找出同时选修了法语和艺术的学生
# 2.找出同时选修了所有四门课程的学生
# 3.找出选修了足球，但是没有选修篮球的学生
# 4.统计每一个学生选修的课程数量

# 选修足球学生名单
football_set = {"王林", "曾牛", "徐立国", "遁天", "天运子", "韩立", "厉飞雨", "乌丑", "紫灵"}
# 选修篮球学生名单
basketball_set = {"张铁", "墨居仁", "王林", "姜老道", "曾牛", "王蝉", "韩立", "天运子", "李化元", "厉飞雨", "云露"}
# 选修法语学生名单
french_set = {"许木", "王卓", "十三", "虎咆", "姜老道", "天运子", "红蝶", "厉飞雨", "韩立", "曾牛"}
# 选修艺术学生名单
art_set = {"遁天", "天运子", "韩立", "虎咆", "姜老道", "紫灵"}

# 1.找出同时选修了 法语 和 艺术 的学生
# 方式一：
fa_set = french_set.intersection(art_set)
print(f"同时选修了法语和艺术的学生：{fa_set}")
# 方式二：---> "&" 交集
fa_set2 = french_set & art_set
print(f"同时选修了法语和艺术的学生：{fa_set2}")

# 2.找出同时选修了所有四门课程的学生
all_set = football_set & basketball_set & french_set & art_set
print(f"同时选修了所有四门课程的学生：{all_set}")

# 3.找出选修了足球，但是没有选修篮球的学生
# 方式一：
fb_set = football_set.difference(basketball_set)
print(f"选修了足球，但没有选修篮球的学生：{fb_set}")
# 方式二："-" ---> 差集
fb_set2 = football_set - basketball_set
print(f"选修了足球，但没有选修篮球的学生：{fb_set2}")
# 方式三：集合推导式 ---> 快速构建集合，语法：{要往集合中添加的数据 for s in set if 条件}
fb_set3 = {s for s in football_set if s not in basketball_set}
print(f"选修了足球，但没有选修篮球的学生：{fb_set3}")

# 4.统计每一个学生选修的课程数量
# 4.1 获取到学生名单 "|" ---> 并集
# all_set = football_set.union(basketball_set).union(french_set).union(art_set)
all_set = football_set | basketball_set | french_set | art_set
# 4.2 获取每一个学生选修的课程数量
all_list = [*football_set, *basketball_set, *french_set, *art_set]
for s in all_set:
    print(f"{s}：选修了{all_list.count(s)}门课程")
