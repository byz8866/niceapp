package com.niceapp.service.presenter.callback;

import com.niceapp.model.result.PreWinnerResult;

public interface PreWinnerCallback {

    void preWinnerSuccess(PreWinnerResult result);

    void preWinnerFail(String message);

}
