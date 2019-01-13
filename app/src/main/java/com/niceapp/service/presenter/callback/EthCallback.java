package com.niceapp.service.presenter.callback;

import com.niceapp.model.result.EthRecordResult;

public interface EthCallback {

    void RobCoinListSuccess(EthRecordResult result);

    void RobCoinListFail(String message);

}
