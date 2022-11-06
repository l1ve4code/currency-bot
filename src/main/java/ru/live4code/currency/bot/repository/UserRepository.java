package ru.live4code.currency.bot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.live4code.currency.bot.model.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
}
