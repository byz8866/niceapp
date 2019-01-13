package com.niceapp.service.presenter;

import com.niceapp.model.request.EthPtEosRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.PtRecordResult;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.service.ServiceGenerator;
import com.niceapp.service.interfaces.IPtService;
import com.niceapp.service.presenter.callback.PtCallback;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class PtPresenter extends BasePresenter {

    private IPtService service = ServiceGenerator.INSTANCE.createService(IPtService.class);

    public void RobCoinListInfo(EthPtEosRequest request, PtCallback PtCallback) {
        SendMessage<EthPtEosRequest> sendMessage = new SendMessage();
        sendMessage.setData(request);
        registerSubscription(service.getHomeInfo(sendMessage)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResultSubscriber<ResultMessage<PtRecordResult>>() {
                    @Override
                    void onSuccess(ResultMessage<PtRecordResult> ptRecordResultResultMessage) {
                        PtCallback.RobCoinListSuccess(ptRecordResultResultMessage.getData());
                    }

                    @Override
                    void onFail(ResultMessage.ErrorBean t) {
                        PtCallback.RobCoinListFail(t.getMessage());
                    }
                })


        );

    }
}
