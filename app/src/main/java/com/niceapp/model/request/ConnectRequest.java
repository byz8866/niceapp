package com.niceapp.model.request;

public class ConnectRequest extends BaseRequest{

    private boolean isConnect = false ;

    public ConnectRequest() {
    }

    public ConnectRequest(boolean isConnect) {
        this.isConnect = isConnect;
    }

    public ConnectRequest(int reCount) {
        this.reCount = reCount;
    }

    private int reCount;

    public int getReCount() {
        return reCount;
    }

    public void setReCount(int reCount) {
        this.reCount = reCount;
    }

    public boolean isConnect() {
        return isConnect;
    }

    public void setConnect(boolean connect) {
        isConnect = connect;
    }
}
