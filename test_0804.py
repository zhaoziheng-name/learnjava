from selenium import webdriver
import time
import os
from selenium.webdriver.common.action_chains import ActionChains

driver = webdriver.Chrome()
# file_path = 'file:///' + os.path.abspath("D:/比特/测试/测试管理工具/测试管理工具1/selenium/selenium2html/checkbox.html")
# file_path = 'file:///' + os.path.abspath("D:/比特/测试/测试管理工具/测试管理工具1/selenium/selenium2html/frame.html")
file_path = 'file:///' + os.path.abspath("D:/比特/测试/测试管理工具/测试管理工具1/selenium/selenium2html/level_locate.html")
driver.get(file_path)
driver.maximize_window()
# 定位一组元素
# inputs = driver.find_elements_by_tag_name("input")
# time.sleep(6)
# for input in inputs:
#     if input.get_attribute('type') == "checkbox":
#         input.click()

# 先从默认页面跳转到id = f1, 再跳转到 id = f2
# driver.switch_to.frame("f1")
# driver.switch_to.frame("f2")

# driver.find_element_by_id("kw").send_keys("布拉格")
# driver.find_element_by_id("su").click()
# time.sleep(4)
# 定位 click 元素, 跳转到默认页面
# driver.switch_to.default_content()
# driver.switch_to.frame("f1")
# driver.find_element_by_link_text("click").click()
# time.sleep(3)

# 定位 link1
driver.find_element_by_link_text("Link1").click()
time.sleep(4)
# 定位需要鼠标移动到的目标元素
btn = driver.find_element_by_link_text("Another action")
# 将鼠标移动到目标元素
ActionChains(driver).move_to_element(btn).perform()
time.sleep(5)
driver.quit()
