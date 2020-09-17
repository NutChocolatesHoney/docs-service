package com.docs.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${doc.basePath}")
    private String basePath;

    @Value("${doc.title}")
    private String title;

    @Value("${doc.version}")
    private String version;

    @Value("${doc.description}")
    private String description;

    @Bean
    Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("全部接口")
                .apiInfo(apiInfo())
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping(basePath)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.docs.controller"))
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContext());
    }


    @Bean
    UiConfiguration uiConfiguration() {
        return UiConfigurationBuilder.builder()
                .defaultModelExpandDepth(3)
                .defaultModelsExpandDepth(1)
                .displayRequestDuration(true)
                .docExpansion(DocExpansion.NONE)
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .version(version)
                .build();
    }

    private List<? extends SecurityScheme> securitySchemes() {
        List<ApiKey> list = new ArrayList<>();
        ApiKey token = new ApiKey("appToken", "auth-token", "header");
        ApiKey client = new ApiKey("appClient", "client", "header");
        list.add(token);
        list.add(client);
        return list;
    }

    private List<SecurityContext> securityContext() {
        SecurityReference token = new SecurityReference("appToken", new AuthorizationScope[]{new AuthorizationScope("global", "客户端token")});
        SecurityReference client = new SecurityReference("appClient", new AuthorizationScope[]{new AuthorizationScope("global", "客户端client")});
        List<SecurityReference> list = new ArrayList<>();
        list.add(token);
        list.add(client);
        SecurityContext context = SecurityContext.builder().
                securityReferences(list).
                forPaths(PathSelectors.ant("/api/**")).build();
        List<SecurityContext> contexts = new ArrayList<>();
        contexts.add(context);
        return contexts;
    }
}
