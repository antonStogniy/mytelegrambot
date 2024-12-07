package com.github.mytelegrambot.mytelegrambot.command.impl;

import com.github.mytelegrambot.mytelegrambot.command.Command;
import com.github.mytelegrambot.mytelegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class UnknownCommandImpl implements Command {

    private final SendBotMessageService sendBotMassageService;

    public static final String UNKNOWN_MESSAGE = "Не понимаю \uD83D\uDE1F, напишите /help чтобы узнать подробности.";

    public UnknownCommandImpl(SendBotMessageService sendBotMassageService) {
        this.sendBotMassageService = sendBotMassageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMassageService.sendMessage(update.getMessage().getChatId().toString(), UNKNOWN_MESSAGE);
    }
}
