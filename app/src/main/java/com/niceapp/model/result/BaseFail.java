package com.niceapp.model.result;

class BaseFail {

    private ResultMessage.ErrorBean errorBean;

    public BaseFail() {
    }

    public BaseFail(ResultMessage.ErrorBean errorBean) {
        this.errorBean = errorBean;
    }

    public ResultMessage.ErrorBean getErrorBean() {
        return errorBean;
    }

    public void setErrorBean(ResultMessage.ErrorBean errorBean) {
        this.errorBean = errorBean;
    }
}