import os
import json
import streamlit as st
from openai import OpenAI
from datetime import datetime

# 页面配置项
st.set_page_config(
    page_title="AI 智能伴侣🥳",
    page_icon="",
    layout="wide",
    initial_sidebar_state="expanded",
    menu_items={
        'Get Help': 'https://www.extremelycoolapp.com/help',
        'Report a bug': "https://www.extremelycoolapp.com/bug",
        'About': "基于 Streamlit 与大语言模型打造的专属 AI 智能伴侣!"
    }
)


# 生成会话标识函数
def generate_session_name():
    return datetime.now().strftime("%Y%m%d_%H%M%S")


# 保存会话信息函数
def save_session():
    if st.session_state.current_session:
        session_data = {
            "nick_name": st.session_state.nick_name,
            "character": st.session_state.character,
            "current_session": st.session_state.current_session,
            "messages": st.session_state.messages
        }

        # 如果sessions文件夹不存在，则创建
        os.makedirs("./sessions", exist_ok=True)

        # 保存会话数据
        with open(f"./sessions/{st.session_state.current_session}.json", "w", encoding="utf-8") as f:
            json.dump(session_data, f, ensure_ascii=False, indent=4)


# 加载所有会话历史函数
def load_sessions():
    sessions = []
    os.makedirs("./sessions", exist_ok=True)
    file_list = os.listdir("./sessions")
    for file_name in file_list:
        if file_name.endswith(".json") and os.path.isfile(os.path.join("./sessions", file_name)):
            sessions.append(file_name[:-5])  # 去掉 .json

    # 按时间倒序（新的在前），文件名格式是 20260101_124256
    sessions.sort(reverse=True)
    return sessions


# 加载指定会话历史函数
def load_session(session_name):
    try:
        if os.path.exists(f"sessions/{session_name}.json"):
            with open(f"sessions/{session_name}.json", "r", encoding="utf-8") as f:
                # 读取会话数据
                session_data = json.load(f)
                st.session_state.messages = session_data["messages"]
                st.session_state.nick_name = session_data["nick_name"]
                st.session_state.character = session_data["character"]
                st.session_state.current_session = session_name
    except Exception as e:
        st.error(f"加载会话失败! 异常信息：{e}")


# 删除会话信息函数
def delete_session(session_name):
    try:
        if os.path.exists(f"sessions/{session_name}.json"):
            # 删除文件
            os.remove(f"sessions/{session_name}.json")
            # 如果删除的是当前会话, 则需要更新消息列表
            if session_name == st.session_state.current_session:
                st.session_state.messages = []
                st.session_state.current_session = generate_session_name()

    except Exception as e:
        st.error(f"删除会话失败! 异常信息：{e}")


# 标题
st.title("AI 智能伴侣🥳", text_alignment="center")

# 系统提示词
system_prompt = """
        你叫 %s，现在是用户的真实伴侣，请完全代入伴侣角色。：
            规则：
                1. 每次只回1条消息
                2. 禁止任何场景或状态描述性文字
                3. 匹配用户的语言
                4. 回复简短，像微信聊天一样
                5. 有需要的话可以用❤️🌟等emoji表情
                6. 用符合伴侣性格的方式对话
                7. 回复的内容，要充分体现伴侣的性格特征
        伴侣性格：
                - %s
        你必须严格遵守上述规则来回复用户。
    """

# 初始化聊天消息
if "messages" not in st.session_state:
    st.session_state.messages = []
# 初始化昵称
if "nick_name" not in st.session_state:
    st.session_state.nick_name = "小美"
# 初始化性格
if "character" not in st.session_state:
    st.session_state.character = "活泼开朗的东北姑娘"
# 初始化会话标识
if "current_session" not in st.session_state:
    st.session_state.current_session = generate_session_name()

# 展示聊天信息
for message in st.session_state.messages:  # {"role": "user", content: prompt}

    st.chat_message(message["role"]).write(message["content"])
    # if message["role"] == "user":
    #     st.chat_message("user").write(message["content"])
    # else:
    #     st.chat_message("assistant").write(message["content"])

# 创建与AI大模型交互的客户端对象
client = OpenAI(api_key=os.environ.get("API_KEY"), base_url="https://chatapi.weixin.qq.com/openai/v1")

# 侧边栏
with st.sidebar:
    # 会话信息
    st.subheader("会话管理", text_alignment="center")
    if st.button("开启新对话", icon="📝", width="stretch"):
        # 保存当前会话
        save_session()
        # 创建新会话
        if st.session_state.messages:  # 如果聊天信息非空, True; 否则,  False
            st.session_state.messages = []
            st.session_state.current_session = generate_session_name()
            save_session()
            st.rerun()  # 重新运行当前页面

    # 会话历史
    st.text("会话历史：")
    session_list = load_sessions()
    for session in session_list:
        col1, col2 = st.columns([4, 1])
        with col1:
            # 加载会话信息
            # 三元运算符: 如果条件为真, 则返回第一个表达式的值; 否则, 返回第二个表达式的值 --> 语法: 值1 if 条件 else 值2
            if st.button(session, width="stretch", icon="📄", key=f"load_{session}",
                         type="primary" if session == st.session_state.current_session else "secondary"):
                load_session(session)
                st.rerun()

        with col2:
            # 删除会话信息
            if st.button("", width="stretch", icon="❌️", key=f"delete_{session}"):
                delete_session(session)
                st.rerun()

    # 分割线
    st.divider()

    st.subheader("伴侣信息", text_alignment="center")
    nick_name = st.text_input("昵称：", placeholder="请输入昵称", value=st.session_state.nick_name)
    if nick_name:
        st.session_state.nick_name = nick_name
    character = st.text_area("性格：", placeholder="请输入性格", value=st.session_state.character)
    if character:
        st.session_state.character = character

# 消息输入框
prompt = st.chat_input("给 AI 智能伴侣发送消息")
if prompt:  # 字符串会自动转换为布尔值，如果字符串非空，则为True；
    st.chat_message("user").write(prompt)
    print("----------> 调用AI大模型，提示词：", prompt)

    # 保存用户的提示词
    st.session_state.messages.append({"role": "user", "content": prompt})

    response = client.chat.completions.create(
        model="Deepseek-v4-flash",
        messages=[
            {"role": "system", "content": system_prompt % (st.session_state.nick_name, st.session_state.character)},
            *st.session_state.messages
        ],
        stream=True
    )

    # 非流式输出的解析方式
    # print("<---------- 大模型返回的结果：", response.choices[0].message.content)
    # ai_msg = response.choices[0].message.content
    # st.chat_message("assistant").write(ai_msg)

    # 流式输出的解析方式
    # 创建一个空组件
    response_message = st.empty()
    full_response = ""
    for chunk in response:
        # 判断 chunk.choices 是否存在且不为空
        if chunk.choices and chunk.choices[0].delta.content is not None:
            content = chunk.choices[0].delta.content
            full_response += content
            response_message.chat_message("assistant").write(full_response)

    # 保存大模型返回的结果
    st.session_state.messages.append({"role": "assistant", "content": full_response})
    # 保存会话信息
    save_session()
