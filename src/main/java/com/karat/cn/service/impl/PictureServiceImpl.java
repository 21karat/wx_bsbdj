package com.karat.cn.service.impl;

import com.karat.cn.bean.Picture;
import com.karat.cn.service.PictureService;
import com.karat.cn.util.IdUtil;
import com.karat.cn.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private MongoTemplate mongoTemplate;

    //查看所有段子
    public List<Picture> selectPage(String pageNum, String pageSize){
        int a=1,b=5;
        if(!StringUtils.isEmpty(pageNum)&&!StringUtils.isEmpty(pageNum)){
            a=Integer.valueOf(pageNum);b=Integer.valueOf(pageSize);
        }
        Query query=new Query();
        query.skip((a - 1) * b);
        query.limit(b);
        return mongoTemplate.find(query,Picture.class);
    }
    //查看总条数
    public int selectAllNum(){
        return (int)mongoTemplate.count(new Query(),Picture.class);
    }
    //添加段子
    public boolean add(Picture picture){
        if(picture!=null){
            picture.setId(IdUtil.getUUID());
            picture.setTime(TimeUtil.formateMillsecDateToStr(TimeUtil.systemtimeLong()));
            mongoTemplate.insert(picture);
            return true;
        }else{
            return false;
        }
    }
    //查看所有
    public List<Picture> select(){
        return mongoTemplate.findAll(Picture.class);
    }
}
