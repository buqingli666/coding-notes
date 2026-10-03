# while循坏：打印10遍“人生苦短，我用Python～”
i = 0
while i < 10:
    print(f"正在打印第{i + 1}遍：人生苦短，我用Python～")
    i += 1
else:
    print("循环正常结束啦")

# while案例：计算1-100之间所有偶数的累加之和
total = 0  # 累加之和
i = 1  # 循环开始的数字
while i <= 100:
    if i % 2 == 0:  # 偶数
        total += i
    i += 1
print(f"1-100的所有偶数的累加和为：{total}")
