package com.github.mytelegrambot.mytelegrambot.command.impl;

import com.github.mytelegrambot.mytelegrambot.command.Command;
import com.github.mytelegrambot.mytelegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class NoCommandImpl implements Command {

    private final SendBotMessageService sendBotMassageService;

    public static final String NO_MESSAGE = "Я поддерживаю команды, начинающиеся со слеша(/).\n"
            + "Чтобы посмотреть список команд введите /help";

    public NoCommandImpl(SendBotMessageService sendBotMassageService) {
        this.sendBotMassageService = sendBotMassageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMassageService.sendMessage(update.getMessage().getChatId().toString(), NO_MESSAGE);
    }
}
