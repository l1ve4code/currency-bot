package ru.live4code.currency.bot.command;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
public abstract class AbstractCommand extends DefaultAbsSender {

    protected AbstractCommand() {
        super(new DefaultBotOptions());
    }

    public void tryToPerformCommand(Message message) {
        try {
            this.performCommand(message);
        } catch (Exception e) {
            log.error("Command failed with - {}", e.toString());
        }
    }

    protected abstract void performCommand(Message message) throws TelegramApiException;

    public abstract CommandType getCommand();

}
