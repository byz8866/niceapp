package com.niceapp.service.presenter.callback;

import com.niceapp.model.result.HpcDepositRecordResult;

public interface HpcDepositRecordCallback {

    void success(HpcDepositRecordResult recordResult);

    void fail(String message);

}
