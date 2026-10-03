# 1.常见数据类型
# type() 获取指定的字面量或变量的类型
print("Python")  # str
print(type("Python"))  # str
print(type(100))  # int
print(type(3.13))  # float
print(type(True))  # bool
print(type(False))  # bool
print(type(None))  # NoneType

num = -100
print(type(num))  # int

# isinstance(数据,类型) --> bool值 -> 判定数据是否是指定的类型，如果是：True，否则：False
print(isinstance(num, int))  # True
print(isinstance(num, float))  # False
print(isinstance(num, bool))  # False

# =======================================================

# 2.字符串
# 2.1 定义字符串的三种方式
# 双引号定义
s1 = "Hello"

# 单引号定义
s2 = 'World'

# 三引号定义（多行字符串）
s3 = """
Hello Deepseek:
    你是最新的模型吗？
    你可以做些什么事情？
"""

print(s1)
print(type(s1))
print(s2)
print(type(s2))
print(s3)
print(type(s3))

# 2.2 转义字符 \' \" \n \t
msg = 'It\'s very good'
print(msg)

msg2 = "It's very good"
print(msg2)

msg3 = "Hello 的意思就是\"您好\""
print(msg3)

msg4 = 'Hello 的意思就是"您好"'
print(msg4)

# \n 换行；\t 相当Tab缩进
print("\t你是最新的模型吗？\n\t你可以做些什么事情？")

# 2.3 字符串拼接
s1 = "人生苦短" "我用 Python" "，OK"
print(s1)

msg1 = "人生苦短"
msg2 = "我用 Python"
print("古人云：" + msg1 + "，" + msg2)

# 案例：
# str(int) ---> 将 int 类型的数字转为字符串
name = "堆雪娃儿"
age = 26
pro = "电子信息科学与技术"
hobby = "Python、Java"
message = "大家好，我是" + name + "，今年" + str(age) + "岁，学习的专业是" + pro + "，爱好" + hobby
print(message)

# 2.4 字符串格式化
# 方式1：%s 占位符
name = "堆雪娃儿"
age = 26
pro = "电子信息科学与技术"
hobby = "Python、Java"
message = "大家好，我是%s，今年%s岁，学习的专业是%s，爱好%s" % (name, age, pro, hobby)
print(message)

# 方式2：f"...{变量名/表达式}..." ---> 推荐方式
name = "堆雪娃儿"
age = 26
pro = "电子信息科学与技术"
hobby = "Python、Java"
message = f"大家好，我是{name}，今年{age}岁，学习的专业是{pro}，爱好{hobby}"
print(message)
