from selenium import webdriver
import time
import os

driver = webdriver.Chrome()
file_path = 'file:///' + os.path.abspath("D:/比特/测试/测试管理工具/测试管理工具1/selenium/selenium2html/drop_down.html")
file_path = 'file:///' + os.path.abspath("D:/比特/测试/测试管理工具/测试管理工具1/selenium/selenium2html/alert.html")
file_path = 'file:///' + os.path.abspath("D:/比特/测试/测试管理工具/测试管理工具1/selenium/selenium2html/modal.html")
file_path = 'file:///' + os.path.abspath("D:/比特/测试/测试管理工具/测试管理工具1/selenium/selenium2html/upload.html")
driver.get(file_path)
driver.maximize_window()
time.sleep(3)

# xpath 定位
driver.find_element_by_xpath("//*[@id='ShippingMethod']/option[4]").click()

# 用 option 定位
lists = driver.find_elements_by_tag_name("option")
for list in lists:
    if list.get_attribute("value") == '9.03':
        list.click()

# 用数组定位(更简便)
lists = driver.find_elements_by_tag_name("option")
lists[3].click()

# 定位点击按钮
driver.find_element_by_id("tooltip").click()
time.sleep(4)
# 得到操作 alert 弹出框的句柄
alert = driver.switch_to.alert
# 输出弹出框的内容
text = alert.text
print("text = " + text)
time.sleep(3)
# 关闭 alert 窗口
alert.accept()

# 点击 click
driver.find_element_by_id("show_modal").click()
time.sleep(5)

# 定位 modal-body
div1 = driver.find_element_by_class_name("modal-body")
driver.find_element_by_link_text("click me").click()
time.sleep(3)

# 定位 modal-footer
div2 = driver.find_element_by_class_name("modal-footer")
buttons = div2.find_elements_by_tag_name("button")
buttons[0].click()

# 定位上传文件按钮
driver.find_element_by_tag_name("input").send_keys("D:/1111MyString.TXT")

time.sleep(5)
driver.quit()
