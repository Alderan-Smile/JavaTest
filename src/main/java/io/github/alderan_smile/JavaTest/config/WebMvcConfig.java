package io.github.alderan_smile.JavaTest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/************************************************************************************************************
 * @author Oliver Consterla Araya                                                                           *
 * @version 202468.1.20                                                                                     *
 * @since 2024                                                                                              *
 ************************************************************************************************************/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
}
