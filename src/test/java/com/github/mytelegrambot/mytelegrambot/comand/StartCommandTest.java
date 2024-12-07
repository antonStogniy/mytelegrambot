package com.github.mytelegrambot.mytelegrambot.comand;

import com.github.mytelegrambot.mytelegrambot.command.Command;
import com.github.mytelegrambot.mytelegrambot.command.impl.StartCommandImpl;
import org.junit.jupiter.api.DisplayName;

import static com.github.mytelegrambot.mytelegrambot.command.CommandName.START;
import static com.github.mytelegrambot.mytelegrambot.command.impl.StartCommandImpl.START_MESSAGE;

@DisplayName("Level-unit for testing StartCommand")
public class StartCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return START.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return START_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StartCommandImpl(sendBotMessageService);
    }
}
