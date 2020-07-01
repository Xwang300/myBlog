package com.cass.message.service;

import com.cass.message.domain.Message;

import java.util.List;

/**
 * @Author: Xin Wang
 * @Date 2020/7/1 16:31
 */
public interface IMessageService {

    Integer insertMessage(Message message);

    List<Message> selectAllMessage();
}
