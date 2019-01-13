package com.niceapp.service.presenter.callback;

public interface BetCoinCallback {

    void Success();

    void Fail(int code,String message);

}
