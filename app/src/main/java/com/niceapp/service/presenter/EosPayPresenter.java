package com.niceapp.service.presenter;

import com.niceapp.model.request.EthPtEosRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.DropFail;
import com.niceapp.model.result.EosPayRecordResult;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.service.ServiceGenerator;
import com.niceapp.service.interfaces.IEosPayService;
import com.niceapp.service.presenter.callback.EosPayCallback;

import org.greenrobot.eventbus.EventBus;

import java.net.ConnectException;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class EosPayPresenter extends BasePresenter {

    private IEosPayService service = ServiceGenerator.INSTANCE.createService(IEosPayService.class);

    public void RobCoinListInfo(EthPtEosRequest request, EosPayCallback eosPayCallback) {
        SendMessage<EthPtEosRequest> sendMessage = new SendMessage<>();
        sendMessage.setData(request);
        registerSubscription(service.getHomeInfo(sendMessage)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResultSubscriber<ResultMessage<EosPayRecordResult>>() {
                    @Override
                    void onSuccess(ResultMessage<EosPayRecordResult> eosPayRecordResultResultMessage) {
                        eosPayCallback.EosPaySuccess(eosPayRecordResultResultMessage.getData());
                    }

                    @Override
                    void onFail(ResultMessage.ErrorBean t) {
                        eosPayCallback.EosPayFail(t.getMessage());
                    }
                }));
    }
}
