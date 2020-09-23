package com.neosofttech.technologies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.spring.web.plugins.Docket;

@EnableSwagger2
@EnableAutoConfiguration
@SpringBootApplication
public class TechnologiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechnologiesApplication.class, args);                
	}
        
        @Bean
        public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
         .apis(RequestHandlerSelectors.basePackage("com.neosofttech.technologies")).build();
        }

}
