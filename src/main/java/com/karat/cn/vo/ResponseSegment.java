package com.karat.cn.vo;

import com.karat.cn.bean.Segment;
import lombok.Data;

import java.util.List;

@Data
public class ResponseSegment {
    /**总页数**/
    private int totalPage;
    /**段子**/
    private List<Segment> segments;

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setSegments(List<Segment> segments) {
        this.segments = segments;
    }
}
