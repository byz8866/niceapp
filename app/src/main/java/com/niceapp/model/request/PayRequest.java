package com.niceapp.model.request;

public class PayRequest extends BaseRequest{


    /**
     * page : 1
     * pageCount : 10
     */

    private int page;
    private int pageCount;

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
