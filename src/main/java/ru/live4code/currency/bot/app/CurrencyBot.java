package ru.live4code.currency.bot.app;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.live4code.currency.bot.command.AbstractCommand;
import ru.live4code.currency.bot.command.CommandType;
import ru.live4code.currency.bot.config.PropertiesConfig;
import ru.live4code.currency.bot.dao.UserDao;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class CurrencyBot extends TelegramLongPollingBot {

    private final UserDao userDao;
    private final Map<CommandType, AbstractCommand> commandMap;
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
        CommandType command = CommandType.fromString(message.getText());

        if (!commandMap.containsKey(command)) return;

        commandMap.get(command).tryToPerformCommand(message);

        userDao.createWithId(message.getChatId());

    }
}
