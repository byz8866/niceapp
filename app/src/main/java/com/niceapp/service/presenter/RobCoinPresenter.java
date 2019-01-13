package com.niceapp.service.presenter;

import com.niceapp.model.request.BettRecordRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.model.result.RobResult;
import com.niceapp.service.ServiceGenerator;
import com.niceapp.service.interfaces.IRobService;
import com.niceapp.service.presenter.callback.RobCoinCallback;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RobCoinPresenter extends BasePresenter {

    private IRobService service = ServiceGenerator.INSTANCE.createService(IRobService.class);

    public void getRobCoin(BettRecordRequest request, RobCoinCallback robCoinCallback) {
        SendMessage<BettRecordRequest> sendMessage = new SendMessage();
        sendMessage.setData(request);
        registerSubscription(service.getHomeInfo(sendMessage)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResultSubscriber<ResultMessage<RobResult>>() {
                    @Override
                    void onSuccess(ResultMessage<RobResult> robResultResultMessage) {
                        robCoinCallback.Success(robResultResultMessage.getData());
                    }

                    @Override
                    void onFail(ResultMessage.ErrorBean t) {
                        robCoinCallback.Fail(t.getMessage());
                    }
                })
        );

    }
}
