package ru.live4code.currency.bot.command.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.live4code.currency.bot.command.AbstractCommand;
import ru.live4code.currency.bot.command.CommandType;
import ru.live4code.currency.bot.config.PropertiesConfig;

@Slf4j
@Component
@RequiredArgsConstructor
public class StartCommand extends AbstractCommand {

    private static final String DESCRIPTION = """
            Привет! Это чат-бот котировок валют.\n
            In dev...
            """;
    private final PropertiesConfig propertiesConfig;
    @Override
    protected void performCommand(Message message) throws TelegramApiException {
        SendMessage msg  = new SendMessage();

        msg.setChatId(message.getChatId());
        msg.setText(DESCRIPTION);

        execute(msg);
    }

    @Override
    public CommandType getCommand() {
        return CommandType.START;
    }

    @Override
    public String getBotToken() {
        return propertiesConfig.getBotKey();
    }

}
