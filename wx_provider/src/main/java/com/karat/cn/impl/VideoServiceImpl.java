package com.karat.cn.impl;

import com.karat.cn.bean.Video;
import com.karat.cn.service.VideoService;
import com.karat.cn.util.IdUtil;
import com.karat.cn.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service("videoService")
public class VideoServiceImpl implements VideoService {

    @Autowired
    private MongoTemplate mongoTemplate;
    //查看所有视频
    public List<Video> selectPage(String pageNum, String pageSize){
        int a=1,b=5;
        if(!StringUtils.isEmpty(pageNum)&&!StringUtils.isEmpty(pageNum)){
            a=Integer.valueOf(pageNum);b=Integer.valueOf(pageSize);
        }
        Query query=new Query();
        query.skip((a - 1) * b);
        query.limit(b);
        return mongoTemplate.find(query, Video.class);
    }
    //添加视频
    public boolean add(Video video){
        if(video!=null){
            video.setId(IdUtil.getUUID());
            video.setTime(TimeUtil.formateMillsecDateToStr(TimeUtil.systemtimeLong()));
            mongoTemplate.insert(video);
            return true;
        }else{
            return false;
        }
    }
    //查看总条数
    public int selectAllNum(){
        return (int)mongoTemplate.count(new Query(),Video.class);
    }
    //查看所有
    public List<Video> select(){
        return mongoTemplate.findAll(Video.class);
    }
}
