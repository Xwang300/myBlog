package com.cass.picture.service.impl;

import com.cass.picture.domain.Picture;
import com.cass.picture.mapper.PictureMapper;
import com.cass.picture.service.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Xin Wang
 * @Date 2020/6/3 11:03
 */

@Service
public class PictureServiceImpl implements IPictureService {

    @Autowired
    private PictureMapper pictureMapper;

    @Override
    public List<Picture> selectAllPictures() {
        return pictureMapper.selectAllPictures();
    }

    @Override
    public Integer insertPicture(Picture picture) {
        return pictureMapper.insertPicture(picture);
    }

    @Override
    public Integer deletePictureById(int id) {
        return pictureMapper.deletePictureById(id);
    }
}
