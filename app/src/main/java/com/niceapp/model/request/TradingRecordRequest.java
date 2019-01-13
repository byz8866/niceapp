package com.niceapp.model.request;

public class TradingRecordRequest extends BaseRequest{


    /**
     * page : 1
     * pageCount : 10
     */

    private int page;
    private int pageCount;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

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
}
