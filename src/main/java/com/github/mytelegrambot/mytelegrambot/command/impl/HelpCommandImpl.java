package com.github.mytelegrambot.mytelegrambot.command.impl;

import com.github.mytelegrambot.mytelegrambot.command.Command;
import com.github.mytelegrambot.mytelegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.mytelegrambot.mytelegrambot.command.CommandName.*;

public class HelpCommandImpl implements Command {

    private final SendBotMessageService sendBotMassageService;

    public static final String HELP_MESSAGE = String.format("<b>Доступные команды</b>\n\n"
            + "<b>Начать\\закончить работу с ботом</b>\n"
            + "%s - начать работу со мной\n"
            + "%s - приостановить работу со мной\n\n"
            + "%s - получить помощь в работе со мной\n",
            START.getCommandName(), STOP.getCommandName(), HELP.getCommandName());

    public HelpCommandImpl(SendBotMessageService sendBotMassageService) {
        this.sendBotMassageService = sendBotMassageService;
    }
    @Override
    public void execute(Update update) {
        sendBotMassageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}
