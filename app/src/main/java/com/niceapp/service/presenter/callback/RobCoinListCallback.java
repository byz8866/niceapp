package com.niceapp.service.presenter.callback;

import com.niceapp.model.result.RobCoinListResult;

public interface RobCoinListCallback {

    void RobCoinListSuccess(RobCoinListResult result);

    void RobCoinListFail(String message);

}
