# 异常处理
try:
    print("====================")
    # print(my_name)
    # print(1 / 0)
    # print("ABC"[10])
    # print("ABC".hello)
    print("====================")
except NameError as e:  # 捕获的是 NameError 类型的异常
    print("名称不存在，请检查，具体信息：", e)
except ZeroDivisionError as e:
    print("0不能做被除数，请检查，具体信息：", e)
except IndexError as e:
    print("索引错误，请检查，具体信息：", e)
except Exception as e:
    print("其他错误，请检查，具体信息：", e)
finally:  # 无论程序是否正常运行，finally 代码块中的代码都会运行
    print("无论正常执行还是出现异常， 都要释放资源 ~")


# =======================================================

# 异常的传递
def fun1():
    print("fun1...running...")
    fun2()


def fun2():
    print("fun2...running...")
    fun3()


def fun3():
    print("fun3...running...")
    print(my_phone)


if __name__ == '__main__':
    try:
        fun1()
    except Exception as e:
        print("程序出错了，错误信息：", e)
