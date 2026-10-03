# 数据容器总结与对比
# 字符串 str = ""
# 有序 | 允许重复 | 不可变 | 支持索引 | 支持切片 | 文本处理

# 列表 list = []
# 有序 | 允许重复 | 可变 | 支持索引 | 支持切片 | 有序可重复数据集合

# 元组 tuple = ()
# 有序 | 允许重复 | 不可变 | 支持索引 | 支持切片 | 固定数据记录

# 集合 set = {}
# 无序 | 不允许重复 | 可变 | 不支持索引 | 不支持切片 | 去重数据集合

# 字典 dict = {key : value}
# 有序(3.7+) | key不允许重复 | 可变 | 不支持索引 | 不支持切片 | 键值对

# =======================================================

"""
    案例:
    开发一个教务管理系统，在该系统中可以维护和管理学员的成绩信息，具体需求如下：
        1. 添加学生信息：根据提示录入学生姓名、语文、数学、英语成绩，录入完成保存到系统中。
        2. 修改学生信息：要求输入要修改的学生姓名，然后再提示输入语文、数学、英语成绩，输入完成后修改学员信息。
        3. 删除学生信息：要求输入要删除的学生姓名，根据姓名删除学生信息。
        4. 查询学生信息：要求输入要查询的学生姓名，根据姓名查询学生信息并输出。
        5. 列出所有学生：遍历所有学生信息并输出。
        6. 统计班级成绩：统计班级语文、数学、英语成绩的最高分、最低分、平均分，以及语文、数学、英语最高分和最低分的学员姓名。
        7. 退出系统。
"""
menu = """
# # # # # # # # # # # # # # # # # # # # # # # # # # 【菜单】 # # # # # # # # # # # # # # # # # # # # # # # # # # # #
#  1. 添加学生信息   2. 修改学生信息   3. 删除学生信息   4. 查询学生信息   5. 列出所有学生   6. 统计班级成绩   7. 退出系统     #
# # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # #
"""
print("欢迎使用教务管理系统 ~")

# 存储的数据格式：student_scores = {"张三" : {"chinese" : "98.0", "math" : "88.8", "english" : "86.3"}}
student_scores = {}

while True:
    print(menu)

    choice = input("请输入要执行的操作（1-7）：")

    match choice:
        case "1":  # 添加学生信息
            name = input("请输入学生姓名：")

            if name in student_scores:
                print(f"{name}已经存在，请重新选择对应操作！")
                continue

            chinese_score = float(input("请输入语文成绩："))
            math_score = float(input("请输入数学成绩："))
            english_score = float(input("请输入英语成绩："))

            student_scores[name] = {"chinese": chinese_score, "math": math_score, "english": english_score}
            print(f"{name}成绩信息保存成功～")
        case "2":  # 修改学生信息
            name = input("请输入要修改的学生姓名：")

            if name not in student_scores:
                print(f"{name}不存在，请重新选择对应操作！")
                continue

            chinese_score = float(input("请输入要修改的语文成绩："))
            math_score = float(input("请输入要修改的数学成绩："))
            english_score = float(input("请输入要修改的英语成绩："))

            student_scores[name] = {"chinese": chinese_score, "math": math_score, "english": english_score}
            print(f"{name}成绩信息修改成功～")
        case "3":  # 删除学生信息
            name = input("请输入要删除的学生姓名：")

            if name not in student_scores:
                print(f"{name}不存在，请重新选择对应操作！")
            else:
                del student_scores[name]
                print(f"{name}成绩信息删除成功～")
        case "4":  # 查询学生信息
            name = input("请输入要查询的学生姓名：")

            if name not in student_scores:
                print(f"{name}不存在，请重新选择对应操作！")
            else:
                student_info = student_scores[name]
                chinese_score = student_info["chinese"]
                math_score = student_info["math"]
                english_score = student_info["english"]

                print(f"学生姓名：{name}，语文成绩：{chinese_score}，数学成绩：{math_score}，英语成绩：{english_score}")
        case "5":  # 列出所有学生
            for name in student_scores.keys():
                student_info = student_scores[name]
                chinese_score = student_info["chinese"]
                math_score = student_info["math"]
                english_score = student_info["english"]

                print(f"学生姓名：{name}，语文成绩：{chinese_score}，数学成绩：{math_score}，英语成绩：{english_score}")
        case "6":  # 统计班级成绩
            if not student_scores:
                print("系统中暂无学生信息，请先添加学生!")
                continue

            score_chinese = []
            score_math = []
            score_english = []

            for name, scores in student_scores.items():
                score_chinese.append(scores["chinese"])
                score_math.append(scores["math"])
                score_english.append(scores["english"])

            # 语文
            chinese_max = max(score_chinese)
            chinese_min = min(score_chinese)
            chinese_avg = sum(score_chinese) / len(score_chinese)
            chinese_max_students = [name for name, scores in student_scores.items() if scores['chinese'] == chinese_max]
            chinese_min_students = [name for name, scores in student_scores.items() if scores['chinese'] == chinese_min]

            # 数学
            math_max = max(score_math)
            math_min = min(score_math)
            math_avg = sum(score_math) / len(score_math)
            math_max_students = [name for name, scores in student_scores.items() if scores['math'] == math_max]
            math_min_students = [name for name, scores in student_scores.items() if scores['math'] == math_min]

            # 英语
            english_max = max(score_english)
            english_min = min(score_english)
            english_avg = sum(score_english) / len(score_english)
            english_max_students = [name for name, scores in student_scores.items() if scores['english'] == english_max]
            english_min_students = [name for name, scores in student_scores.items() if scores['english'] == english_min]

            print(
                f"语文最高分：{chinese_max}，"
                f"最低分：{chinese_min}，"
                f"平均分：{chinese_avg:.2f}，"
                f"最高分学生：{'、'.join(chinese_max_students)}，"
                f"最低分学生：{'、'.join(chinese_min_students)}")

            print(f"数学最高分：{math_max}，"
                  f"最低分：{math_min}，"
                  f"平均分：{math_avg:.2f}，"
                  f"最高分学生：{'、'.join(math_max_students)}，"
                  f"最低分学生：{'、'.join(math_min_students)}")

            print(
                f"英语最高分：{english_max}，"
                f"最低分：{english_min}，"
                f"平均分：{english_avg:.2f}，"
                f"最高分学生：{'、'.join(english_max_students)}，"
                f"最低分学生：{'、'.join(english_min_students)}")

        case "7":  # 退出系统
            print("Bye...")
            break
        case _:
            print("操作有误，请重新输入！")
