package com.karat.cn.action.wx;

import com.alibaba.fastjson.JSON;
import com.karat.cn.bean.Segment;
import com.karat.cn.service.SegmentService;

import com.karat.cn.vo.ResponseSegment;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("sa")
@Api("段子接口")
public class SegmentAction {

    @Autowired
    SegmentService segmentService;

    /**
     * 查看所有
     * @return
     */
    @RequestMapping(value = "select",method= RequestMethod.POST,produces="html/text;charset=UTF-8")
    public String select(String pageNum,String pageSize){
        ResponseSegment response=new ResponseSegment();
        List<Segment> segments=null;
        if(pageNum==null||pageSize==null){
            segments=segmentService.select();
        }else{
            segments=segmentService.selectPage(pageNum,pageSize);
        }
        if(segments.size()>0){
            response.setTotalPage(segmentService.selectAllNum());
            response.setSegments(segments);
        }
        return JSON.toJSONString(response);
    }

    /**
     * 添加
     * @param segment
     * @return
     */
    @RequestMapping(value = "add",method = RequestMethod.POST,produces="html/text;charset=UTF-8")
    public String add(Segment segment){
        return JSON.toJSONString(segmentService.add(segment));
    }

}
