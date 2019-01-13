package com.niceapp.service.presenter.callback;

import com.niceapp.model.result.GetDividendsResult;

public interface GetDividensSuccessCallback {

    void Success();

    void Fail(int code, String message);

}
