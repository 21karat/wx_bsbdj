package com.karat.cn;

import com.karat.cn.bean.Segment;
import com.karat.cn.bean.Video;
import com.karat.cn.util.IdUtil;
import com.karat.cn.util.TimeUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

public class VideoDemo {
    @Autowired
    private MongoTemplate mongoTemplate;


    @Test
    public void testSelect(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        mongoTemplate = (MongoTemplate) context.getBean("mongoTemplate");

        List<Video> videos=mongoTemplate.findAll(Video.class);

        videos.forEach(i->{
            System.out.print(i);
        });
    }

    @Test
    public void testAdd(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        mongoTemplate = (MongoTemplate) context.getBean("mongoTemplate");
        for(int i=0;i<=10;i++){
            Video s=new Video(IdUtil.getUUID(),"http://pic.in2off50.com/uploads/20190423/5A35473F9A0B3A5A.jpg","小强",
                    TimeUtil.formateMillsecDateToStr(TimeUtil.systemtimeLong()),
                    "http://pic.in2off50.com/uploads/20190424/CAD642A0A702416D.mp4",
                    "当我迷了路，丧失了爱你的勇气。就再也找不到苟延残喘的呼吸。",
                    "21","22");
            mongoTemplate.insert(s);
        }
    }
}
