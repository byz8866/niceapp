package com.niceapp.service.presenter.callback;

import com.niceapp.model.result.EosPayRecordResult;

public interface EosPayCallback {

    void EosPaySuccess(EosPayRecordResult result);

    void EosPayFail(String message);

}
