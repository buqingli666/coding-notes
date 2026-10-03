import requests
from lxml import html

# 定义URL
target_url = "https://www.tiobe.com/tiobe-index/"

# 发送请求
response = requests.request(method="GET", url=target_url)

# 解析html的文本，将其转换为一个文档对象
document = html.fromstring(response.text)

# 解析表头 - xpath语法
th_list = document.xpath('//table[@id="top20"]/thead/tr/th/text()')
print(th_list)

# 解析表格中的数据 - xpath语法
# 获取第一行数据
# td_list = document.xpath("//table/tbody/tr[1]/td/text()")
# print(td_list)

# 获取所有行数据
tr_list = document.xpath('//table[@id="top20"]/tbody/tr')
for tr in tr_list:
    td_list = tr.xpath("./td/text()")
    print(td_list)
