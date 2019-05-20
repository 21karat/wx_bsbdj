package com.karat.cn.bean;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * 段子
 */
@Data
@Document(collection = "segment")
public class Segment  implements Serializable {

    /**主键**/
    private String id;
    /**用户头像**/
    private String userUrl;
    /**用户昵称**/
    private String userName;
    /**创建时间**/
    private String time;
    /**段子内容**/
    private String text;
    /**顶**/
    private String love;
    /**踩**/
    private String hate;

    public Segment() {}

    public Segment(String id,String userUrl, String userName,String time,String text, String love, String hate) {
        this.id=id;
        this.userUrl = userUrl;
        this.userName = userName;
        this.time=time;
        this.text = text;
        this.love = love;
        this.hate = hate;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Segment{" +
                "id='" + id + '\'' +
                ", userUrl='" + userUrl + '\'' +
                ", userName='" + userName + '\'' +
                ", time='" + time + '\'' +
                ", text='" + text + '\'' +
                ", love='" + love + '\'' +
                ", hate='" + hate + '\'' +
                '}';
    }
}
