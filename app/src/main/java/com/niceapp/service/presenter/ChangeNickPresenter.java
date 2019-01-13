package com.niceapp.service.presenter;

import com.niceapp.model.request.ChangeNickRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.DropFail;
import com.niceapp.model.result.OpenDetailsResult;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.service.ServiceGenerator;
import com.niceapp.service.interfaces.IChangeNickService;
import com.niceapp.service.presenter.callback.ChangeNickCallback;

import org.greenrobot.eventbus.EventBus;

import java.net.ConnectException;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ChangeNickPresenter extends BasePresenter {

    private IChangeNickService service = ServiceGenerator.INSTANCE.createService(IChangeNickService.class);


    public void ChangeNick(ChangeNickRequest request, ChangeNickCallback changeNickCallback) {
        SendMessage<ChangeNickRequest> sendMessage = new SendMessage();
        sendMessage.setData(request);
        registerSubscription(service.changeNick(sendMessage)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResultSubscriber<ResultMessage>() {
                    @Override
                    void onSuccess(ResultMessage openDetailsResultResultMessage) {
                        changeNickCallback.Success();
                    }

                    @Override
                    void onFail(ResultMessage.ErrorBean t) {
                        changeNickCallback.Fail(t.getCode(), t.getMessage());
                    }
                }));

    }
}
