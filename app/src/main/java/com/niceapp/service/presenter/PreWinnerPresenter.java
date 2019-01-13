package com.niceapp.service.presenter;

import com.niceapp.model.request.PlayRecordRequest;
import com.niceapp.model.request.PreWinnerRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.PlayRecordResult;
import com.niceapp.model.result.PreWinnerResult;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.service.ServiceGenerator;
import com.niceapp.service.interfaces.IPreWinnerService;
import com.niceapp.service.presenter.callback.PlayRecordCallback;
import com.niceapp.service.presenter.callback.PreWinnerCallback;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class PreWinnerPresenter extends BasePresenter {

    private IPreWinnerService service = ServiceGenerator.INSTANCE.createService(IPreWinnerService.class);

    public void getPreWinnerInfo(PreWinnerRequest request, PreWinnerCallback preWinnerCallback) {
        SendMessage<PreWinnerRequest> sendMessage = new SendMessage<>();
        sendMessage.setData(request);
        registerSubscription(service.getPreWinner(sendMessage)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResultSubscriber<ResultMessage<PreWinnerResult>>() {
                    @Override
                    void onSuccess(ResultMessage<PreWinnerResult> preWinnerResultResultMessage) {
                        preWinnerCallback.preWinnerSuccess(preWinnerResultResultMessage.getData());
                    }

                    @Override
                    void onFail(ResultMessage.ErrorBean t) {
                        preWinnerCallback.preWinnerFail(t.getMessage());
                    }
                })
        );

    }


    public void getPlayRecord(PlayRecordRequest request, PlayRecordCallback playRecordCallback) {
        SendMessage<PlayRecordRequest> sendMessage = new SendMessage<>();
        sendMessage.setData(request);
        registerSubscription(service.getPlayRecord(sendMessage)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResultSubscriber<ResultMessage<PlayRecordResult>>() {
                    @Override
                    void onSuccess(ResultMessage<PlayRecordResult> playRecordResultResultMessage) {
                        playRecordCallback.playRecordSuccess(playRecordResultResultMessage.getData());
                    }

                    @Override
                    void onFail(ResultMessage.ErrorBean t) {
                        playRecordCallback.playRecordFail(t.getMessage());
                    }
                })
        );

    }
}
