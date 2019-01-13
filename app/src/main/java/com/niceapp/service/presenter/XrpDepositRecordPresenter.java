package com.niceapp.service.presenter;

import com.niceapp.model.request.EosDepositRecordRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.EosDepositRecordResult;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.service.ServiceGenerator;
import com.niceapp.service.interfaces.IXrpDepositRecordService;
import com.niceapp.service.presenter.callback.XrpDepositRecordCallback;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class XrpDepositRecordPresenter extends BasePresenter {

    private IXrpDepositRecordService service = ServiceGenerator.INSTANCE.createService(IXrpDepositRecordService.class);

    public void register(EosDepositRecordRequest recordRequest, XrpDepositRecordCallback callback) {
        SendMessage<EosDepositRecordRequest> sendMessage = new SendMessage<>();
        sendMessage.setData(recordRequest);
        registerSubscription(service.register(sendMessage)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResultSubscriber<ResultMessage<EosDepositRecordResult>>() {
                    @Override
                    void onSuccess(ResultMessage<EosDepositRecordResult> eosDepositRecordResultResultMessage) {
                        callback.xrpDeposuccess(eosDepositRecordResultResultMessage.getData());
                    }

                    @Override
                    void onFail(ResultMessage.ErrorBean t) {
                        callback.xrpDepsfail(t.getMessage());
                    }
                }));

    }
}
