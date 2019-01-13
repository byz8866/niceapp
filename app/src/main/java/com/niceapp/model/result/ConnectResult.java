package com.niceapp.model.result;

/**
 * 连接状态
 */
public class ConnectResult {

    private boolean isSuccess;

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public ConnectResult(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }
}