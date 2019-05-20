package com.karat.cn.impl;

import com.karat.cn.bean.Segment;
import com.karat.cn.service.SegmentService;
import com.karat.cn.util.IdUtil;
import com.karat.cn.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service("segmentService")
public class SegmentServiceImpl implements SegmentService {

    @Autowired
    private MongoTemplate mongoTemplate;

    //查看所有段子
    public List<Segment> selectPage(String pageNum,String pageSize){
        int a=1,b=5;
        if(!StringUtils.isEmpty(pageNum)&&!StringUtils.isEmpty(pageNum)){
            a=Integer.valueOf(pageNum);b=Integer.valueOf(pageSize);
        }
        Query query=new Query();
        query.skip((a - 1) * b);
        query.limit(b);
        return mongoTemplate.find(query,Segment.class);
    }
    //查看总条数
    public int selectAllNum(){
        return (int)mongoTemplate.count(new Query(),Segment.class);
    }
    //添加段子
    public boolean add(Segment segment){
        if(segment!=null){
            segment.setId(IdUtil.getUUID());
            segment.setTime(TimeUtil.formateMillsecDateToStr(TimeUtil.systemtimeLong()));
            mongoTemplate.insert(segment);
            return true;
        }else{
            return false;
        }
    }
    //查看所有
    public List<Segment> select(){
        return mongoTemplate.findAll(Segment.class);
    }
}
