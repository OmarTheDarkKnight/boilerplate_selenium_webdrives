package com.bat.configurations;

import com.bat.webdrivers.ChromeWebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.bat")
@PropertySource(value = "classpath:browser_config.properties")
public class SpringConfig {
    @Bean
    public ChromeWebDriver getChromeWebDriver() {
        return new ChromeWebDriver();
    }
}
