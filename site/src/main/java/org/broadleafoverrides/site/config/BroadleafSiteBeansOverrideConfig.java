package org.broadleafoverrides.site.config;

import org.broadleafcommerce.common.email.service.info.EmailInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:broadleaf-site-beans-override-config.xml")
public class BroadleafSiteBeansOverrideConfig {

    @Bean
    public EmailInfo blForgotPasswordEmailInfo() {
        EmailInfo info = emailInfo();
        info.setSubject("Reset password request");
        info.setEmailTemplate("resetPassword-email");
        return info;
    }
    
    public EmailInfo emailInfo() {
        EmailInfo info = new EmailInfo();
        info.setFromAddress("support@mycompany.com");
        info.setSendAsyncPriority("2");
        info.setSendEmailReliableAsync("false");
        return info;
    }
}
