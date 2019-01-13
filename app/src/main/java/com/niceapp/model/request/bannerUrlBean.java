package com.niceapp.model.request;

public class bannerUrlBean {

    /**
     * id : 3
     * jumpUrl :
     * type : 1
     * url : http://www.jiedianyule.com/images/homebanner_3.png
     */

    private int id;
    private String jumpUrl;
    private int type;
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJumpUrl() {
        return jumpUrl;
    }

    public void setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
