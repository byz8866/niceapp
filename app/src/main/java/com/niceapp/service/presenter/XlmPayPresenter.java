package com.niceapp.service.presenter;

import com.niceapp.model.request.EthPtEosRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.EosPayRecordResult;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.service.ServiceGenerator;
import com.niceapp.service.interfaces.IEosPayService;
import com.niceapp.service.interfaces.IXlmPayService;
import com.niceapp.service.presenter.callback.EosPayCallback;
import com.niceapp.service.presenter.callback.XlmPayRecordCallback;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class XlmPayPresenter extends BasePresenter {

    private IXlmPayService service = ServiceGenerator.INSTANCE.createService(IXlmPayService.class);

    public void RobCoinListInfo(EthPtEosRequest request, XlmPayRecordCallback xlmPayRecordCallback) {
        SendMessage<EthPtEosRequest> sendMessage = new SendMessage<>();
        sendMessage.setData(request);
        registerSubscription(service.getHomeInfo(sendMessage)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResultSubscriber<ResultMessage<EosPayRecordResult>>() {
                    @Override
                    void onSuccess(ResultMessage<EosPayRecordResult> eosPayRecordResultResultMessage) {
                        xlmPayRecordCallback.xlmPaySuccess(eosPayRecordResultResultMessage.getData());
                    }

                    @Override
                    void onFail(ResultMessage.ErrorBean t) {
                        xlmPayRecordCallback.xlmPayFail(t.getMessage());
                    }
                }));
    }
}
