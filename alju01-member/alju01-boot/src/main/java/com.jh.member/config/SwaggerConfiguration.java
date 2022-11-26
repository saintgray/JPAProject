package com.jh.member.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 오종현
 * @version 1.0.0
 * @since "${date}"
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Value("${swagger.title}")
    private String title;
    @Value("${swagger.description}")
    private String description;
    @Value("${swagger.basePackage}")
    private String basePackage;
    @Value("${swagger.termsOfServiceUrl}")
    private String termsOfServiceUrl;


    public Docket api(){
        System.out.println("=================  swagger Docket initiated  =================");
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(this.basePackage))
                .paths(PathSelectors.any())
                .build()
                .apiInfo( this.apiInfo() );
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title( this.title)
                .description(this.description)
                .termsOfServiceUrl(this.termsOfServiceUrl)
                .build();
    }


}
