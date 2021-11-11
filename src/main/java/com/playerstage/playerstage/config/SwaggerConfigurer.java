package com.playerstage.playerstage.config;

import io.swagger.annotations.Api;
import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.HttpAuthenticationScheme;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfigurer {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
            .apiInfo(
                new ApiInfoBuilder()
                    .title("PlayerStage API")
                    .description("PlayerStage API Document")
                    .version("1.0.0")
                    .build()
            )
            .securitySchemes(
                Collections.singletonList(HttpAuthenticationScheme.JWT_BEARER_BUILDER
                    .name("JWT")
                    .build()
                )
            )
            .securityContexts(
                Collections.singletonList(
                    SecurityContext.builder()
                    .securityReferences(Collections.singletonList(SecurityReference.builder()
                            .scopes(new AuthorizationScope[0])
                            .reference("JWT")
                            .build()))
                    // only for which need authentication
                    .operationSelector(o -> o.findAnnotation(PreAuthorize.class).isPresent())
                    .build()
                )
            )
            .select()
            .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
            .paths(PathSelectors.any())
            .build();
    }

}