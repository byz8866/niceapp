package com.niceapp.service.presenter.callback;

import com.niceapp.model.result.EosDepositRecordResult;

public interface EosDepositRecordCallback {

    void eosDeposuccess(EosDepositRecordResult recordResult);

    void eosDepsfail(String message);

}
