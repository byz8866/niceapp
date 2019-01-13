package com.niceapp.service.presenter.callback;

import com.niceapp.model.result.GetDividendsResult;

public interface GetDividendsCallback {

    void Success(GetDividendsResult result);

    void Fail(int s,String message);

}
