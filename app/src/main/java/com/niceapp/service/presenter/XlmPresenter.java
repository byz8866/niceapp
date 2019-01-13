package com.niceapp.service.presenter;

import com.niceapp.model.request.EthPtEosRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.EosRecordResult;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.service.ServiceGenerator;
import com.niceapp.service.interfaces.IEosService;
import com.niceapp.service.interfaces.IXlmService;
import com.niceapp.service.presenter.callback.EosCallback;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class XlmPresenter extends BasePresenter {

    private IXlmService service = ServiceGenerator.INSTANCE.createService(IXlmService.class);

    public void RobCoinListInfo(EthPtEosRequest request, EosCallback EosCallback) {
        SendMessage<EthPtEosRequest> sendMessage = new SendMessage();
        sendMessage.setData(request);
        registerSubscription(service.getHomeInfo(sendMessage)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResultSubscriber<ResultMessage<EosRecordResult>>() {
                    @Override
                    void onSuccess(ResultMessage<EosRecordResult> eosRecordResultResultMessage) {
                        EosCallback.RobCoinListSuccess(eosRecordResultResultMessage.getData());
                    }

                    @Override
                    void onFail(ResultMessage.ErrorBean t) {
                        EosCallback.RobCoinListFail(t.getMessage());
                    }
                }));
    }
}
