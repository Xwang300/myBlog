package com.cass.message.service.impl;

import com.cass.message.domain.Message;
import com.cass.message.mapper.MessageMapper;
import com.cass.message.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Xin Wang
 * @Date 2020/7/1 16:31
 */

@Service
public class MessageServiceImpl implements IMessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public Integer insertMessage(Message message) {
        return messageMapper.insertMessage(message);
    }

    @Override
    public List<Message> selectAllMessage() {
        return messageMapper.selectAllMessage();
    }
}
