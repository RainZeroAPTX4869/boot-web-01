package com.rain.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

/**
 * Created with IntelliJ IDEA.
 *
 * @author RainZero
 * @date 2021/03/03 13:53
 */
@Configuration
public class WebConfig {

    /*打开矩阵变量功能*/
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper pathHelper = new UrlPathHelper();
                pathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(pathHelper);
            }
        };
    }
}
