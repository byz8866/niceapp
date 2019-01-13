package com.niceapp.service.presenter.callback;

import com.niceapp.model.result.OpenDetailsResult;

public interface OpenDetailCallback {

    void preWinnerSuccess(OpenDetailsResult result);

    void preWinnerFail(String message);

}
