package com.niceapp.service.presenter.callback;

import com.niceapp.model.result.CalculateResult;

public interface CalculateCallback {

    void Success(CalculateResult result);

    void Fail(String message);

}
