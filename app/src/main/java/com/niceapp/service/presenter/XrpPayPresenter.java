package com.niceapp.service.presenter;

import com.niceapp.model.request.EthPtEosRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.EosPayRecordResult;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.service.ServiceGenerator;
import com.niceapp.service.interfaces.IXrpPayService;
import com.niceapp.service.presenter.callback.XrpPayRecordCallback;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class XrpPayPresenter extends BasePresenter {

    private IXrpPayService service = ServiceGenerator.INSTANCE.createService(IXrpPayService.class);

    public void RobCoinListInfo(EthPtEosRequest request, XrpPayRecordCallback xrpPayRecordCallback) {
        SendMessage<EthPtEosRequest> sendMessage = new SendMessage<>();
        sendMessage.setData(request);
        registerSubscription(service.getHomeInfo(sendMessage)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResultSubscriber<ResultMessage<EosPayRecordResult>>() {
                    @Override
                    void onSuccess(ResultMessage<EosPayRecordResult> eosPayRecordResultResultMessage) {
                        xrpPayRecordCallback.xrpPaySuccess(eosPayRecordResultResultMessage.getData());
                    }

                    @Override
                    void onFail(ResultMessage.ErrorBean t) {
                        xrpPayRecordCallback.xrpPayFail(t.getMessage());
                    }
                }));
    }
}
