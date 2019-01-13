package com.niceapp.service.presenter.callback;

import com.niceapp.model.result.InviteNumResult;

public interface InviteNumCallback {

    void Success(InviteNumResult result);

    void Fail(int code, String message);

}
