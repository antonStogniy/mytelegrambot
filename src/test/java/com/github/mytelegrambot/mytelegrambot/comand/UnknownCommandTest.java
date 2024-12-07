package com.github.mytelegrambot.mytelegrambot.comand;

import com.github.mytelegrambot.mytelegrambot.command.Command;
import com.github.mytelegrambot.mytelegrambot.command.impl.UnknownCommandImpl;
import org.junit.jupiter.api.DisplayName;

import static com.github.mytelegrambot.mytelegrambot.command.impl.UnknownCommandImpl.UNKNOWN_MESSAGE;

@DisplayName("Level-unit for testing UnknownCommand")
public class UnknownCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return "UnknownCommand";
    }

    @Override
    String getCommandMessage() {
        return UNKNOWN_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new UnknownCommandImpl(sendBotMessageService);
    }
}
