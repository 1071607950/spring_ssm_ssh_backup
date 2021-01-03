package com.city.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    //专用于登录界面跳转的方法
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        System.out.println("启动成功-----");
        WebMvcConfigurer web=new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                //定义用于访问请求名称一级对应的访问页面名称
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/index.html").setViewName("index");
                registry.addViewController("/main.html").setViewName("dashboard");

            };

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor())
                        .addPathPatterns("/**/*.html")
                        .excludePathPatterns("/","/index.html","/login");
                //,"/**/*.css", "/**/*.js", "/**/*.png", "/**/*.jpg", "/**/*.jpeg", "/**/*.gif", "/**/*.svg", "/**/fonts/*"
            }
        };
        return web;
    }

    @Bean
    public LocaleResolver localeResolver(){
        System.out.println("执行了该方法");
        return new MyLocaleResolver();
    }
}
