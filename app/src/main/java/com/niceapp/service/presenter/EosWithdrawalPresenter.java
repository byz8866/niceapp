package com.niceapp.service.presenter;

import com.niceapp.model.request.EosWithdrawalRequest;
import com.niceapp.model.request.EosWithdrawalResult;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.service.ServiceGenerator;
import com.niceapp.service.interfaces.IEosWithdrawalService;
import com.niceapp.service.presenter.callback.EosWithdrawalCallback;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class EosWithdrawalPresenter extends BasePresenter {

    private IEosWithdrawalService service = ServiceGenerator.INSTANCE.createService(IEosWithdrawalService.class);

    public void RobCoinListInfo(EosWithdrawalRequest request, EosWithdrawalCallback eosWithdrawalCallback) {
        SendMessage<EosWithdrawalRequest> sendMessage = new SendMessage();
        sendMessage.setData(request);
        registerSubscription(service.getHomeInfo(sendMessage)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

                .subscribe(new ResultSubscriber<ResultMessage<EosWithdrawalResult>>() {
                    @Override
                    void onSuccess(ResultMessage<EosWithdrawalResult> eosWithdrawalResultResultMessage) {
                        eosWithdrawalCallback.EosWithdrawSuccess();
                    }

                    @Override
                    void onFail(ResultMessage.ErrorBean t) {
                        eosWithdrawalCallback.EosWithdrawFail(t.getMessage());
                    }
                })


        );

    }
}
