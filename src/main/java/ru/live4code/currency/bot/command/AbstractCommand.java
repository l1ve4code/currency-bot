package ru.live4code.currency.bot.command;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.objects.Message;

@Slf4j
public abstract class AbstractCommand extends DefaultAbsSender {

    private final String BOT_KEY;

    protected AbstractCommand(String key) {
        super(new DefaultBotOptions());
        BOT_KEY = key;
    }

    public void tryToPerformCommand(Message message) {
        try {
            this.performCommand(message);
        } catch (Exception e) {
            log.error("Command failed with - {}", e.toString());
        }
    }

    protected abstract void performCommand(Message message);

    @Override
    public String getBotToken() {
        return BOT_KEY;
    }

}
