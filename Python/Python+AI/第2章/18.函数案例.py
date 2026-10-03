# 1.定义一个函数：根据传入的底和高计算三角形面积的函数（三角形面积 = 底 * 高 / 2）
def triangle_area(base, height):
    """
    根据三角形的底和高计算三角形面积
    :param base: 底长
    :param height: 高
    :return: 三角形面积
    """
    return base * height / 2


triangle_area = triangle_area(10, 5)
print(f"三角形的面积为：{triangle_area}")


# 2.定义一个函数：计算传入的字符串中元音字母的个数（元音字母为 aeiouAEIOU）
def count_vowels(s):
    """
    计算传入的字符串中元音字母的个数
    :param s: 字符串
    :return: 元音字母的个数
    """
    vowels = ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U']
    count = 0
    for char in s:
        if char in vowels:
            count += 1
    return count


num = count_vowels("Hello World Hello Python OK Apple")
print(f"元音字母的个数：{num}个")


# 3.定义一个函数：计算传入的班级学员高考成绩列表中成绩的最高分、最低分、平均分(保留1位小数)，并返回
def analyze_scores(score_list):
    """
    计算成绩列表中成绩的最高分、最低分、平均分(保留1位小数)
    :param score_list: 分数列表
    :return: 最高分，最低分，平均分
    """
    max_score = max(score_list)
    min_score = min(score_list)
    avg_score = round(sum(score_list) / len(score_list), 1)
    return max_score, min_score, avg_score


scores = [666, 435, 538, 432, 689, 321]
max_s, min_s, avg_s = analyze_scores(scores)
print(f"最高分：{max_s}, 最低分：{min_s}, 平均分：{avg_s}")


# 需求1：定义一个函数，根据传入的分数，计算对应的分数等级并返回
# - 分数 >= 90：A
# - 分数 >= 75：B
# - 分数 >= 60：C
# - 分数 <  60：D
def get_grade(score):
    """
    根据传入的分数，计算对应的分数等级
    :param score: 分数
    :return: 分数等级
    """
    if score >= 90:
        return "A"
    elif score >= 75:
        return "B"
    elif score >= 60:
        return "C"
    else:
        return "D"


print(get_grade(98))
print(get_grade(86))
print(get_grade(63))
print(get_grade(55))


# 需求2：定义一个函数，用于判断一个字符串是否是回文串，返回bool值
# 把字符串反转，如果和原字符串相同，就是回文串。（如："level"，"radar"，"黄山落叶松叶落山黄"）
def is_palindrome(text):
    """
    判断一个字符串是否是回文串
    :param text: 字符串
    :return: True/False
    """
    print(text[::-1])
    return text == text[::-1]


print(is_palindrome("level"))
print(is_palindrome("admin"))


# 需求3：定义一个函数：完成时间转换功能，将传入的秒转换为小时、分钟、秒
def seconds_to_hms(total_seconds):
    """
    将秒转换为小时、分钟、秒
    :param total_seconds: 秒
    :return: 小时，分钟，秒
    """
    # 小时
    hours = total_seconds // 3600
    # 分钟
    minutes = (total_seconds % 3600) // 60
    # 秒
    seconds = (total_seconds % 3600) % 60
    return hours, minutes, seconds


shi, fen, miao = seconds_to_hms(8008)
print(f"{shi}时{fen}分{miao}秒")


# 需求4：定义一个函数：根据传入的三角形三个边的边长，判定三角形的类型（等边、等腰、普通，或者不能构成三角形）
def get_triangle_type(a, b, c):
    if a + b > c and b + c > a and c + a > b:
        if a == b and b == c:
            return "等边三角形"
        elif a == b or b == c or a == c:
            return "等腰三角形"
        else:
            return "普通三角形"
    else:
        return "不能构成三角形"


print(get_triangle_type(3, 4, 5))
print(get_triangle_type(3, 3, 5))
print(get_triangle_type(3, 4, 7))
print(get_triangle_type(8, 8, 8))
