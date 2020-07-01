package com.cass.message.mapper;

import com.cass.message.domain.Message;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: Xin Wang
 * @Date 2020/7/1 16:24
 */

@Component
public interface MessageMapper {

    Integer insertMessage(Message message);

    List<Message> selectAllMessage();


}
