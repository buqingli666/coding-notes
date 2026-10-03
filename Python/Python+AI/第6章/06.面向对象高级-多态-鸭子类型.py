# 鸭子类型(Duck Typing)是指如果它走路像鸭子，叫起来叫鸭子，那么它就是鸭子
# 在鸭子类型中，我们关注的是对象的行为（它有什么方法），而不是对象的类型（它是什么类）
# 提示：鸭子类型的优势是不需要存在继承关系，只要对象有相应的方法就能使用

class Duck:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def swimming(self):  # 启动
        print(f'Duck: {self.age} 岁的 {self.name} 正在游泳...')


class Dog:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def swimming(self):  # 启动
        print(f'Dog: {self.age} 岁的 {self.name} 正在游泳...')


class Pig:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def swimming(self):  # 启动
        print(f'Pig: {self.age} 岁的 {self.name} 正在游泳...')


def go_swimming(duck):
    duck.swimming()


if __name__ == '__main__':
    go_swimming(Dog("旺财", 4))
    go_swimming(Duck("唐老鸭", 2))
    go_swimming(Pig("佩奇", 1))
