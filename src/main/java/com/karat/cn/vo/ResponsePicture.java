package com.karat.cn.vo;

import com.karat.cn.bean.Picture;
import lombok.Data;

import java.util.List;
@Data
public class ResponsePicture {
    /**总页数**/
    private int totalPage;
    /**动图集合**/
    private List<Picture> pictures;

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }
}
