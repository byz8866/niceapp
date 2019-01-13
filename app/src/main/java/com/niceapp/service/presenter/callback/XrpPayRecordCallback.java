package com.niceapp.service.presenter.callback;

import com.niceapp.model.result.EosPayRecordResult;

public interface XrpPayRecordCallback {

    void xrpPaySuccess(EosPayRecordResult result);

    void xrpPayFail(String message);

}
