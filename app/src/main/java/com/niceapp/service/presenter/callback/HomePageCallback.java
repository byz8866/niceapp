package com.niceapp.service.presenter.callback;

import com.niceapp.model.result.Home2Result;

public interface HomePageCallback {

    void homeSuccess(Home2Result homeResultMessage);

    void homeFail(String message);

}
