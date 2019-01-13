package com.niceapp.service.presenter;

import com.niceapp.model.request.RobCoinDetailRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.model.result.RobCoinDetailResult;
import com.niceapp.service.ServiceGenerator;
import com.niceapp.service.interfaces.IRobCoinDetailService;
import com.niceapp.service.presenter.callback.RobCoinDetailCallback;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RobCoinDetailPresenter extends BasePresenter {

    private IRobCoinDetailService service = ServiceGenerator.INSTANCE.createService(IRobCoinDetailService.class);

    public void getRobCoinDetail(RobCoinDetailRequest robCoinDetailRequest, RobCoinDetailCallback robCoinDetailCallback) {
        SendMessage<RobCoinDetailRequest> sendMessage = new SendMessage();
        sendMessage.setData(robCoinDetailRequest);
        registerSubscription(service.getRobCoinDetail(sendMessage)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResultSubscriber<ResultMessage<RobCoinDetailResult>>() {
                    @Override
                    void onSuccess(ResultMessage<RobCoinDetailResult> robCoinDetailResultResultMessage) {
                        robCoinDetailCallback.robCoinDetailSuccess(robCoinDetailResultResultMessage.getData());
                    }

                    @Override
                    void onFail(ResultMessage.ErrorBean t) {
                        robCoinDetailCallback.robCoinDetailFail(t.getCode(), t.getMessage());

                    }
                })

        );

    }
}
