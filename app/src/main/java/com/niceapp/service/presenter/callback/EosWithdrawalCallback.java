package com.niceapp.service.presenter.callback;

public interface EosWithdrawalCallback {

    void EosWithdrawSuccess();

    void EosWithdrawFail(String message);

}
