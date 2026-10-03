# match...case... 模式匹配：工作日程安排
day = input("请输入星期几（1-7）：")
match day:
    case "1":
        print("周一：工作会议日")
    case "2":
        print("周二：学习培训日")
    case "3":
        print("周三：项目开发日")
    case "4":
        print("周四：代码审查日")
    case "5":
        print("周五：总结规划日")
    case "6" | "7":
        print("周末：休息放松日")
    case _:  # "_" 匹配其他所有的情况
        print("输入有误！")

# 案例：基于 match...case...实现一个简易计算器，可以实现 + - * / 运算，用户输入需要运算的两个数以及运算符之后，就可以进行计算
num1 = float(input("请输入第一个数："))
oper = input("请输入运算符号（+ - * /）：")
num2 = float(input("请输入第二个数："))

match oper:
    case "+":
        print(f"{num1} + {num2} = {num1 + num2}")
    case "-":
        print(f"{num1} - {num2} = {num1 - num2}")
    case "*":
        print(f"{num1} * {num2} = {num1 * num2}")
    case "/" if num2 != 0:  # if条件成立，才匹配这个case
        print(f"{num1} / {num2} = {num1 / num2}")
    case _:
        print("操作不支持！")

"""
案例：请你编写一个游戏角色移动控制系统，根据玩家输入的不同指令，控制游戏角色执行相应的动作(输出控制台)
具体规则：
  - 上 / w / W             角色向上移动
  - 下 / s / S              角色向下移动
  - 左 / a / A             角色向左移动
  - 右 / d / D             角色向右移动
  - 跳 / " "(空格)        角色跳跃
  - 攻击 / j / J            角色发动攻击
  - 退出 / esc / ESC    角色退出游戏
"""
oper = input("请输入操作指令: ")
match oper:
    case "w" | "W" | "上":
        print("角色向上移动")
    case "s" | "S" | "下":
        print("角色向下移动")
    case "a" | "A" | "左":
        print("角色向左移动")
    case "d" | "D" | "右":
        print("角色向右移动")
    case " " | "跳":
        print("角色跳跃")
    case "j" | "J" | "攻击":
        print("角色发动攻击")
    case "esc" | "ESC" | "退出":
        print("角色退出游戏")
    case _:
        print("操作不支持！")
