package io.github.alderan_smile.JavaTest.config;

import io.github.alderan_smile.JavaTest.JavaTestApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/************************************************************************************************************
 * @author Oliver Consterla Araya                                                                           *
 * @version 202468.1.22                                                                                     *
 * @since 2024                                                                                              *
 ************************************************************************************************************/

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(JavaTestApplication.class);
    }
}
