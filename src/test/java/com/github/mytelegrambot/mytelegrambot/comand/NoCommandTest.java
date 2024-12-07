package com.github.mytelegrambot.mytelegrambot.comand;

import com.github.mytelegrambot.mytelegrambot.command.Command;
import com.github.mytelegrambot.mytelegrambot.command.impl.NoCommandImpl;
import org.junit.jupiter.api.DisplayName;

import static com.github.mytelegrambot.mytelegrambot.command.CommandName.NO;
import static com.github.mytelegrambot.mytelegrambot.command.impl.NoCommandImpl.NO_MESSAGE;

@DisplayName("Level-unit for testing NoCommand ")
public class NoCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return NO.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return NO_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new NoCommandImpl(sendBotMessageService);
    }
}
