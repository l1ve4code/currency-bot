package ru.live4code.currency.bot.internal.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.live4code.currency.bot.internal.model.UserModel;
import ru.live4code.currency.bot.internal.repository.UserRepository;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserDao {

    private final UserRepository userRepository;

    public void createWithId(Long id) {
        UserModel user = new UserModel();
        user.setChatId(id);
        try {
            userRepository.save(user);
        } catch (Exception e) {
            log.error("Error while processing new user: {}", e.toString());
        }
    }

}
