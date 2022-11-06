package ru.live4code.currency.bot.app;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.live4code.currency.bot.command.AbstractCommand;
import ru.live4code.currency.bot.config.PropertiesConfig;

import javax.annotation.Resource;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class CurrencyBot extends TelegramLongPollingBot {

    @Resource()
    private Map<String, AbstractCommand> commands;

    private final PropertiesConfig config;

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public String getBotToken() {
        return config.getBotKey();
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (!update.hasMessage()) return;

        Message message = update.getMessage();
        String command = message.getText();

        if (!commands.containsKey(command)) return;

        commands.get(command).tryToPerformCommand(message);

    }
}
