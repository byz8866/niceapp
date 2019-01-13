package com.niceapp.service.presenter;

import com.niceapp.model.request.SendMessage;
import com.niceapp.model.request.UpdateEailRequest;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.service.ServiceGenerator;
import com.niceapp.service.interfaces.IUpDateEmailService;
import com.niceapp.service.presenter.callback.UpDateEmailCallback;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class UpDateEmailPresenter extends BasePresenter {

    private IUpDateEmailService service = ServiceGenerator.INSTANCE.createService(IUpDateEmailService.class);


    public void upDateEmail(UpdateEailRequest updateEailRequest, UpDateEmailCallback callback) {
        SendMessage<UpdateEailRequest> sendMessage = new SendMessage<>();
        sendMessage.setData(updateEailRequest);
        registerSubscription(service.register(sendMessage)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResultSubscriber<ResultMessage>() {
                    @Override
                    void onSuccess(ResultMessage resultMessage) {
                        callback.success();
                    }

                    @Override
                    void onFail(ResultMessage.ErrorBean t) {
                        callback.fail(t.getMessage());
                    }
                })
        );
    }
}
