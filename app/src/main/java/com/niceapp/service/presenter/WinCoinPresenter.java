package com.niceapp.service.presenter;

import com.niceapp.model.request.BaseRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.model.result.WinCoinResult;
import com.niceapp.service.ServiceGenerator;
import com.niceapp.service.interfaces.IWinCoinService;
import com.niceapp.service.presenter.callback.WinCoinCallback;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class WinCoinPresenter extends BasePresenter {

    private IWinCoinService service = ServiceGenerator.INSTANCE.createService(IWinCoinService.class);

    public void getRobCoin(WinCoinCallback winCoinCallback) {
        SendMessage sendMessage = new SendMessage();
        BaseRequest request = new BaseRequest();
        sendMessage.setData(request);
        registerSubscription(service.getHomeInfo(sendMessage)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResultSubscriber<ResultMessage<WinCoinResult>>() {
                    @Override
                    void onSuccess(ResultMessage<WinCoinResult> winCoinResultResultMessage) {
                        winCoinCallback.Success(winCoinResultResultMessage.getData());
                    }

                    @Override
                    void onFail(ResultMessage.ErrorBean t) {
                        winCoinCallback.Fail(t.getMessage());
                    }
                })
        );

    }
}
