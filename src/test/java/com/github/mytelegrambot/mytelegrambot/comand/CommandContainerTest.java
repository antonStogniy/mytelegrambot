package com.github.mytelegrambot.mytelegrambot.comand;


import com.github.mytelegrambot.mytelegrambot.command.Command;
import com.github.mytelegrambot.mytelegrambot.command.CommandContainer;
import com.github.mytelegrambot.mytelegrambot.command.CommandName;
import com.github.mytelegrambot.mytelegrambot.command.impl.UnknownCommandImpl;
import com.github.mytelegrambot.mytelegrambot.service.SendBotMessageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.util.Assert;

import java.lang.reflect.Array;
import java.util.Arrays;

@DisplayName("Unit-level testing for Command Container")
public class CommandContainerTest {

    CommandContainer commandContainer;

    @BeforeEach
    void setUp() {
        SendBotMessageService sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        commandContainer = new CommandContainer(sendBotMessageService);
    }

    @Test
    void shouldGetAllExistingCommands() {

        Arrays.stream(CommandName.values()).forEach(commandName -> {
            Command command = commandContainer.retrieveCommand(commandName.getCommandName());
            Assertions.assertNotEquals(UnknownCommandImpl.class, command.getClass());
        });
    }

    @Test
    void shouldReturnUnknownCommand() {
        String unknownCommand = "unknown command";
        Command command = commandContainer.retrieveCommand(unknownCommand);
        Assertions.assertEquals(UnknownCommandImpl.class, command.getClass());
    }
}
