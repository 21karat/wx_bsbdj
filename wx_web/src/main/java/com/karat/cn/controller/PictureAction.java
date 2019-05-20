package com.karat.cn.controller;

import com.alibaba.fastjson.JSON;
import com.karat.cn.bean.Picture;
import com.karat.cn.service.PictureService;
import com.karat.cn.vo.RequestPicture;
import com.karat.cn.vo.ResponsePicture;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("pa")
@Api("动图接口")
public class PictureAction {

    @Autowired
    PictureService pictureService;


    /**
     * 查看所有
     * @return
     */
    @RequestMapping(value = "select",method= RequestMethod.POST,produces="html/text;charset=UTF-8")
    public String select(String pageNum,String pageSize){
        ResponsePicture response=new ResponsePicture();
        List<Picture> pictures=new ArrayList<>();
        if(pageNum==null||pageSize==null){
            pictures=pictureService.select();
        }else{
            pictures=pictureService.selectPage(pageNum,pageSize);
        }
        if(pictures.size()>0){
            response.setTotalPage(pictureService.selectAllNum());
            response.setPictures(pictures);
        }
        return JSON.toJSONString(response);
    }

    /***
     * 添加
     * @param picture
     * @return
     */
    @RequestMapping(value = "add",method = RequestMethod.POST,produces="html/text;charset=UTF-8")
    public String add(RequestPicture picture){
        System.out.print(picture);
        return JSON.toJSONString(/*pictureService.add(picture)*/"");
    }
}
