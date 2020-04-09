package com.higo.learning.config;

import com.higo.learning.services.DBService;
import com.higo.learning.services.EmailService;
import com.higo.learning.services.SmtpEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class ProdConfig {

    @Autowired
    private DBService dbService;

    @Bean
    public EmailService emailService() {
        return new SmtpEmailService();
    }


}
