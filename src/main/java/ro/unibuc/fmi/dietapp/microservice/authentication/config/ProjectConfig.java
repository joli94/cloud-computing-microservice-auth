package ro.unibuc.fmi.dietapp.microservice.authentication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.unibuc.fmi.dietapp.microservice.authentication.mapper.LoginMapper;
import ro.unibuc.fmi.dietapp.microservice.authentication.mapper.LoginMapperImpl;

@Configuration
public class ProjectConfig {
    @Bean
    public LoginMapper loginMapper() { return new LoginMapperImpl(); }
}
