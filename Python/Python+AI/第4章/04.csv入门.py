# csv 操作 - 方式一：文件操作的原始方式
# 写入
# with open("./csv_data/01.csv", "w", encoding="utf-8") as f:
#     # 写入表头
#     f.write("姓名,年龄,性别,爱好\n")
#     # 写入数据
#     f.write("张三,18,男,JavaScript\n")
#     f.write("李四,16,男,Python\n")
#     f.write("王五,19,女,Java\n")
#     f.write("赵六,13,女,'Go、PHP'\n")

# 读取
# with open("./csv_data/01.csv", "r", encoding="utf-8") as f:
#     for line in f:
#         print(line.strip())

# csv 操作 - 方式二：csv（推荐方式）
import csv

# 写入
with open("./csv_data/02.csv", "w", encoding="utf-8") as f:
    writer = csv.DictWriter(f, fieldnames=["姓名", "年龄", "性别", "爱好"])
    # 写入表头
    writer.writeheader()
    # 写入数据
    writer.writerow({"姓名": "张三", "年龄": 18, "性别": "男", "爱好": "JavaScript"})
    writer.writerow({"姓名": "李四", "年龄": 16, "性别": "男", "爱好": "Python"})
    writer.writerow({"姓名": "王五", "年龄": 19, "性别": "女", "爱好": "Java"})
    writer.writerow({"姓名": "赵六", "年龄": 13, "性别": "女", "爱好": "Go、PHP"})

# 读取
with open("./csv_data/02.csv", "r", encoding="utf-8") as f:
    reader = csv.DictReader(f)
    for row in reader:
        print(row)
