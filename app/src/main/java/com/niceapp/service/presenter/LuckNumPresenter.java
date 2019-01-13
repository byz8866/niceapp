package com.niceapp.service.presenter;

import com.niceapp.model.request.LuckNumRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.LuckNumResult;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.service.ServiceGenerator;
import com.niceapp.service.interfaces.ILuckNumService;
import com.niceapp.service.presenter.callback.LuckNumCallback;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LuckNumPresenter extends BasePresenter {

    private ILuckNumService service = ServiceGenerator.INSTANCE.createService(ILuckNumService.class);

    public void getLcukNum(LuckNumRequest request, LuckNumCallback luckNumCallback) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setData(request);
        registerSubscription(service.getLuckNum(sendMessage)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResultSubscriber<ResultMessage<LuckNumResult>>() {
                    @Override
                    void onSuccess(ResultMessage<LuckNumResult> luckNumResultResultMessage) {
                        luckNumCallback.Success(luckNumResultResultMessage.getData());
                    }

                    @Override
                    void onFail(ResultMessage.ErrorBean t) {
                        luckNumCallback.Fail(t.getMessage());
                    }
                })
        );
    }
}
