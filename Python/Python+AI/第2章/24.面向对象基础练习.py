"""
采用面向对象的编程思想，开发一个购物车管理系统，实现商品信息的添加、修改、删除、查询功能。系统使用自定义对象存储商品数据，通过控制台菜单与用户交互。
具体功能如下：
    1. 添加购物车：用户根据提示录入商品名称、以及该商品的价格、数量，保存该商品信息到购物车。
    2. 修改购物车：要求用户输入要修改的购物车商品名称，然后再提示输入该商品的价格、数量，输入完成后修改该商品信息。
    3. 删除购物车：要求用户输入要删除的购物车名称，根据名称删除购物车中的商品。
    4. 查询购物车：将购物车中的商品信息展示出来，格式为："商品名称: xxx, 商品价格: xxx, 商品数量: xxx"。
    5. 退出购物车
"""


# 商品类
class Goods:
    def __init__(self, name, price, num):
        """
        初始化方法
        :param name: 商品名
        :param price: 商品价格
        :param num: 商品数量
        """
        self.name = name
        self.price = price
        self.num = num

    def __str__(self):
        return f"商品名称: {self.name}, 商品价格: {self.price}, 商品数量: {self.num}"

    def update_info(self, price=None, num=None):
        if price is not None:
            self.price = price
        if num is not None:
            self.num = num


# 购物车系统类
class ShoppingCart:
    system_name = "购物车管理系统"
    system_version = "1.0.0"

    def __init__(self):
        self.goods_list = []

    # 1.添加购物车
    def add_goods(self):
        input_name = input("请输入商品名称：")

        for goods in self.goods_list:
            if goods.name == input_name:
                print(f"{input_name} 已存在，不可重复添加！")
                return

        input_price = int(input("请输入商品价格："))
        input_num = int(input("请输入商品数量："))

        # 验证价格和数量是否有效
        if input_price >= 0 and input_num > 0:
            # 创建商品对象并添加到购物车系统
            goods = Goods(input_name, input_price, input_num)
            self.goods_list.append(goods)
            print(f"{input_name} 添加成功～")
        else:
            print("价格和数量必须为非负数!")

    # 2.修改购物车
    def update_goods(self):
        input_name = input("请输入要修改的商品名称：")

        for goods in self.goods_list:
            if goods.name == input_name:
                print(f"当前商品信息：{goods}")

                input_price = int(input("请输入要修改的商品价格："))
                input_num = int(input("请输入要修改的商品数量："))

                if input_price >= 0 and input_num > 0:
                    goods.update_info(price=input_price, num=input_num)
                    print(f"{input_name} 修改成功～")
                    print(f"修改后的商品信息：{goods}")
                    return
                else:
                    print("价格和数量必须为非负数!")
                    return

        print("未找到该商品，修改失败！")

    # 3.删除购物车
    def delete_goods(self):
        input_name = input("请输入要删除的商品名称：")
        for goods in self.goods_list:
            if goods.name == input_name:
                self.goods_list.remove(goods)
                print(f"{input_name} 删除成功～")
                return

        print("未找到该商品，删除失败！")

    # 4.查询购物车
    def list_goods(self):
        if not self.goods_list:
            print("购物车为空!")
            return

        for goods in self.goods_list:
            print(f"{goods}")

    def system_run(self):
        print(f"欢迎使用{ShoppingCart.system_name} V{ShoppingCart.system_version}")

        while True:
            print()
            print("# " * 35)
            print("#       1.添加商品  2.修改商品  3.删除商品  4.查询购物车  5.退出系统       #")
            print("# " * 35)
            print()

            choice = input("请选择要执行的操作，输入1-5: ")

            try:
                match choice:
                    case "1":  # 添加商品
                        self.add_goods()
                    case "2":  # 修改商品
                        self.update_goods()
                    case "3":  # 删除商品
                        self.delete_goods()
                    case "4":  # 查询购物车
                        self.list_goods()
                    case "5":  # 退出系统
                        print("Bye...")
                        break
                    case _:  # 其他情况
                        print("输入错误，请选择1-5之间的菜单功能!")
            except ValueError as e:
                print("输入的数据有问题，请检查后重新输入，错误信息：", e)
            except Exception as e:
                print("程序运行出错，请重新选择，错误信息：", e)


if __name__ == '__main__':
    shopping_cart = ShoppingCart()
    shopping_cart.system_run()
