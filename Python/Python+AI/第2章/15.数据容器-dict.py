# 字典 - dict
# 字典：使用键值对 (key:value) 来存储数据，每一个键都对应一个值，通过键（key）可以快速找到对应的值（value）
# 特点：
# (1) 键值对存储、键（key）不能重复（如果重复后面的值会覆盖前面的值）key 有序
# (2) 键（key）必须是不可变类型（str、int、float、tuple）不能是（list、set、dict）
# (3) 可修改（value）

# =======================================================

# 定义字典
# 字典名称 = {key: value, key: value, key: value, ...}
dict1 = {"深度求索": "Deepseek", "智普": "GLM", "字节跳动": "DouBao", "阿里巴巴": "Qwen"}
print(dict1)
print(type(dict1))

# 定义空字典
# 字典名称 = {}
# 字典名称 = dict()
dict2 = {}
dict3 = dict()

# 根据 key 获取 value
# 值 = 字典名称[key]
print(dict1["智普"])

# 根据 key 修改 value
dict1["字节跳动"] = "SeedDance"
print(dict1)

# =======================================================

# 字典常见操作
dict4 = {"深度求索": "Deepseek", "智普": "GLM", "字节跳动": "DouBao", "阿里巴巴": "Qwen"}
print(dict4)

# ==================== 1. 添加 ====================
# 操作：字典名称[key] = value
# 含义：往指定字典中添加key-value键值对
dict4["月之暗面"] = "Kimi"
print("添加后:", dict4)

# ==================== 2. 删除 ====================
# 操作1：字典名称.pop(key)
# 含义1：删除字典中指定的key，并返回该key对应的value
pop_value = dict4.pop("字节跳动")
print("pop删除返回的值:", pop_value)
print("pop删除后:", dict4)

# 操作2：del 字典名称[key]
# 含义2：删除字典中指定的键值对
# 为了演示不报错，我们重新添加再删除
dict4["字节跳动"] = "DouBao"
del dict4["字节跳动"]
print("del删除后:", dict4)

# ==================== 3. 修改 ====================
# 操作：字典名称[key] = value
# 含义：修改字典中指定的key对应的值
dict4["智普"] = "ChatGLM"  # 将原有的GLM修改为ChatGLM
print("修改后:", dict4)

# ==================== 4. 查询 ====================
# 操作1：字典名称[key]
# 含义1：根据key获取value
value1 = dict4["阿里巴巴"]
print("方括号查询 阿里巴巴:", value1)

# 操作2：字典名称.get(key)
# 含义2：根据key获取value
value2 = dict4.get("深度求索")
print("get查询 深度求索:", value2)

# 操作3：字典名称.keys()
# 含义3：获取所有的key
keys = dict4.keys()
print("获取所有的key:", keys)

# 操作4：字典名称.values()
# 含义4：获取所有的value
values = dict4.values()
print("获取所有的value:", values)

# 操作5：字典名称.items()
# 含义5：获取所有的key-value键值对
items = dict4.items()
print("获取所有的键值对:", items)

# ==================== 5. 遍历 ====================
for k in dict4.keys():
    print(f"{k} : {dict4[k]}")
print("---------------------")

for item in dict4.items():
    print(f"{item[0]} : {item[1]}")
print("---------------------")

for k, v in dict4.items():
    print(f"{k} : {v}")

# =======================================================

"""
开发一个购物车管理系统，实现商品信息的添加、修改、删除、查询功能。
系统使用字典结构存储商品数据，通过控制台菜单与用户交互。
具体功能如下：
1. 添加购物车：用户根据提示录入商品名称、以及该商品的价格、数量，保存该商品信息到购物车。
2. 修改购物车：要求用户输入要修改的购物车商品名称，然后再提示输入该商品的价格、数量，输入完成后修改该商品信息。
3. 删除购物车：要求用户输入要删除的购物车名称，根据名称删除购物车中的商品。
4. 查询购物车：将购物车中的商品信息展示出来，格式为："商品名称：xxx，商品价格：xxx，商品数量：xxx"。
5. 退出购物车。
   结构: shopping_cart = {"Meta80": {"price": 6999, "num": 2}, "鼠标": {...}}
"""

shopping_cart = {}
menu = """
########## 购物车系统 ##########
#        1. 添加购物车         #
#        2. 修改购物车         #
#        3. 删除购物车         #
#        4. 查询购物车         #
#        5. 退出购物车         #
##############################
"""
while True:
    print(menu)
    choice = input("请选择要执行的操作(1-5): ")

    match choice:
        case "1":  # 添加购物车
            goods_name = input("请输入商品名称：")
            # 如果商品已经存在购物车中，则不执行添加，提示信息
            if goods_name in shopping_cart:
                print(f"{goods_name}已存在，请重新选择操作！")
                continue

            goods_price = float(input("请输入商品价格："))
            goods_num = int(input("请输入商品数量："))
            shopping_cart[goods_name] = {"price": goods_price, "num": goods_num}
            print(f"{goods_name}已成功添加到购物车～")

        case "2":  # 修改购物车
            goods_name = input("请输入修改的商品名称：")
            # 如果商品不在购物车中，则提示错误信息
            if goods_name not in shopping_cart:
                print(f"{goods_name}不存在，请重新选择操作！")
                continue

            goods_price = float(input("请输入修改的商品价格："))
            goods_num = int(input("请输入修改的商品数量："))
            shopping_cart[goods_name] = {"price": goods_price, "num": goods_num}
            print(f"{goods_name}已成功修改～")

        case "3":  # 删除购物车
            goods_name = input("请输入删除的商品名称：")
            # 如果商品不在购物车中，则提示错误信息
            if goods_name not in shopping_cart:
                print(f"{goods_name}不存在，请重新选择操作！")
                continue
            shopping_cart.pop(goods_name)
            print(f"{goods_name}已成功删除～")

        case "4":  # 查询购物车
            for goods_name in shopping_cart.keys():
                goods_info = shopping_cart[goods_name]
                price = goods_info["price"]
                num = goods_info["num"]
                print(f"商品名称：{goods_name}，商品价格：{price}，商品数量：{num}")

        case "5":  # 退出购物车
            print("Bye...")
            break

        case _:
            print("您输入的操作有误！")
