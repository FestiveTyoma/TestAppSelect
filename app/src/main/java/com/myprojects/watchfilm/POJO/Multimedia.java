package com.myprojects.watchfilm.POJO;


public class Multimedia {

    @com.squareup.moshi.Json(name = "type")
    private String type;
    @com.squareup.moshi.Json(name = "src")
    private String src;
    @com.squareup.moshi.Json(name = "height")
    private Integer height;
    @com.squareup.moshi.Json(name = "width")
    private Integer width;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

}
