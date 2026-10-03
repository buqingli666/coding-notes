print("====== 计算披萨成本 ======")

# 披萨尺寸（半径，厘米）
s_radius = 10  # 小号披萨
m_radius = 15  # 中号披萨
l_radius = 20  # 大号披萨

# 计算面积
small_area = circle_area(s_radius)
medium_area = circle_area(m_radius)
large_area = circle_area(l_radius)

# 成本计算
small_cost = small_area * 0.05
medium_cost = medium_area * 0.05
large_cost = large_area * 0.05

print(f"小披萨面积: {small_area} cm², 成本: {small_cost:.1f} 元")
print(f"中披萨面积: {medium_area} cm², 成本: {medium_cost:.1f} 元")
print(f"大披萨面积: {large_area} cm², 成本: {large_cost:.1f} 元")
