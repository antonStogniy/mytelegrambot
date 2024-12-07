package com.github.mytelegrambot.mytelegrambot.command.impl;

import com.github.mytelegrambot.mytelegrambot.command.Command;
import com.github.mytelegrambot.mytelegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StopCommandImpl implements Command {

    private final SendBotMessageService sendBotMassageService;

    public static final String STOP_MESSAGE = "Вы приостановили общение с ботом \uD83D\uDE1F.";

    public StopCommandImpl(SendBotMessageService sendBotMassageService) {
        this.sendBotMassageService = sendBotMassageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMassageService.sendMessage(update.getMessage().getChatId().toString(), STOP_MESSAGE);
    }
}
