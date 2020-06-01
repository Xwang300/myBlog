package com.cass.controller.archives;

import com.cass.archives.domain.TimeLineResp;
import com.cass.archives.service.IArchivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: Xin Wang
 * @Date 2020/6/1 10:44
 */
@RequestMapping("/archives")
@Controller
public class ArchivesController {


    @Autowired
    private IArchivesService archivesService;

    @RequestMapping()
    public String archives(Model model){
        List<TimeLineResp> timeLineRespList = archivesService.selectAllTimeLine();
        model.addAttribute("timeLineList",timeLineRespList);
        return "archives";
    }


}
