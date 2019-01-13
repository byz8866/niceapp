package com.niceapp.service.presenter;

import com.niceapp.model.request.EosDepositRecordRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.EosDepositRecordResult;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.service.ServiceGenerator;
import com.niceapp.service.interfaces.IXlmDepositRecordService;
import com.niceapp.service.presenter.callback.XlmDepositRecordCallback;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class XlmDepositRecordPresenter extends BasePresenter {

    private IXlmDepositRecordService service = ServiceGenerator.INSTANCE.createService(IXlmDepositRecordService.class);

    public void register(EosDepositRecordRequest recordRequest, XlmDepositRecordCallback callback) {
        SendMessage<EosDepositRecordRequest> sendMessage = new SendMessage<>();
        sendMessage.setData(recordRequest);
        registerSubscription(service.register(sendMessage)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResultSubscriber<ResultMessage<EosDepositRecordResult>>() {
                    @Override
                    void onSuccess(ResultMessage<EosDepositRecordResult> eosDepositRecordResultResultMessage) {
                        callback.xlmDeposuccess(eosDepositRecordResultResultMessage.getData());
                    }

                    @Override
                    void onFail(ResultMessage.ErrorBean t) {
                        callback.xlmDepsfail(t.getMessage());
                    }
                }));

    }
}
