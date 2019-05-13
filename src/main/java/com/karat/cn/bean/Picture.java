package com.karat.cn.bean;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 动图
 */
@Document(collection = "picture")
@Data
public class Picture {

    /**主键**/
    private String id;
    /**用户头像**/
    private String userUrl;
    /**用户昵称**/
    private String userName;
    /**创建时间**/
    private String time;
    /**动图地址**/
    private String image;
    /**动图描述内容**/
    private String text;
    /**顶**/
    private String love;
    /**踩**/
    private String hate;

    public Picture() {
    }

    public Picture(String id, String userUrl, String userName, String time, String image, String text, String love, String hate) {
        this.id = id;
        this.userUrl = userUrl;
        this.userName = userName;
        this.time = time;
        this.image = image;
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
        return "Picture{" +
                "id='" + id + '\'' +
                ", userUrl='" + userUrl + '\'' +
                ", userName='" + userName + '\'' +
                ", time='" + time + '\'' +
                ", image='" + image + '\'' +
                ", text='" + text + '\'' +
                ", love='" + love + '\'' +
                ", hate='" + hate + '\'' +
                '}';
    }
}
