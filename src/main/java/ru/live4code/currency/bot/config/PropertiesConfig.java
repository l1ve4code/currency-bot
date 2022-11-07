package ru.live4code.currency.bot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ComponentScan({ "ru.live4code.currency" })
public class PropertiesConfig {
    @Value("${bot.name}")
    private String botName;
    @Value("${bot.key}")
    private String botKey;
    @Value("${currency.api.token}")
    private String token;
}
