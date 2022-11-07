package ru.live4code.currency.bot.internal.command.impl;

import com.google.common.collect.Lists;
import com.google.common.math.IntMath;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.live4code.currency.bot.client.api.CurrencyApi;
import ru.live4code.currency.bot.internal.command.AbstractCommand;
import ru.live4code.currency.bot.internal.command.CommandType;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class MenuCommand extends AbstractCommand {
    private final CurrencyApi currencyApi;

    @Override
    protected void performCommand(Message message) throws TelegramApiException {

        SendMessage msg = new SendMessage();

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();

        var vaultPairs = currencyApi.getVaultPairs();

        int partitionSize = IntMath.divide(vaultPairs.size(), 35, RoundingMode.UP);
        var partitions = Lists.partition(vaultPairs, partitionSize);

        partitions.forEach(subArray -> {
            List<InlineKeyboardButton> rowInline = new ArrayList<>();
            subArray.forEach(item -> {
                var button = new InlineKeyboardButton();
                button.setText(item);
                button.setUrl("https://www.google.com/");
                rowInline.add(button);
            });
            rowsInline.add(rowInline);
        });

        markupInline.setKeyboard(rowsInline);

        msg.setText("_______________Список доступных валютных пар_______________");
        msg.setChatId(message.getChatId());
        msg.setReplyMarkup(markupInline);

        execute(msg);
    }

    @Override
    public CommandType getCommand() {
        return CommandType.MENU;
    }

}
