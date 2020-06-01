package com.cass.archives.mapper;

import com.cass.archives.domain.TimeLineResp;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: Xin Wang
 * @Date 2020/6/1 10:48
 */

@Component
public interface ArchivesMapper {
    List<TimeLineResp> selectAllTimeLine();
}
