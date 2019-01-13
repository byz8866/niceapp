package com.niceapp.service.presenter.callback;

import com.niceapp.model.result.EosRecordResult;

public interface EosCallback {

    void RobCoinListSuccess(EosRecordResult result);

    void RobCoinListFail(String message);

}
