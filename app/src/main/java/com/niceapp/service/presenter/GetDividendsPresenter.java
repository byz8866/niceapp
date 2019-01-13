package com.niceapp.service.presenter;

import com.niceapp.model.request.GetBonusRequest;
import com.niceapp.model.request.GetDividendsSuccess;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.service.ServiceGenerator;
import com.niceapp.service.interfaces.IGetDividendsService;
import com.niceapp.service.presenter.callback.GetDividensSuccessCallback;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class GetDividendsPresenter extends BasePresenter {

    private IGetDividendsService service = ServiceGenerator.INSTANCE.createService(IGetDividendsService.class);

    public void register(GetDividensSuccessCallback callback) {
        SendMessage<GetBonusRequest> sendMessage = new SendMessage<>();
        GetBonusRequest request = new GetBonusRequest();
        sendMessage.setData(request);

        registerSubscription(service.getDividendsInfo(sendMessage)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResultSubscriber<ResultMessage<GetDividendsSuccess>>() {
                    @Override
                    void onSuccess(ResultMessage<GetDividendsSuccess> getDividendsSuccessResultMessage) {
                        callback.Success();
                    }

                    @Override
                    void onFail(ResultMessage.ErrorBean t) {
                        callback.Fail(t.getCode(), t.getMessage());

                    }
                })


        );
    }
}
