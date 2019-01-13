package com.niceapp.service.presenter.callback;

import com.niceapp.model.result.WinCoinResult;

public interface WinCoinCallback {

    void Success(WinCoinResult result);

    void Fail(String message);

}
