package com.github.mytelegrambot.mytelegrambot.command;

import com.github.mytelegrambot.mytelegrambot.command.impl.*;
import com.github.mytelegrambot.mytelegrambot.service.SendBotMessageService;

import java.util.Map;

import static com.github.mytelegrambot.mytelegrambot.command.CommandName.*;

public class CommandContainer {

    private final Map<String, Command> commands;

    private final Command unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMassageService) {
        commands = Map.ofEntries(Map.entry(START.getCommandName(), new StartCommandImpl(sendBotMassageService)),
                Map.entry(STOP.getCommandName(), new StopCommandImpl(sendBotMassageService)),
                Map.entry(HELP.getCommandName(), new HelpCommandImpl(sendBotMassageService)),
                Map.entry(NO.getCommandName(), new NoCommandImpl(sendBotMassageService)));
        unknownCommand = new UnknownCommandImpl(sendBotMassageService);
    }

    public Command retrieveCommand(String commandName) {
        return commands.getOrDefault(commandName, unknownCommand);
    }
}
