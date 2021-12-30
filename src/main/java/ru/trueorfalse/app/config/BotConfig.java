package ru.trueorfalse.app.config;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import ru.trueorfalse.app.bot.TelegramTrueOrFalseBot;
import ru.trueorfalse.app.service.TelegramBotService;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "telegrambot")
public class BotConfig {
    @Value("${telegrambot.webHookPath}")
    private String webHookPath;
    @Value("${telegrambot.userName}")
    private String botUserName;
    @Value("${telegrambot.botToken}")
    private String botToken;

    @Bean
    public TelegramTrueOrFalseBot myWizardTelegramBot(TelegramBotService telegramBotService) {
        DefaultBotOptions options = new DefaultBotOptions();
        TelegramTrueOrFalseBot mySuperTelegramBot = new TelegramTrueOrFalseBot(options, telegramBotService);
        mySuperTelegramBot.setBotUserName(botUserName);
        mySuperTelegramBot.setBotToken(botToken);
        mySuperTelegramBot.setWebHookPath(webHookPath);
        return mySuperTelegramBot;
    }
}
