package com.niceapp.service.presenter.callback;

import com.niceapp.model.result.EosDepositRecordResult;

public interface XrpDepositRecordCallback {

    void xrpDeposuccess(EosDepositRecordResult recordResult);

    void xrpDepsfail(String message);

}
