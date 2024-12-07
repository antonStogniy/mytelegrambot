package com.github.mytelegrambot.mytelegrambot.service;

public interface SendBotMessageService {
    void sendMessage(String chatId, String message);
}
