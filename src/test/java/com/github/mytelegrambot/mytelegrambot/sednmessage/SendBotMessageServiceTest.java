package com.github.mytelegrambot.mytelegrambot.sednmessage;

import com.github.mytelegrambot.mytelegrambot.bot.MyFirstTelegramBot;
import com.github.mytelegrambot.mytelegrambot.service.SendBotMessageService;
import com.github.mytelegrambot.mytelegrambot.service.impl.SendBotMessageServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Unit-level testing for SendMessageService")
public class SendBotMessageServiceTest {
    private SendBotMessageService sendBotMessageService;
    private MyFirstTelegramBot myFirstTelegramBot;

    @BeforeEach
    void setUp() {
        myFirstTelegramBot = Mockito.mock(MyFirstTelegramBot.class);
        sendBotMessageService = new SendBotMessageServiceImpl(myFirstTelegramBot);
    }

    @Test
    void shouldProperlySendMessageTest() throws TelegramApiException {
        String message = "Hello World!";
        String chatId = "test_message_id";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);
        sendMessage.enableHtml(true);

        sendBotMessageService.sendMessage(chatId, message);

        Mockito.verify(myFirstTelegramBot).execute(sendMessage);
    }
}
