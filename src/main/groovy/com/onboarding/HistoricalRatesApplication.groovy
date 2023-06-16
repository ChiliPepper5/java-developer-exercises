package com.onboarding

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory
import org.springframework.boot.web.support.SpringBootServletInitializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/*
 * TODO: NOTHING! YOU DO NOT NEED TO MODIFY THIS FILE
 */

@Configuration
@SpringBootApplication
class HistoricalRatesApplication extends SpringBootServletInitializer {

    static void main(String[] args) {
        SpringApplication.run(HistoricalRatesApplication, args)
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HistoricalRatesApplication.class)
    }


    @Autowired
    @Bean
    EmbeddedServletContainerFactory servletContainer(@Value('${server.port}') int serverPort,
                                                     @Value('${spring.application.name}') String contextPath) {

        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory()
        factory.setPort(serverPort)
        factory.setContextPath("/${contextPath}")

        return factory
    }

}
