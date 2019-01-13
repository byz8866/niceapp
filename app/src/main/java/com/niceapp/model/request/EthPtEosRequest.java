package com.niceapp.model.request;

public class EthPtEosRequest extends BaseRequest {

    /**
     * pageCount : 10
     * page : 0
     */

    private String pageCount;
    private String page;

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
