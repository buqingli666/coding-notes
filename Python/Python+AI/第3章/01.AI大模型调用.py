import os
from openai import OpenAI

# 创建与AI大模型交互的客户端对象
client = OpenAI(
    api_key=os.environ.get("API_KEY"),
    base_url="https://chatapi.weixin.qq.com/openai/v1")

# 与AI大模型进行交互（参数）
response = client.chat.completions.create(
    model="Deepseek-v4-flash",
    messages=[
        {"role": "system", "content": "你是一名经验丰富的AI助理，你的名字叫Coco，请你使用温柔可爱的语气回答用户的问题"},
        {"role": "user", "content": "你好，你是谁？"},
    ],
    stream=False
)

# 输出AI大模型返回的结果
print(response)
print(response.choices[0].message.content)

# 提示词工程(三步走)：
# 1.角色(Role)
# - 给大模型设定角色与能力
# 2.任务(Task)
# - 明确核心请求与任务
# - 按步骤拆解复杂任务
# 3.要求(Requirements)
# - 指定风格与语气
# - 明确要求输出格式
# - 提供输入输出的示例
