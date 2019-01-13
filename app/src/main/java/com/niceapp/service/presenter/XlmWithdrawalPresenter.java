package com.niceapp.service.presenter;

import com.niceapp.model.request.EosWithdrawalRequest;
import com.niceapp.model.request.EosWithdrawalResult;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.service.ServiceGenerator;
import com.niceapp.service.interfaces.IXlmWithdrawalService;
import com.niceapp.service.presenter.callback.XlmWithdrawalCallback;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class XlmWithdrawalPresenter extends BasePresenter {

    private IXlmWithdrawalService service = ServiceGenerator.INSTANCE.createService(IXlmWithdrawalService.class);

    public void RobCoinListInfo(EosWithdrawalRequest request, XlmWithdrawalCallback xrpWithdrawalCallback) {
        SendMessage<EosWithdrawalRequest> sendMessage = new SendMessage();
        sendMessage.setData(request);
        registerSubscription(service.getHomeInfo(sendMessage)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResultSubscriber<ResultMessage<EosWithdrawalResult>>() {
                    @Override
                    void onSuccess(ResultMessage<EosWithdrawalResult> eosWithdrawalResultResultMessage) {
                        xrpWithdrawalCallback.xlmWithdrawSuccess();
                    }

                    @Override
                    void onFail(ResultMessage.ErrorBean t) {
                        xrpWithdrawalCallback.xlmWithdrawFail(t.getMessage());
                    }
                })
        );
    }
}
