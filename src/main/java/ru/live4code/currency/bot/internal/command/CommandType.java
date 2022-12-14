package ru.live4code.currency.bot.internal.command;

public enum CommandType {
    START("/start"),
    MENU("/menu");

    private String value;
    CommandType(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public static CommandType fromString(String text) {
        for (CommandType s : CommandType.values()) {
            if (s.value.equalsIgnoreCase(text)) {
                return s;
            }
        }
        return null;
    }
}
