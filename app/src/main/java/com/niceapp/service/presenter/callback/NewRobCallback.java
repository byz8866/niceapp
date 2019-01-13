package com.niceapp.service.presenter.callback;

import com.niceapp.model.result.NewRobResult;

public interface NewRobCallback {

    void NewRobSuccess(NewRobResult result);

    void NewRobFail(int code, String message);

}
