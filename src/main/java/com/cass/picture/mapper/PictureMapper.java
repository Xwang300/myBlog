package com.cass.picture.mapper;

import com.cass.picture.domain.Picture;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: Xin Wang
 * @Date 2020/6/3 11:02
 */

@Component
public interface PictureMapper {

    List<Picture> selectAllPictures();
}
