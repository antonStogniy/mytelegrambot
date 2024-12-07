package com.github.mytelegrambot.mytelegrambot.comand;

import com.github.mytelegrambot.mytelegrambot.command.Command;
import com.github.mytelegrambot.mytelegrambot.command.impl.StopCommandImpl;
import org.junit.jupiter.api.DisplayName;

import static com.github.mytelegrambot.mytelegrambot.command.CommandName.STOP;
import static com.github.mytelegrambot.mytelegrambot.command.impl.StopCommandImpl.STOP_MESSAGE;

@DisplayName("Level-unit for testing StopCommand")
public class StopCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return STOP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return STOP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StopCommandImpl(sendBotMessageService);
    }
}
