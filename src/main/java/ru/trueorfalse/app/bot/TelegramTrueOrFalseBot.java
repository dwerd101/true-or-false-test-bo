package ru.trueorfalse.app.bot;

import lombok.Setter;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.trueorfalse.app.service.TelegramBotService;

@Setter
public class TelegramTrueOrFalseBot extends TelegramWebhookBot {
    private String webHookPath;
    private String botUserName;
    private String botToken;
    private TelegramBotService telegramBotService;

    public TelegramTrueOrFalseBot(DefaultBotOptions botOptions, TelegramBotService telegramBotService) {
        super(botOptions);
        this.telegramBotService =telegramBotService;
    }
    @Override
    public String getBotUsername() {
        return botUserName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return  telegramBotService.getTrueOrFalse(update);
    }

    @Override
    public String getBotPath() {
        return webHookPath;
    }
}
