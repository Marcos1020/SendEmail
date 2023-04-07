package com.sendEmail.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebMvc
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sendEmail.controller"))
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .tags(new Tag("SEND EMAIL", "Sempre enviará um email quando ocorre um evento"))
                .apiInfo(apiInfo());
    }
    private ApiInfo apiInfo(){
            return new ApiInfoBuilder()
                    .title("EMAIL SENDER")
                    .description("Envio de email para atulização de seus clientes")
                    .version("1.0.0").contact(new Contact("One-Digital", "www.One-Digital.com", "contato@One-Digital.com"))
                    .build();
    }
}


