package com.niceapp.service.presenter;

import com.niceapp.model.request.BaseRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.HpcDepositRecordResult;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.service.ServiceGenerator;
import com.niceapp.service.interfaces.IHpcDepositRecordService;
import com.niceapp.service.presenter.callback.HpcDepositRecordCallback;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class HpcDepositRecordPresenter extends BasePresenter {

    private IHpcDepositRecordService service = ServiceGenerator.INSTANCE.createService(IHpcDepositRecordService.class);


    public void register(HpcDepositRecordCallback callback) {
        SendMessage sendMessage = new SendMessage<>();
        BaseRequest request = new BaseRequest();
        sendMessage.setData(request);
        registerSubscription(service.register(sendMessage)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResultSubscriber<ResultMessage<HpcDepositRecordResult>>() {
                    @Override
                    void onSuccess(ResultMessage<HpcDepositRecordResult> hpcDepositRecordResultResultMessage) {
                        callback.success(hpcDepositRecordResultResultMessage.getData());
                    }

                    @Override
                    void onFail(ResultMessage.ErrorBean t) {
                        callback.fail(t.getMessage());
                    }
                })


        );

    }
}
