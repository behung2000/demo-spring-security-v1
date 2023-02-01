package com.demospringsecurityv1.configs;

import com.demospringsecurityv1.springsecurity.SecurityConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
    SecurityConfig.class
})
public class Config {

}
