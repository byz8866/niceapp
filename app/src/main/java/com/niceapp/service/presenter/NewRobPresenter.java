package com.niceapp.service.presenter;

import com.niceapp.model.request.NewRobRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.NewRobResult;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.service.ServiceGenerator;
import com.niceapp.service.interfaces.INewRobService;
import com.niceapp.service.presenter.callback.NewRobCallback;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NewRobPresenter extends BasePresenter {

    private INewRobService service = ServiceGenerator.INSTANCE.createService(INewRobService.class);


    public void getNewRobInfo(NewRobRequest request, NewRobCallback newRobCallback) {
        SendMessage<NewRobRequest> sendMessage = new SendMessage();
        sendMessage.setData(request);
        registerSubscription(service.getNewRobInfo(sendMessage)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResultSubscriber<ResultMessage<NewRobResult>>() {
                    @Override
                    void onSuccess(ResultMessage<NewRobResult> newRobResultResultMessage) {
                        newRobCallback.NewRobSuccess(newRobResultResultMessage.getData());
                    }

                    @Override
                    void onFail(ResultMessage.ErrorBean t) {
                        newRobCallback.NewRobFail(t.getCode(), t.getMessage());

                    }
                })


        );
    }
}
