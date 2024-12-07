package com.github.mytelegrambot.mytelegrambot.bot;

import com.github.mytelegrambot.mytelegrambot.command.CommandContainer;
import com.github.mytelegrambot.mytelegrambot.service.impl.SendBotMessageServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.logging.Logger;

import static com.github.mytelegrambot.mytelegrambot.command.CommandName.NO;

@Component
public class MyFirstTelegramBot extends TelegramLongPollingBot {

    public static String COMMAND_PREFIX = "/";

    @Value("${bot.username}")
    private String username;

    @Value("${bot.token}")
    private String token;

    private final CommandContainer commandContainer;

    Logger logger = Logger.getLogger(MyFirstTelegramBot.class.getName());




    public MyFirstTelegramBot() {
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this));
    }


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String msg = update.getMessage().getText().trim();

            if (msg.startsWith(COMMAND_PREFIX)) {
                String command = msg.split(" ")[0].toLowerCase();
                commandContainer.retrieveCommand(command).execute(update);
            } else {
                commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return username;
    }
    @Override
    public String getBotToken() {
        return token;
    }
}
