package com.niceapp.service.presenter;

import com.niceapp.model.request.BetCoinRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.OpenDetailsResult;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.service.ServiceGenerator;
import com.niceapp.service.interfaces.IBetCoinService;
import com.niceapp.service.presenter.callback.BetCoinCallback;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class BetCoinPresenter extends BasePresenter {

    private IBetCoinService service = ServiceGenerator.INSTANCE.createService(IBetCoinService.class);

    public void getBetCoin(BetCoinRequest request, BetCoinCallback betCoinCallback) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setData(request);
        registerSubscription(service.getHomeInfo(sendMessage)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResultSubscriber<ResultMessage<OpenDetailsResult>>() {
                    @Override
                    void onSuccess(ResultMessage<OpenDetailsResult> openDetailsResultResultMessage) {
                        betCoinCallback.Success();
                    }

                    @Override
                    void onFail(ResultMessage.ErrorBean t) {
                        betCoinCallback.Fail(t.getCode(), t.getMessage());
                    }
                }));

    }
}
