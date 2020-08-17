package niko.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import niko.config.interceptor.LoginInterceptor;
import niko.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig implements WebMvcConfigurer { // web 框架在执行初始化工作的时候会调用接口方法

    @Autowired
    private ObjectMapper objectMapper;
    // 添加 web 配置, 添加拦截器(根据路径进行拦截)
    // /* 代表一级的路径, 如 /user/*, 可以匹配到 /user/abc, 不能匹配 /user/abc/1
    // /** 代表多级的路径
    // 注意: 静态资源也会被拦截
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 实现用户会话管理的功能
        registry.addInterceptor(new LoginInterceptor(objectMapper)) // 链式方法设计: 当前类型的方法: 返回值就是 this
                .addPathPatterns("/user/**") // 添加要拦截的路径
                .excludePathPatterns("/user/login"); // 排除的路径
    }

    @Bean
    public Map<Integer, Integer> test1() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 100);
        map.put(2, 200);
        return map;
    }

    @Bean
    public Map<Integer, Integer> test2() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(3, 300);
        map.put(4, 400);
        return map;
    }

    @Bean
    public User user1() {
        User u = new User();
        u.setUsername("北郊小比特");
        u.setPassword("123");
        return u;
    }


    @Bean
    public User user2() {
        User u = new User();
        u.setUsername("科大小比特");
        u.setPassword("123");
        return u;
    }
}
