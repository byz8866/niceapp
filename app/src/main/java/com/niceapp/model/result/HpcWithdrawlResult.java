package com.niceapp.model.result;

public class HpcWithdrawlResult {


    /**
     * result : success
     * data : {"hash":"0x18b24ef420ed3d999b2530f8208ada5878d075d09b5c83792d372ddbba5ccc95"}
     */

    private String result;
    private DataBean data;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * hash : 0x18b24ef420ed3d999b2530f8208ada5878d075d09b5c83792d372ddbba5ccc95
         */

        private String hash;

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }
    }
}
