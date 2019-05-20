package com.karat.cn.controller;

import com.alibaba.fastjson.JSON;
import com.karat.cn.bean.Video;
import com.karat.cn.service.VideoService;
import com.karat.cn.vo.ResponseVideo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("va")
@Api("视频接口")
public class VideoAction {

    @Autowired
    VideoService videoService;

    /**
     * 查看所有
     * @return
     */
    @RequestMapping(value = "select",method= RequestMethod.POST,produces="html/text;charset=UTF-8")
    public String select(String pageNum,String pageSize){
        ResponseVideo response=new ResponseVideo();
        List<Video> videos=null;
        if(pageNum==null||pageSize==null){
            videos=videoService.select();
        }else{
            videos=videoService.selectPage(pageNum,pageSize);
        }
        if(videos.size()>0){
            response.setTotalPage(videoService.selectAllNum());
            response.setVideos(videos);
        }
        return JSON.toJSONString(response);
    }

    /**
     * 添加
     * @param video
     * @return
     */
    @RequestMapping(value = "add",method = RequestMethod.POST,produces="html/text;charset=UTF-8")
    public String add(Video video){
        return JSON.toJSONString(videoService.add(video));
    }
}
