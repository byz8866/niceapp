package com.niceapp.service.presenter;

import com.niceapp.model.request.GetBonusRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.GetDividendsResult;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.service.ServiceGenerator;
import com.niceapp.service.interfaces.IGetDividendsRecordService;
import com.niceapp.service.presenter.callback.GetDividendsCallback;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class GetDividendsRecordPresenter extends BasePresenter {

    private IGetDividendsRecordService service = ServiceGenerator.INSTANCE.createService(IGetDividendsRecordService.class);

    public void register(GetBonusRequest request, GetDividendsCallback callback) {
        SendMessage<GetBonusRequest> sendMessage = new SendMessage<>();
        sendMessage.setData(request);
        registerSubscription(service.getDividendsInfo(sendMessage)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResultSubscriber<ResultMessage<GetDividendsResult>>() {
                    @Override
                    void onSuccess(ResultMessage<GetDividendsResult> getDividendsResultResultMessage) {
                        callback.Success(getDividendsResultResultMessage.getData());
                    }

                    @Override
                    void onFail(ResultMessage.ErrorBean t) {
                        callback.Fail(t.getCode(), t.getMessage());

                    }
                })


        );
    }
}
