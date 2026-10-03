import re
import csv
import time
import random
import requests
from lxml import html

MOVIE_LIST_FILE = "./csv_data/movies_02.csv"
TMDB_BASE_URL = "https://www.themoviedb.org"
# 高分电影榜单URL(第1页)
TMDB_TOP_URL_1 = "https://www.themoviedb.org/movie/top-rated"
# 高分电影榜单URL(第2页之后)
TMDB_TOP_URL_2 = "https://www.themoviedb.org/discover/movie/items"


# 获取电影年份
def get_movie_year(movie_years):
    movie_year = movie_years[0].strip() if movie_years else ""
    return movie_year.strip().strip("()")


# 获取电影上映时间
def get_movie_publish_date(movie_dates):
    movie_date = movie_dates[0].strip() if movie_dates else ""  # 2026-08-25 (US)
    res = re.search(r"\d{4}-\d{2}-\d{2}", movie_date)
    return res.group() if res else ""


# 获取电影时长 (统一转换为分钟, 如: 2h 20m --> 140)
def get_movie_cost_time(movie_cost_times):
    movie_cost_time = movie_cost_times[0].strip() if movie_cost_times else ""
    h_match = re.search(r"(\d+)\s*h", movie_cost_time)
    m_match = re.search(r"(\d+)\s*m", movie_cost_time)
    hours = int(h_match.group(1)) if h_match else 0
    minutes = int(m_match.group(1)) if m_match else 0
    return hours * 60 + minutes


# 保存电影数据到 csv 文件
def save_movie_info(all_movies):
    with open(MOVIE_LIST_FILE, "w", encoding="utf-8") as f:
        writer = csv.DictWriter(f, fieldnames=["电影名称", "年份", "上映时间", "类型", "时长", "评分", "语言", "导演",
                                               "作者", "主演", "宣传语", "简介"])
        writer.writeheader()
        writer.writerows(all_movies)


# 获取电影详情
def get_movie_info(movie_info_url):
    # 1.发送请求
    movie_response = requests.request(method="GET", url=movie_info_url, timeout=30)
    print(f"正在请求：{movie_info_url}, 获取电影详情数据 ...")

    # 2.解析数据
    movie_doc = html.fromstring(movie_response.text)
    # 电影名称
    movie_names = movie_doc.xpath("//div[contains(@class,'title')]/h2/a/text()")
    # 电影年份
    movie_years = movie_doc.xpath("//div[contains(@class,'title')]//span[contains(@class,'release_date')]/text()")
    # 上映时间
    movie_dates = movie_doc.xpath("//span[@class='release']/text()")
    # 类型
    movie_tags = movie_doc.xpath("//span[@class='genres']/a/text()")
    # 时长
    movie_cost_times = movie_doc.xpath("//span[@class='runtime']/text()")
    # 评分
    movie_scores = movie_doc.xpath("//div[@class='user_score_chart']/@data-percent")
    # 语言
    movie_languages = movie_doc.xpath("//p[.//bdi[contains(text(),'默认语言')]]/text()")
    # 导演
    movie_director = movie_doc.xpath("//li[.//p[@class='character'][contains(text(),'Director')]]/p[1]/a/text()")
    # 作者
    movie_authors = movie_doc.xpath("//li[.//p[@class='character'][contains(text(),'Screenplay')]]/p[1]/a/text()")
    # 主演
    movie_directors = movie_doc.xpath("//ol[@class='people scroller']/li[@class='card']/p/a/text()")
    # 宣传语
    movie_slogans = movie_doc.xpath("//h3[@class='tagline']/text()")
    # 简介
    movie_descriptions = movie_doc.xpath("//div[@class='overview']/p/text()")

    # 3.返回详情 - 字典类型
    movie_info = {
        "电影名称": movie_names[0].strip() if movie_names else "",
        "年份": get_movie_year(movie_years),
        "上映时间": get_movie_publish_date(movie_dates),
        "类型": "、".join(t.strip() for t in movie_tags) if movie_tags else "",
        "时长": get_movie_cost_time(movie_cost_times),
        "评分": movie_scores[0].strip() if movie_scores else "",
        "语言": movie_languages[0].strip() if movie_languages else "",
        "导演": "、".join(d.strip() for d in movie_director) if movie_director else "",
        "作者": "、".join(a.strip() for a in movie_authors) if movie_authors else "",
        "主演": "、".join(s.strip() for s in movie_directors) if movie_directors else "",
        "宣传语": movie_slogans[0].strip() if movie_slogans else "",
        "简介": movie_descriptions[0].strip() if movie_descriptions else "",
    }
    return movie_info


# 主函数，定义核心逻辑
def main():
    all_movies = []

    # 循环获取电影列表(第1页到第15页)
    for page_number in range(1, 16):
        if page_number == 1:
            # 1. 发送请求，获取高分电影榜单数据
            response = requests.request(method="GET", url=TMDB_TOP_URL_1, timeout=30)
            print(f"正在请求访问第 {page_number} 页的数据, 获取 TMDB 电影榜单数据 ...")
        else:
            # 随机休眠 2 到 4 秒
            time.sleep(random.uniform(2, 4))
            response = requests.request(method="POST", url=TMDB_TOP_URL_2,
                                        data=f"air_date.gte=&air_date.lte=&certification=&certification_country=CN&debug=&first_air_date.gte=&first_air_date.lte=&include_adult=false&latest_ceremony.gte=&latest_ceremony.lte=&page={page_number}&primary_release_date.gte=&primary_release_date.lte=&region=&release_date.gte=&release_date.lte=2026-07-31&show_me=everything&sort_by=vote_average.desc&vote_average.gte=0&vote_average.lte=10&vote_count.gte=300&watch_region=CN&with_genres=&with_keywords=&with_networks=&with_origin_country=&with_original_language=&with_watch_monetization_types=&with_watch_providers=&with_release_type=&with_runtime.gte=0&with_runtime.lte=400",
                                        timeout=30)
            print(f"正在请求访问第 {page_number} 页的数据, 获取 TMDB 电影榜单数据 ...")

        # 2. 解析数据
        document = html.fromstring(response.text)
        movie_url_list = document.xpath("//div[@id='media-list']//a[h2]/@href")

        # 3. 获取电影详情
        for url in movie_url_list:
            # 电影详情 url
            movie_info_url = TMDB_BASE_URL + url
            # 随机休眠 1 到 3 秒
            time.sleep(random.uniform(1, 3))
            # 发送请求，获取电影详情数据
            movie_info = get_movie_info(movie_info_url)
            all_movies.append(movie_info)

    # 4. 保存数据，保存为 csv 文件
    print("已获取所有电影详情, 正在保存数据到CSV文件中 ...")
    save_movie_info(all_movies)


if __name__ == '__main__':
    main()
