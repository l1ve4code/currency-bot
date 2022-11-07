package ru.live4code.currency.bot.client.model;

import lombok.Data;

import java.util.List;

@Data
public class VaultPairsModel {

    private String status;
    private String message;
    private List<String> data;

}
