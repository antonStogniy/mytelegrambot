package com.github.mytelegrambot.mytelegrambot.comand;

import com.github.mytelegrambot.mytelegrambot.command.Command;
import com.github.mytelegrambot.mytelegrambot.command.impl.HelpCommandImpl;
import org.junit.jupiter.api.DisplayName;

import static com.github.mytelegrambot.mytelegrambot.command.CommandName.HELP;
import static com.github.mytelegrambot.mytelegrambot.command.impl.HelpCommandImpl.HELP_MESSAGE;

@DisplayName("Level-unit for testing HelpCommand")
public class HelpCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return HELP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return HELP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new HelpCommandImpl(sendBotMessageService);
    }
}
