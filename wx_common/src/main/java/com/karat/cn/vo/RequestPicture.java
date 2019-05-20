package com.karat.cn.vo;

import lombok.Data;

import java.io.File;
import java.io.Serializable;

@Data
public class RequestPicture implements Serializable {

    /**用户头像**/
    private File userUrl;
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

    @Override
    public String toString() {
        return "RequestPicture{" +
                "userUrl=" + userUrl +
                ", userName='" + userName + '\'' +
                ", time='" + time + '\'' +
                ", image='" + image + '\'' +
                ", text='" + text + '\'' +
                ", love='" + love + '\'' +
                ", hate='" + hate + '\'' +
                '}';
    }
}
