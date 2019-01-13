package com.niceapp.service.presenter.callback;

import com.niceapp.model.result.LuckNumResult;

public interface LuckNumCallback {

    void Success(LuckNumResult data);

    void Fail(String message);

}
