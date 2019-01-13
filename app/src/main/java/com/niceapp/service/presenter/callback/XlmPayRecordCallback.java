package com.niceapp.service.presenter.callback;

import com.niceapp.model.result.EosPayRecordResult;

public interface XlmPayRecordCallback {

    void xlmPaySuccess(EosPayRecordResult result);

    void xlmPayFail(String message);

}
