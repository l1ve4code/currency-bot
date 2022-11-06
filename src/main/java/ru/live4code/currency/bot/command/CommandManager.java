package ru.live4code.currency.bot.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.live4code.currency.bot.command.impl.StartCommand;
import ru.live4code.currency.bot.config.PropertiesConfig;

import java.util.HashMap;
import java.util.Map;

@Component
public class CommandManager {

    @Autowired
    private PropertiesConfig propertiesConfig;

    @Bean
    public Map<String, AbstractCommand> initializeCommands() {
        Map<String, AbstractCommand> commandHashMap = new HashMap<>();

        commandHashMap.put("/start", new StartCommand(propertiesConfig.getBotKey()));

        return commandHashMap;
    }

}
