package com.niceapp.service.presenter.callback;

import com.niceapp.model.result.BonusResult;

public interface BonusCallback {

    void Success(BonusResult result);

    void Fail(int code, String message);

}
