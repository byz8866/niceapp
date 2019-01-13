package com.niceapp.model.request;

public class BettRecordRequest extends BaseRequest{

    /**
     * pageCount : 10
     * page : 0
     */

    private int pageCount;
    private int page;

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
