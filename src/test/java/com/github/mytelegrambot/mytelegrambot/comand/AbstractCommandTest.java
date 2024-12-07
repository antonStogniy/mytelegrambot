package com.github.mytelegrambot.mytelegrambot.comand;


import com.github.mytelegrambot.mytelegrambot.bot.MyFirstTelegramBot;
import com.github.mytelegrambot.mytelegrambot.command.Command;
import com.github.mytelegrambot.mytelegrambot.service.SendBotMessageService;
import com.github.mytelegrambot.mytelegrambot.service.impl.SendBotMessageServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public abstract class AbstractCommandTest {

    protected MyFirstTelegramBot myFirstTelegramBot = Mockito.mock(MyFirstTelegramBot.class);
    protected SendBotMessageService sendBotMessageService = new SendBotMessageServiceImpl(myFirstTelegramBot);

    abstract String getCommandName();
    abstract String getCommandMessage();
    abstract Command getCommand();

    @Test
    public void shouldProperlyExecuteCommand() throws TelegramApiException {

        Long chatId = 12345678234567L;

        Update update = new Update();
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getChatId()).thenReturn(chatId);
        Mockito.when(message.getText()).thenReturn(getCommandName());
        update.setMessage(message);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(getCommandMessage());
        sendMessage.enableHtml(true);

        getCommand().execute(update);

        Mockito.verify(myFirstTelegramBot).execute(sendMessage);
    }
}
