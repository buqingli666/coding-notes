import requests
from lxml import html

# 定义URL
target_url = "https://www.tiobe.com/tiobe-index/"

# 发送请求
response = requests.request(method="GET", url=target_url)

# 输出数据
# print(response.text)
document = html.fromstring(response.text)

# 解析表头内容
th_list = document.xpath("//*[@id='top20']/thead/tr/th/text()")
print(th_list)

# 解析表格内容
tr_list = document.xpath("//*[@id='top20']/tbody/tr")
for tr in tr_list:
    td_list = tr.xpath("./td/text()")
    print(td_list)
