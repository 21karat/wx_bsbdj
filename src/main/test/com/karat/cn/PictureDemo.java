package com.karat.cn;

import com.karat.cn.bean.Picture;
import com.karat.cn.bean.Segment;
import com.karat.cn.util.IdUtil;
import com.karat.cn.util.TimeUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

public class PictureDemo {
    @Autowired
    private MongoTemplate mongoTemplate;


    @Test
    public void testSelect(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        mongoTemplate = (MongoTemplate) context.getBean("mongoTemplate");

        List<Picture> segmentList=mongoTemplate.findAll(Picture.class);

        segmentList.forEach(i->{
            System.out.print(i);
        });
    }

    @Test
    public void testAdd(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        mongoTemplate = (MongoTemplate) context.getBean("mongoTemplate");
        for(int i=0;i<=10;i++){
            Picture s=new Picture(IdUtil.getUUID(),"http://pic.in2off50.com/uploads/20190423/5A35473F9A0B3A5A.jpg",
                    "小明", TimeUtil.formateMillsecDateToStr(TimeUtil.systemtimeLong()),"http://pic.in2off50.com/uploads/20190423/5A35473F9A0B3A5A.jpg",
                    "重帏深下莫愁堂，卧后清宵细细长。神女生涯原是梦，小姑居处本无郎。风波不信菱枝弱，月露谁教桂叶香。直道相思了无益，未妨惆怅是清狂。","21","22");
            mongoTemplate.insert(s);
        }
    }
}
