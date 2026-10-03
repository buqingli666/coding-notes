from fastapi import FastAPI
from fastapi.responses import JSONResponse

# 创建 FastAPI 实例
app = FastAPI()


# 定义API接口 ---> 该函数的返回值表示 API接口 的返回的数据 ， 接口访问路径为 / ， 请求方式 GET
@app.get("/")
def root():
    return {"message": "Hello World"}


@app.get("/users")
def get_users():
    data = [
        {"id": 1, "name": "张三"},
        {"id": 2, "name": "李四"},
        {"id": 3, "name": "王五"}
    ]
    return JSONResponse(content=data, media_type="application/json; charset=utf-8")


# 启动服务 ----> uvicorn: Python中的轻量级Web服务器
if __name__ == "__main__":
    import uvicorn

    uvicorn.run(app, host="0.0.0.0", port=8000)
