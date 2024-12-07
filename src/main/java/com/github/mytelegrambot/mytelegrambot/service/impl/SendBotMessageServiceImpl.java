package com.github.mytelegrambot.mytelegrambot.service.impl;

import com.github.mytelegrambot.mytelegrambot.bot.MyFirstTelegramBot;
import com.github.mytelegrambot.mytelegrambot.service.SendBotMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class SendBotMessageServiceImpl implements SendBotMessageService {

    private final MyFirstTelegramBot myFirstTelegramBot;

    @Autowired
    public SendBotMessageServiceImpl(MyFirstTelegramBot myFirstTelegramBot) {
        this.myFirstTelegramBot = myFirstTelegramBot;
    }

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try {
            myFirstTelegramBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
