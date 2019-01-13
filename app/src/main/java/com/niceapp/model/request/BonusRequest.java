package com.niceapp.model.request;

public class BonusRequest extends BaseRequest{

    /**
     * page : 0
     * pageCount : 10
     * area : 3     1A   2B  3C
     * type : 2     1eth   2pt   3eos
     */

    private int page;
    private int pageCount;
    private int area;
    private int type;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
