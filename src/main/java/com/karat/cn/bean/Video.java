package com.karat.cn.bean;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 视频
 */
@Data
@Document(collection = "video")
public class Video {

    /**主键**/
    private String id;
    /**用户头像**/
    private String userUrl;
    /**用户昵称**/
    private String userName;
    /**创建时间**/
    private String time;
    /**视频地址**/
    private String videoUrl;
    /**视频描述内容**/
    private String text;
    /**顶**/
    private String love;
    /**踩**/
    private String hate;

    public Video() {
    }

    public Video(String id, String userUrl, String userName, String time, String videoUrl, String text, String love, String hate) {
        this.id = id;
        this.userUrl = userUrl;
        this.userName = userName;
        this.time = time;
        this.videoUrl = videoUrl;
        this.text = text;
        this.love = love;
        this.hate = hate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id='" + id + '\'' +
                ", userUrl='" + userUrl + '\'' +
                ", userName='" + userName + '\'' +
                ", time='" + time + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", text='" + text + '\'' +
                ", love='" + love + '\'' +
                ", hate='" + hate + '\'' +
                '}';
    }
}
