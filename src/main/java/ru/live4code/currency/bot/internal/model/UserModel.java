package ru.live4code.currency.bot.internal.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "users",schema="public")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="chat_id", unique = true)
    private Long chatId;

}
