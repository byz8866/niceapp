package com.niceapp.service.presenter.callback;

import com.niceapp.model.result.PtRecordResult;

public interface PtCallback {

    void RobCoinListSuccess(PtRecordResult result);

    void RobCoinListFail(String message);

}
