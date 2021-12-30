package ru.trueorfalse.app.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.trueorfalse.app.bot.TelegramTrueOrFalseBot;

@RestController
@RequiredArgsConstructor
public class TelegramController {

    private final TelegramTrueOrFalseBot telegramBot;

    @PostMapping("/")
    public BotApiMethod<?> getTrueOrFalse(@RequestBody Update update) {
        return telegramBot.onWebhookUpdateReceived(update);
       // return  null;
    }
}
