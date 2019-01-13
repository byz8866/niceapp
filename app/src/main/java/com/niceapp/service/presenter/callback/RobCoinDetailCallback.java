package com.niceapp.service.presenter.callback;

import com.niceapp.model.result.RobCoinDetailResult;

public interface RobCoinDetailCallback {

    void robCoinDetailSuccess(RobCoinDetailResult result);

    void robCoinDetailFail(int a, String message);

}
