package ru.live4code.currency.bot.command.impl;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.live4code.currency.bot.command.AbstractCommand;

@Slf4j
public class StartCommand extends AbstractCommand {

    public StartCommand(String key) {
        super(key);
    }
    @Override
    protected void performCommand(Message message) {
        System.out.println("Received command");
    }

}
