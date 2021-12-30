package ru.trueorfalse.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class TelegramBotService {
    private final InlineKeyboardMarkup inlineMessageButtons;

    public BotApiMethod<?> getTrueOrFalse(Update update) {

        if(update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            //callbackQuery.getMessage().
            Random random = new Random();
            int number = random.nextInt(2);
            if(number==1) {
               SendMessage sendMessage = new SendMessage(String.valueOf(callbackQuery.getMessage().getChatId()), "Да");
               sendMessage.setReplyMarkup(inlineMessageButtons);
               return  sendMessage;
            }
            else {
                SendMessage sendMessage = new SendMessage(String.valueOf(callbackQuery.getMessage().getChatId()), "Нет");
                sendMessage.setReplyMarkup(inlineMessageButtons);
                return  sendMessage;
            }
        }

        if(update.getMessage().getText().contains("/start")) {
            SendMessage sendMessage = new SendMessage(String.valueOf(update.getMessage().getChatId()),"Хочешь испытать судьбу. " +
                    "Нажми на кнопку");
            sendMessage.setReplyMarkup(inlineMessageButtons);
            return sendMessage;
        }
        else return new SendMessage();

    }
}
