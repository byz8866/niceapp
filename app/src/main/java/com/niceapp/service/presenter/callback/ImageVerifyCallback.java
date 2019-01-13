package com.niceapp.service.presenter.callback;

public interface ImageVerifyCallback {

    void success(byte[] bitmap);

    void fail(String message);

}
