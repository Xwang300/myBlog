package com.cass.archives.service;

import com.cass.archives.domain.TimeLineResp;

import java.util.List;

/**
 * @Author: Xin Wang
 * @Date 2020/6/1 11:17
 */

public interface IArchivesService {

    List<TimeLineResp> selectAllTimeLine();

}
