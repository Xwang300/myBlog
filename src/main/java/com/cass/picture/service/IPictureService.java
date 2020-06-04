package com.cass.picture.service;

import com.cass.picture.domain.Picture;

import java.util.List;

/**
 * @Author: Xin Wang
 * @Date 2020/6/3 11:02
 */
public interface IPictureService {

    List<Picture> selectAllPictures();

}
