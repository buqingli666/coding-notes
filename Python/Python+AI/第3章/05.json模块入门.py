import json

# 写入json文件
user = {
    "name": "小咘",
    "age": 3,
    "gender": "男",
    "hobbies": ["reading", "swimming"]
}

with open("./resources/user.json", "w", encoding="utf-8") as f:
    # ensure_ascii：默认True，所有非ASCII字符（比如中文）会被转义成 \uXXXX 形式，设置为 False 后，中文等字符会原样保留，输出更易读
    # indent：指定缩进空格数，让输出的 JSON 格式化、有换行和缩进，方便阅读
    json.dump(user, f, ensure_ascii=False, indent=4)

# 读取json文件
# with open("./resources/user.json", "r", encoding="utf-8") as f:
#     user = json.load(f)
#     print(user)
#     print(type(user))
