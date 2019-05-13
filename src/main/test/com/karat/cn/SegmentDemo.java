package com.karat.cn;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.karat.cn.bean.Segment;
import com.karat.cn.util.ConnectionUtil;
import com.karat.cn.util.IdUtil;
import com.karat.cn.util.TimeUtil;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SegmentDemo {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Test
    public void testSelect(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        mongoTemplate = (MongoTemplate) context.getBean("mongoTemplate");

        List<Segment> segmentList=mongoTemplate.findAll(Segment.class);

        segmentList.forEach(i->{
            System.out.print(i);
            i.setTime(TimeUtil.formateMillsecDateToStr(TimeUtil.systemtimeLong()));
            i.setUserName("小明");
            i.setText("刚才在QQ上有个还在上大学的姑娘突然跟我讲：“朋友介绍我去打工，今天晚上要到一个酒吧领舞，现在有点不敢去。”我：“有什么不敢去的？”姑娘：“刚才在小摊上只吃了碗牛肉面，怕到时候饿。”──姑娘，你心太宽了！");
            mongoTemplate.save(i);
        });
    }

    @Test
    public void testAdd(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        mongoTemplate = (MongoTemplate) context.getBean("mongoTemplate");
        Segment s=new Segment(IdUtil.getUUID(),"2","2", TimeUtil.formateMillsecDateToStr(TimeUtil.systemtimeLong()),"2","21","22");
        mongoTemplate.insert(s);
    }

    @Test
    public void duanzi(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        mongoTemplate = (MongoTemplate) context.getBean("mongoTemplate");
        for (int i = 1; i <= 10; i++) {
            System.out.println("正在爬取第" + i + "页内容。。。");
            // 建立连接，获取网页内容
            String html = ConnectionUtil.Connect("https://www.pengfu.com/xiaohua_" + i + ".html");
            // 将内容转换成dom格式，方便操作
            Document doc = Jsoup.parse(html);
            // 获取网页内所有标题节点
            Elements titles = doc.select("h1.dp-b");
            for (Element titleEle : titles) {
                Element parent = titleEle.parent();
                // 标题内容
                String title = titleEle.getElementsByTag("a").text();
                // 标题对应的作者
                String author = parent.select("p.user_name_list > a").text();
                // 标题对应的正文
                String content = parent.select("div.content-img").text();
                System.out.println(title+"=="+author+"&&&&&"+content);

                //随机点击量
                String click=String.valueOf((int)(100+Math.random()*(1000-100+100)));


                Segment s=new Segment(IdUtil.getUUID(),title,author, TimeUtil.formateMillsecDateToStr(TimeUtil.systemtimeLong()),content,click,click);
                mongoTemplate.insert(s);
            }
        }
    }
}
