package com.cass.controller.message;

import com.cass.common.BaseConst;
import com.cass.common.BaseResponse;
import com.cass.message.domain.Message;
import com.cass.message.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: Xin Wang
 * @Date 2020/6/1 15:47
 */
@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private IMessageService messageService;

    @RequestMapping()
    public String messagePage(Model model){
        List<Message> messages = messageService.selectAllMessage();
        model.addAttribute("messages",messages);
        return "message";
    }

    @ResponseBody
    @RequestMapping("/insertMessage")
    public BaseResponse<String> insertMessage(@RequestBody Message message){
        BaseResponse<String> baseResponse = new BaseResponse<>();
        messageService.insertMessage(message);
        baseResponse.setResCode(BaseConst.SUCCESS_CODE);
        baseResponse.setResMsg("留言成功！");
        return baseResponse;
    }
}
