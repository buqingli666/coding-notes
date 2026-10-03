"""
采用面向对象的编程思想，完成教务管理系统的开发。教务管理系统可以管理在校学生的成绩信息，通过控制台菜单与用户交互，具体的功能如下：
    1. 添加学生成绩：根据输入的学生姓名、语文成绩、数学成绩、英语成绩，记录在系统中
        1.1 输入学生姓名、语文成绩、数学成绩、英语成绩
        1.2 检查学生姓名是否已存在，如果学生不存在，再添加（存在则，不添加）
        1.3 验证成绩范围（0-100分）
        1.4 创建学生对象并添加到系统
    2. 修改学生成绩：根据输入的学生姓名，修改对应的学生成绩
        2.1 输入要修改的学生姓名
        2.2 根据姓名查找该学生，显示该生当前成绩信息
        2.3 输入新的语文、数学、英语成绩
        2.4 更新学生成绩数据
    3. 删除学生成绩：根据输入的学生姓名，删除对应的学生成绩
    4. 查询指定学生成绩：根据输入的学生姓名，查找对应的学生成绩，并输出
        4.1 输出格式为："姓名: 张三 | 语文: 85 | 数学: 90 | 英语: 88 | 总分: 263"
    5. 展示全部学生成绩：展示出系统中所有学生的成绩
"""


class Student:
    def __init__(self, name, chinese, math, english):
        self.name = name
        self.chinese = chinese
        self.math = math
        self.english = english

    def __str__(self):
        return f"姓名: {self.name} | 语文: {self.chinese} | 数学: {self.math} | 英语: {self.english} | 总分: {self.chinese + self.math + self.english}"

    # 修改学生成绩
    def update_score(self, chinese=None, math=None, english=None):
        if chinese is not None:
            self.chinese = chinese
        if math is not None:
            self.math = math
        if english is not None:
            self.english = english


class EduManagement:
    system_version = "1.0.0"
    system_name = "教务管理系统"

    def __init__(self):
        # 列表，记录在校学生的成绩信息
        self.student_list = []

    # 添加学生成绩
    def add_student(self):
        name = input("请输入学生姓名：")

        # 检查学生姓名是否已存在
        for student in self.student_list:
            if student.name == name:
                print(f"{student.name} 已存在，添加失败！")
                return

        chinese = int(input("请输入学生语文成绩："))
        math = int(input("请输入学生数学成绩："))
        english = int(input("请输入学生英语："))

        # 验证成绩范围（0 - 100分）
        if 0 <= chinese <= 100 and 0 <= math <= 100 and 0 <= english <= 100:
            # 创建学生对象并添加到系统
            student = Student(name=name, chinese=chinese, math=math, english=english)
            self.student_list.append(student)
            print(f"{name} 成绩信息添加成功！")
        else:
            print("各科成绩范围须在 0 - 100 分之间")

    # 修改学生成绩
    def update_student(self):
        name = input("请输入要修改的学生姓名：")

        # 检查学生姓名是否已存在
        for student in self.student_list:
            if student.name == name:
                print(student)

                chinese = int(input("请输入学生新的语文成绩："))
                math = int(input("请输入学生新的数学成绩："))
                english = int(input("请输入学生新的英语："))

                if 0 <= chinese <= 100 and 0 <= math <= 100 and 0 <= english <= 100:
                    student.update_score(chinese=chinese, math=math, english=english)
                    print(f"{name} 成绩信息修改成功！")
                    print(f"修改后的成绩：{student}")
                    return
                else:
                    print("各科成绩范围须在 0 - 100 分之间")
                    return
        print("未找到该学生，修改失败！")

    # 删除学生成绩
    def delete_student(self):
        name = input("请输入要删除的学生姓名：")

        for student in self.student_list:
            if student.name == name:
                self.student_list.remove(student)
                print(f"{name} 成绩信息删除成功！")
                return
        print("未找到该学生，删除失败！")

    # 查询指定学生成绩
    def query_student(self):
        name = input("请输入要查询的学生姓名：")

        for student in self.student_list:
            if student.name == name:
                print(f"学生信息：{student}")
                return
        print("未找到该学生，查询失败！")

    # 展示全部学生成绩
    def list_student(self):
        # 卫语句：如果列表为空，提示并直接结束函数
        if not self.student_list:
            print("学生成绩信息为空，快去添加吧～")
            return

        for student in self.student_list:
            print(student)

    def sys_run(self):
        print(f"欢迎使用{EduManagement.system_name} V{EduManagement.system_version}")

        while True:
            print()
            print("# # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # #")
            print("# 1.添加学生  2.修改学生  3.删除学生  4.查询指定学生  5.查询所有学生  6.退出系统 #")
            print("# # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # #")
            print()

            choice = input("请输入你要执行的操作(1-6)：")

            try:
                match choice:
                    case "1":
                        self.add_student()
                    case "2":
                        self.update_student()
                    case "3":
                        self.delete_student()
                    case "4":
                        self.query_student()
                    case "5":
                        self.list_student()
                    case "6":
                        print("Bye...")
                        break
                    case _:
                        print("操作有误，请输入对应的操作(1-6)!")
            except ValueError as e:
                print("输入的数据有问题，请检查后重新输入，错误信息：", e)
            except Exception as e:
                print("程序运行出错，请重新选择，错误信息：", e)


if __name__ == '__main__':
    EduManagement = EduManagement()
    EduManagement.sys_run()
