package com.niceapp.service.presenter;

import com.niceapp.model.request.BaseRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.Home2Result;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.service.ServiceGenerator;
import com.niceapp.service.interfaces.IHomeService;
import com.niceapp.service.presenter.callback.HomePageCallback;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class HomePresenter extends BasePresenter {

    private IHomeService service = ServiceGenerator.INSTANCE.createService(IHomeService.class);

    public void getHomeInfo(HomePageCallback homePageCallback) {
        SendMessage sendMessage = new SendMessage();
        BaseRequest request = new BaseRequest();
        sendMessage.setData(request);

        registerSubscription(service.getHomeInfo(sendMessage)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResultSubscriber<ResultMessage<Home2Result>>() {
                    @Override
                    void onSuccess(ResultMessage<Home2Result> home2ResultResultMessage) {
                        homePageCallback.homeSuccess(home2ResultResultMessage.getData());
                    }

                    @Override
                    void onFail(ResultMessage.ErrorBean t) {
                        homePageCallback.homeFail(t.getMessage());
                    }
                })

        );

    }
}
