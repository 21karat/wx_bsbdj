package com.karat.cn.service;

import com.karat.cn.bean.Picture;

import java.util.List;

public interface PictureService {
    //查看所有动图
    List<Picture> selectPage(String pageNum, String pageSize);
    //添加动图
    boolean add(Picture picture);
    //查看总条数
    int selectAllNum();
    //查看所有
    List<Picture> select();
}
