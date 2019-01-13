package com.niceapp.service.presenter.callback;

import com.niceapp.model.result.RobResult;

public interface RobCoinCallback {

    void Success(RobResult robResult);

    void Fail(String message);

}
