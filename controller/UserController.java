package niko.controller;

import niko.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

// 当前类型注册实例到容器中, 并且指定为 web 请求的处理类
@Controller
// 可以定义请求相关的配置, 如: 路径, 请求方法等等
@RequestMapping("/user")
public class UserController {

//    @Autowired
    @Resource
    public Map<Integer, Integer> test1;

//    @Autowired
//    @Qualifier("user1")
//    private User user;

    @Resource(name = "user1")
    private User user;

    @RequestMapping("/login")
    @ResponseBody
    public Object login(User user, HttpServletRequest req) {
//        Map<String, String> map = new HashMap<>();
//        map.put("man", "博哥");
//        map.put("tea", "汤神");
//        map.put("方丈", "阿文");
        // 模拟用户登录,在数据库校验用户名密码
        if (!"abc".equals(user.getUsername())) {
            throw new RuntimeException("用户登陆失败");
        }
        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        return user;
    }

    @RequestMapping("/m")
    public String m() {
        return "main.html";
    }

    @RequestMapping("/l1")
    public String l1() {
        // 返回路径 不带 /: 以当前请求路径为相对位置,查找同一级资源
        // 带 /: 会去掉这个当前路径, 以项目的部署路径为相对位置
        // return "forward:login"; 以当前请求路径 /user/l1, 转发到 /user/login
        // return "forward:/login"; 带/, 以项目路径查找 /login
        return "forward:/login"; // 带/, 以项目路径查找 /login
    }

    @RequestMapping("/l2")
    public String l2() {
        return "redirect:/user/login";
    }

    // url 为 rest 风格的请求
    @RequestMapping("/test/{key}") // 路径中使用变量占位符
    @ResponseBody
    public Object test1(@PathVariable("key") Integer k) { // 如果类型不匹配, 抛出异常
        System.out.println("================" + test1.get(k));
        return test1;
    }

    // 请求 GET /user/test2?k1=v1&k2=v2&k3=v3
    @RequestMapping(value = "/test2", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Object test2(@RequestParam String k1, String k2) {
        System.out.println("================" + k1 + ", " + k2);
        return test1;
    }

    @RequestMapping("/test3")
    @ResponseBody
    public Object test3(User user) {
        System.out.println(user);
        return test1;
    }

    @RequestMapping("/test4")
    @ResponseBody
    public Object test4() {
        return null; // 响应体为空
    }

    @RequestMapping("/test5")
    @ResponseBody
    public Object test5() {
        return "ok"; // 返回字符串, 响应数据格式不再是 application/json, 而是 text/plain, 字符串内容
    }

    @RequestMapping("/test6")
    @ResponseBody
    // Http 请求是基于 Servlet 的, Spring 已经生成了 request 和 response 对象, 可以直接在传入参数使用
    // Spring 自动的将对象注入到参数
    public Object test6(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("=============" + req.getParameter("username") + ", " + req.getParameter("password"));
        return null;
    }

    @RequestMapping("/test7")
    @ResponseBody
    // 请求数据类型为 application/json 时, 解析请求体中的 json 字符串为 java 对象
    public Object test7(@RequestBody User user) {
        System.out.println("=============" + user);
        return null;
    }

    // web 开发经常存在的需求:
    // 1. 统一处理异常
    // 2. 统一返回数据格式
    // 3. 统一会话管理(登录的敏感资源权限控制)

    @RequestMapping("/test8")
    @ResponseBody
    public Object test8(@RequestBody User user) {
        throw new RuntimeException("数据库报错了");
    }

}
