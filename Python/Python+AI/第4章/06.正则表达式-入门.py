import re

s1 = "18809090000是我的手机号，你记住了吗？我的另一个手机号是18800008888，两个QQ号分别是155998992 和 18809091293821 你记住了吗？"

s2 = "我的手机号是18809090000，你记住了吗？我的另一个手机号是18800008888，两个QQ号分别是155998992 和 18809091293821 你记住了吗？"

# match - 从字符串的开头开始匹配(匹配第一个匹配项) -> Match 对象
# res = re.match(r"1[3-9]\d{9}", s1)
# if res:
#     print(res.group())  # 获取到匹配的结果
#     print(res.span())  # 获取匹配项的索引
#     print(res.start())  # 获取匹配项的开始索引
#     print(res.end())  # 获取匹配项的结束索引
# else:
#     print("没有匹配到！")

# search - 从任意位置开始，搜索第一个匹配项 -> Match 对象
# res = re.search(r"1[3-9]\d{9}", s2)
# if res:
#     print(res.group())
#     print(res.span())
#     print(res.start())
#     print(res.end())
# else:
#     print("没有匹配到！")

# findall - 从任意位置开始，搜索所有匹配项 -> list
res = re.findall(r"1[3-9]\d{9}", s2)
print(res)
