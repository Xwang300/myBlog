package com.cass.archives.service.impl;

import com.cass.archives.mapper.ArchivesMapper;
import com.cass.archives.domain.TimeLineResp;
import com.cass.archives.service.IArchivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Xin Wang
 * @Date 2020/6/1 11:18
 */

@Service
public class ArchivesServiceImpl implements IArchivesService {

    @Autowired
    private ArchivesMapper archivesMapper;

    @Override
    public List<TimeLineResp> selectAllTimeLine() {
        return archivesMapper.selectAllTimeLine();
    }
}
