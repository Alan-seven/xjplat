package com.jeesite.modules.config;

import com.jeesite.modules.swagger.config.SwaggerConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@ConditionalOnProperty(
        name = {"web.swagger.enabled"},
        havingValue = "true",
        matchIfMissing = true
)
public class IaplatApiConfig
{
    public IaplatApiConfig() {
    }

    @Bean
    public Docket iaplatApi() {
        String moduleCode = "iaplat";
        String moduleName = "调查评价";
        String basePackage = "com.jeesite.modules.ia.web";
        return SwaggerConfig.docket(moduleCode, moduleName, basePackage).select().apis(RequestHandlerSelectors.basePackage(basePackage)).build();
    }
}
