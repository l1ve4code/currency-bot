package ru.live4code.currency.bot.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.live4code.currency.bot.app.CurrencyBot;
import ru.live4code.currency.bot.command.AbstractCommand;
import ru.live4code.currency.bot.command.impl.StartCommand;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final CurrencyBot currencyBot;

    @EventListener({ContextRefreshedEvent.class})
    public void initializeBot(){
        try{
            new TelegramBotsApi(DefaultBotSession.class).registerBot(currencyBot);
        } catch (Exception e) {
            log.error("Error on bot initialize: %s", e);
        }
    }
}
