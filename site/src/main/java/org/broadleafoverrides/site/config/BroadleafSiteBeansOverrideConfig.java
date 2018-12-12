package org.broadleafoverrides.site.config;

import org.broadleafcommerce.common.email.service.info.EmailInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.community.core.config.CoreEmailConfig;

@Configuration
@ImportResource("classpath:broadleaf-site-beans-override-config.xml")
public class BroadleafSiteBeansOverrideConfig {

    @Bean
    public EmailInfo blForgotPasswordEmailInfo() {
    	EmailInfo info = CoreEmailConfig.generalEmailInfo();
        info.setSubject("Reset password request");
        info.setEmailTemplate("resetPassword-email");
        return info;
    }
    
    @Bean
    public EmailInfo blRegistrationEmailInfo() {
    	EmailInfo info = CoreEmailConfig.generalEmailInfo();
        info.setSubject("You have successfully registered!");
        info.setEmailTemplate("register-email");
        return info;
    }
}
