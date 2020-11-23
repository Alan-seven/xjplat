package com.jeesite.modules;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients(basePackages = {"com.jeesite.modules"})
public class IAPLATApplication extends SpringBootServletInitializer
{
    public static void main(String[] args) { SpringApplication.run(IAPLATApplication.class, args); }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        setRegisterErrorPageFilter(false);
        return builder.sources(new Class[] { IAPLATApplication.class });
    }
}
