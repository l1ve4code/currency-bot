package ru.live4code.currency.bot.internal.command;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.live4code.currency.bot.config.PropertiesConfig;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class CommandManager {

    @Resource
    private List<AbstractCommand> commands;

    private final PropertiesConfig propertiesConfig;

    @Bean
    public Map<CommandType, AbstractCommand> initializeCommands() {
        var commandList = new HashMap<CommandType, AbstractCommand>();
        commands.forEach(item -> {
            item.setBotToken(propertiesConfig.getBotKey());
            commandList.put(item.getCommand(), item);
        });
        return commandList;
    }

}
