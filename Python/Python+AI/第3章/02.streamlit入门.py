import streamlit as st

# 页面配置必须在所有其他 Streamlit 命令之前调用
st.set_page_config(
    page_title="My Web App",  # 浏览器标签页标题
    page_icon="/Users/buqingli/Downloads/Image.PNG",  # 浏览器标签页图标（支持Emoji或图片）
    layout="centered",  # 页面布局："centered" (默认) 或 "wide"
    initial_sidebar_state="expanded",  # 侧边栏初始状态："auto", "expanded", "collapsed"
    menu_items={
        'Get Help': 'https://www.extremelycoolapp.com/help',
        'Report a bug': "https://www.extremelycoolapp.com/bug",
        'About': "# 这是一个很酷的应用!"
    }
)

# 标题
st.title("Streamlit Demo", text_alignment="center")
st.header("一级标题")
st.subheader("二级标题")

# 段落文字
st.write("布偶猫被誉为猫界的“仙女”，是许多人心中的理想伴侣。")
st.write("布偶猫非常亲人，喜欢像小狗一样跟在主人身后，甚至能学会“你丢我捡”的游戏。")
st.write("它们安静且包容，对小孩子和其他宠物极具耐心，几乎不会主动伸爪攻击，是理想的家庭伴侣。")

# 图片
st.image("/Users/buqingli/Downloads/Image.PNG")

# 音频
# st.audio()

# 视频
# st.video()

# Logo
st.logo("/Users/buqingli/Downloads/Image.PNG")

# 表格
data = {"姓名": ["王林", "李慕婉", "贝罗", "莫厉海", "石萧", "红蝶", "十三"],
        "学号": ["20230001", "20230002", "20230003", "20230004", "20230005", "20230006", "20230007"],
        "语文": [80, 90, 85, 70, 95, 90, 85],
        "数学": [87, 92, 87, 81, 92, 69, 83],
        "英语": [90, 85, 90, 95, 80, 85, 90],
        "总分": [257, 267, 262, 241, 267, 244, 258]}
st.table(data)

# 输入框
name = st.text_input("请输入您的姓名：")
st.write(f"您输入的姓名为：{name}")

# 密码输入框
password = st.text_input("请输入您的密码：", type="password")
st.write(f"您输入的密码为：{password}")

# 单选按钮
gender = st.radio("请选择您的性别", ["男", "女", "未知"], index=2)
st.write(f"您选择的性别是：{gender}")
