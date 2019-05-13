package com.karat.cn.service;

import com.karat.cn.bean.Picture;
import com.karat.cn.bean.Video;

import java.util.List;

public interface VideoService {
    //查看所有视频
    List<Video> selectPage(String pageNum, String pageSize);
    //添加视频
    boolean add(Video video);
    //查看总条数
    int selectAllNum();
    //查看所有
    List<Video> select();
}
