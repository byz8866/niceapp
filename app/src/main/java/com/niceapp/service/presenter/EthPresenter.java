package com.niceapp.service.presenter;

import com.niceapp.model.request.EthPtEosRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.EthRecordResult;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.service.ServiceGenerator;
import com.niceapp.service.interfaces.IEthService;
import com.niceapp.service.presenter.callback.EthCallback;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class EthPresenter extends BasePresenter {

    private IEthService service = ServiceGenerator.INSTANCE.createService(IEthService.class);

    public void RobCoinListInfo(EthPtEosRequest request, EthCallback ptCallback) {
        SendMessage<EthPtEosRequest> sendMessage = new SendMessage();
        sendMessage.setData(request);
        registerSubscription(service.getHomeInfo(sendMessage)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResultSubscriber<ResultMessage<EthRecordResult>>() {
                    @Override
                    void onSuccess(ResultMessage<EthRecordResult> ethRecordResultResultMessage) {
                        ptCallback.RobCoinListSuccess(ethRecordResultResultMessage.getData());
                    }

                    @Override
                    void onFail(ResultMessage.ErrorBean t) {
                        ptCallback.RobCoinListFail(t.getMessage());
                    }
                })

        );

    }
}
