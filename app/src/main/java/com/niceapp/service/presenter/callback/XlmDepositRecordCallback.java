package com.niceapp.service.presenter.callback;

import com.niceapp.model.result.EosDepositRecordResult;

public interface XlmDepositRecordCallback {

    void xlmDeposuccess(EosDepositRecordResult recordResult);

    void xlmDepsfail(String message);

}
