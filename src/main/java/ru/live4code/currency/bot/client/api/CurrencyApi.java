package ru.live4code.currency.bot.client.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.live4code.currency.bot.client.model.VaultPairsModel;

import java.util.*;

@Component
@RequiredArgsConstructor
public class CurrencyApi {

    private final RestTemplate restTemplate;

    public List<String> getVaultPairs() {

        VaultPairsModel model = restTemplate.getForObject("https://currate.ru/api/?get=currency_list&key=d9f7d0f3ee8d068083f5bd87772a455c", VaultPairsModel.class);

        if (Objects.isNull(model) && Objects.isNull(model.getData())) {
            throw new IllegalStateException("No data in query");
        }

        return model.getData().stream().map(item -> item.substring(0, 3) + " | " + item.substring(3)).toList();
    }

}
