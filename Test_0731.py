# coding = utf-8
from selenium import webdriver
import time

browser = webdriver.Chrome()
browser.get("http://www.baidu.com")
# link text 定位
browser.find_element_by_link_text("hao123").click()
# Partial link text 定位
browser.find_element_by_partial_link_text("hao").click()
# 百度输入框的定位方式
time.sleep(3)
browser.maximize_window()
time.sleep(2)
# 通过 id 定位
browser.find_element_by_id("kw").send_keys("三十而已")
# 通过 name 定位
browser.find_element_by_name("wd").send_keys("三十而已")
# 通过 tag name 定位
browser.find_element_by_tag_name("input").send_keys("三十而已") # 不成功, 因为 input 太多,不唯一
# 通过 class name 定位
browser.find_element_by_class_name("s_ipt").send_keys("三十而已")
# 通过 css 定位
browser.find_element_by_css_selector("#kw").send_keys("三十而已")
# 通过 xpath 定位
browser.find_element_by_xpath("//*[@id='kw']").send_keys("三十而已")
browser.find_element_by_id("su").click()
time.sleep(3)
browser.quit()
