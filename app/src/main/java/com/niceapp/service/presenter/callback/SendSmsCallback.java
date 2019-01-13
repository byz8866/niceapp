package com.niceapp.service.presenter.callback;

public interface SendSmsCallback {

    void sendSuccess();

    void fail(String message);

}
