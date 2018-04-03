package at.kuchel.config;

import at.kuchel.Context;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("kuchel-api")
                .select()
                .apis(RequestHandlerSelectors.basePackage("at.kuchel.controller.rest"))
                .paths(PathSelectors.ant(Context.REST_API + "**"))
                .build()
                .apiInfo(createApiInfo());
    }

    private ApiInfo createApiInfo() {
        return new ApiInfoBuilder()
                .title("Kuchel REST API Reference")
                .description("The REST API uses HTTP verbs and a RESTful endpoint structure. HTTP Basic authentication is used to enforce access controls. Request and response payloads are formatted as JSON. Uses standardized HTTP status codes for results.")
                .version("1.0")
                .build();
    }
}
