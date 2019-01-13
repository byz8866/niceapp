package com.niceapp.service.presenter;

import com.niceapp.model.request.CalculateRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.CalculateResult;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.service.ServiceGenerator;
import com.niceapp.service.interfaces.ICalculateService;
import com.niceapp.service.presenter.callback.CalculateCallback;

import java.net.ConnectException;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class CalculatePresenter extends BasePresenter {

    private ICalculateService service = ServiceGenerator.INSTANCE.createService(ICalculateService.class);

    public void getCalculate(CalculateRequest request, CalculateCallback calculateCallback) {
        SendMessage<CalculateRequest> sendMessage = new SendMessage<>();
        sendMessage.setData(request);
        registerSubscription(service.getCalculateInfo(sendMessage)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResultSubscriber<ResultMessage<CalculateResult>>() {
                    @Override
                    void onSuccess(ResultMessage<CalculateResult> calculateResultResultMessage) {
                        calculateCallback.Success(calculateResultResultMessage.getData());
                    }

                    @Override
                    void onFail(ResultMessage.ErrorBean t) {
                        calculateCallback.Fail(t.getMessage());
                    }
                }));

    }
}
