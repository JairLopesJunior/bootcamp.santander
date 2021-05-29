package com.project.bootcamp.santander.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket( @Value("${application.description}") String description,
                          @Value("${application.version}") String version ){
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.project.bootcamp.santander.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo(description, version));
    }

    private ApiInfo apiInfo(String description, String version){
        return new ApiInfoBuilder()
                .title("Bootcamp DIO - Santander")
                .description(description)
                .version(version)
                .termsOfServiceUrl("http://swagger.io/terms")
                .contact(contact())
                .build();
    }

    private Contact contact(){
        return new Contact("Jair Lopes Junior", "https://github.com/JairLopesJunior", "jair.lopes@fatec.sp.gov.br");
    }
}
