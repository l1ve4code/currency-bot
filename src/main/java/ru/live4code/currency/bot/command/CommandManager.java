package ru.live4code.currency.bot.command;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CommandManager {

    @Resource
    private List<AbstractCommand> commands;

    @Bean
    public Map<CommandType, AbstractCommand> initializeCommands() {
        var commandList = new HashMap<CommandType, AbstractCommand>();
        commands.forEach(item -> commandList.put(item.getCommand(), item));
        return commandList;
    }

}
