# 路径写法:
# 相对路径: 相对于当前工作目录的路径
# ./ -->当前目录
# ../ --> 上一级目录
# 绝对路径: 从文件系统的目录开始, 完整描述文件位置的路径
# /Users/buqingli/PycharmProjects/Python/第3章/resources/望庐山瀑布.txt


# 文件操作模式:
# 'r' (默认): 只读模式。指针在文件开头。
# 'w': 写入模式。从头编辑，原有内容会被清空；文件不存在则创建
# 'a': 追加模式。新内容追加在原有内容之后；文件不存在则创建

with open("./resources/望庐山瀑布.txt", "r", encoding="utf-8") as f:
    content = f.read()
    print(content)

with open("./resources/静夜思.txt", "a", encoding="utf-8") as f:
    f.write("---- append ----\n")
