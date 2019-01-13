package com.niceapp.service.presenter;

import com.niceapp.model.request.OpenDetailRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.DropFail;
import com.niceapp.model.result.OpenDetailsResult;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.service.ServiceGenerator;
import com.niceapp.service.interfaces.IOpenDetailsService;
import com.niceapp.service.presenter.callback.OpenDetailCallback;

import org.greenrobot.eventbus.EventBus;

import java.net.ConnectException;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class OpenDetailPresenter extends BasePresenter {

    private IOpenDetailsService service = ServiceGenerator.INSTANCE.createService(IOpenDetailsService.class);

    public void getPreWinnerInfo(OpenDetailRequest request, OpenDetailCallback openDetailCallback) {
        SendMessage<OpenDetailRequest> sendMessage = new SendMessage<>();
        sendMessage.setData(request);
        registerSubscription(service.getPreWinner(sendMessage)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResultSubscriber<ResultMessage<OpenDetailsResult>>() {
                    @Override
                    void onSuccess(ResultMessage<OpenDetailsResult> openDetailsResultResultMessage) {
                        openDetailCallback.preWinnerSuccess(openDetailsResultResultMessage.getData());
                    }

                    @Override
                    void onFail(ResultMessage.ErrorBean t) {
                        openDetailCallback.preWinnerFail(t.getMessage());
                    }
                }));

    }
}
