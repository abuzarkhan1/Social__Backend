package com.social.webdevproject.service;

import com.social.webdevproject.models.Message;
import com.social.webdevproject.models.User;

import java.util.List;

public interface MessageService {

    public Message createMessage(User user, Integer chatId, Message req) throws Exception;

    public List<Message> findChatMessages(Integer chatId) throws Exception;


}
