package com.karat.cn.vo;

import com.karat.cn.bean.Video;
import lombok.Data;

import java.util.List;
@Data
public class ResponseVideo {
    /**总页数**/
    private int totalPage;
    /**视频集合**/
    private List<Video> videos;

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
}
