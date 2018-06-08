package com.community;

import org.broadleafcommerce.common.config.EnableBroadleafSiteAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import com.mycompany.context.HCApplicationEventListener;

@SpringBootApplication
@EnableAutoConfiguration
public class SiteApplication {

    @Configuration
    @EnableBroadleafSiteAutoConfiguration
    public static class BroadleafFrameworkConfiguration {}
    
    public static void main(String[] args) {
    	SpringApplication app = new SpringApplication(SiteApplication.class); 
        app.addListeners(new HCApplicationEventListener());
        app.run(args);
    }
    
}
