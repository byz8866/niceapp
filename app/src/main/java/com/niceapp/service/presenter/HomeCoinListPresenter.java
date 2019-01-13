package com.niceapp.service.presenter;

import com.niceapp.model.request.RobCoinRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.model.result.RobCoinListResult;
import com.niceapp.service.ServiceGenerator;
import com.niceapp.service.interfaces.IHomeCoinListService;
import com.niceapp.service.presenter.callback.RobCoinListCallback;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class HomeCoinListPresenter extends BasePresenter {

    private IHomeCoinListService service = ServiceGenerator.INSTANCE.createService(IHomeCoinListService.class);

    public void RobCoinListInfo(RobCoinRequest request, RobCoinListCallback robCoinListCallback) {
        SendMessage<RobCoinRequest> sendMessage = new SendMessage();
        sendMessage.setData(request);
        registerSubscription(service.getHomeInfo(sendMessage)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResultSubscriber<ResultMessage<RobCoinListResult>>() {
                    @Override
                    void onSuccess(ResultMessage<RobCoinListResult> robCoinListResultResultMessage) {
                        robCoinListCallback.RobCoinListSuccess(robCoinListResultResultMessage.getData());
                    }

                    @Override
                    void onFail(ResultMessage.ErrorBean t) {
                        robCoinListCallback.RobCoinListFail(t.getMessage());
                    }
                })

        );

    }
}
