package com.github.mytelegrambot.mytelegrambot.command.impl;

import com.github.mytelegrambot.mytelegrambot.command.Command;
import com.github.mytelegrambot.mytelegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommandImpl implements Command {

    private final SendBotMessageService sendBotMassageService;

    public final static String START_MESSAGE = "Привет, я первый бот Антона, пока знаю очень мало команд.";

    public StartCommandImpl(SendBotMessageService sendBotMassageService) {
        this.sendBotMassageService = sendBotMassageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMassageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
    }
}
