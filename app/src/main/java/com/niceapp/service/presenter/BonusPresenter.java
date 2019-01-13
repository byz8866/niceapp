package com.niceapp.service.presenter;

import com.niceapp.model.request.BonusRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.BonusResult;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.service.ServiceGenerator;
import com.niceapp.service.interfaces.IBonusService;
import com.niceapp.service.presenter.callback.BonusCallback;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class BonusPresenter extends BasePresenter {

    private IBonusService service = ServiceGenerator.INSTANCE.createService(IBonusService.class);

    public void getBonusInfo(BonusRequest request, BonusCallback bonusCallback) {
        SendMessage<BonusRequest> sendMessage = new SendMessage();
        sendMessage.setData(request);
        registerSubscription(service.getBonusInfo(sendMessage)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResultSubscriber<ResultMessage<BonusResult>>() {

                    @Override
                    void onSuccess(ResultMessage<BonusResult> bonusResultResultMessage) {
                        bonusCallback.Success(bonusResultResultMessage.getData());

                    }

                    @Override
                    void onFail(ResultMessage.ErrorBean t) {
                        bonusCallback.Fail(t.getCode(), t.getMessage());
                    }
                }));


    }

}
