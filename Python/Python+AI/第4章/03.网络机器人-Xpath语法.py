import requests
from lxml import html

# 定义URL
target_url = "https://www.tiobe.com/tiobe-index/"

# 发送请求
response = requests.request(method="GET", url=target_url)

# 解析html的文本，将其转换为一个文档对象
document = html.fromstring(response.text)

# /               : 从根节点的直接子元素           | 样例: /html/body/div/h1
# //              : 从任意位置选择节点             | 样例: //h1
# .               : 当前节点下查找                | 样例: ./a 与 .//a
# [n]             : 选择第n个元素                 | 样例: //p[2]
# [last()]        : 选择最后一个元素               | 样例: //p[last()]
# [@attr]         : 选择有该属性的元素             | 样例: //p[@color]
# [@attr='value'] : 选择该属性值等于指定值的元素     | 样例: //p[@color='red']
# *               : 匹配任何元素节点               | 样例: //body/div/*
# @*              : 匹配元素的任何属性             | 样例: //body/div/a/@*
# text()          : 获取文本内容                  | 样例: //div/p/text()

th_list = document.xpath("//table[@id='top20']/thead/tr/th/text()")
print(th_list)

td_list = document.xpath('//table[@id="top20"]/tbody/tr[1]/td/text()')
print(td_list)

td_list = document.xpath('//table[@id="top20"]/tbody/tr[last()]/td/text()')
print(td_list)

td_list = document.xpath('//table[@id="top20"]/tbody/tr[last()-1]/td/text()')
print(td_list)

img_list = document.xpath("//td/img/@src")
print(img_list)
