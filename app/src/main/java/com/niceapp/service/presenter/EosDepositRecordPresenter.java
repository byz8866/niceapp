package com.niceapp.service.presenter;

import com.niceapp.model.request.EosDepositRecordRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.DropFail;
import com.niceapp.model.result.EosDepositRecordResult;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.service.ServiceGenerator;
import com.niceapp.service.interfaces.IEosDepositRecordService;
import com.niceapp.service.presenter.callback.EosDepositRecordCallback;

import org.greenrobot.eventbus.EventBus;

import java.net.ConnectException;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class EosDepositRecordPresenter extends BasePresenter {

    private IEosDepositRecordService service = ServiceGenerator.INSTANCE.createService(IEosDepositRecordService.class);


    public void register(EosDepositRecordRequest recordRequest, EosDepositRecordCallback callback) {
        SendMessage<EosDepositRecordRequest> sendMessage = new SendMessage<>();
        sendMessage.setData(recordRequest);
        registerSubscription(service.register(sendMessage)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResultSubscriber<ResultMessage<EosDepositRecordResult>>() {
                    @Override
                    void onSuccess(ResultMessage<EosDepositRecordResult> eosDepositRecordResultResultMessage) {
                        callback.eosDeposuccess(eosDepositRecordResultResultMessage.getData());
                    }

                    @Override
                    void onFail(ResultMessage.ErrorBean t) {
                        callback.eosDepsfail(t.getMessage());
                    }
                }));

    }
}
