package com.karat.cn.service;

import com.karat.cn.bean.Segment;

import java.util.List;

public interface SegmentService {
    //查看所有段子
    List<Segment> selectPage(String pageNum, String pageSize);
    //添加段子
    boolean add(Segment segment);
    //查看总条数
    int selectAllNum();
    //查看所有
    List<Segment> select();
}
