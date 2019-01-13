package com.niceapp.service.presenter;

import com.niceapp.model.request.HpcRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.HpcWithdrawlResult;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.service.ServiceGenerator;
import com.niceapp.service.interfaces.IHpcWithdrawalService;
import com.niceapp.service.presenter.callback.HpcWithdrawalCallback;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class HpcWithdrawalPresenter extends BasePresenter {

    private IHpcWithdrawalService service = ServiceGenerator.INSTANCE.createService(IHpcWithdrawalService.class);


    public void register(HpcRequest request, HpcWithdrawalCallback callback) {
        SendMessage<HpcRequest> sendMessage = new SendMessage<>();
        sendMessage.setData(request);
        registerSubscription(service.register(sendMessage)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResultSubscriber<ResultMessage<HpcWithdrawlResult>>() {
                    @Override
                    void onSuccess(ResultMessage<HpcWithdrawlResult> hpcWithdrawlResultResultMessage) {
                        callback.success();
                    }

                    @Override
                    void onFail(ResultMessage.ErrorBean t) {
                        callback.fail(t.getMessage());
                    }
                })

        );

    }
}
