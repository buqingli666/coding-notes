# 1.导入模块 -> 调用方式：模块名.功能名/别名.功能名

# import 模块名
import random

random.randint(10, 100)

# import 模块名 as 别名
import random as rd

rd.randint(10, 100)

# 2.导入模块中的功能 -> 调用方式：功能名/别名

# from 模块名 import 功能名
from random import randint

randint(10, 100)

# from 模块名 import 功能名 as 别名
from random import randint as rnt

rnt(10, 100)

# from 模块名 import *
from random import *

randint(10, 100)
