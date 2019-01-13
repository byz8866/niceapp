package com.niceapp.service.presenter;

import com.niceapp.model.request.BaseRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.InviteNumResult;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.service.ServiceGenerator;
import com.niceapp.service.interfaces.IInviteNumService;
import com.niceapp.service.presenter.callback.InviteNumCallback;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class InviterNumPresenter extends BasePresenter {

    private IInviteNumService service = ServiceGenerator.INSTANCE.createService(IInviteNumService.class);

    public void getInviteNum(InviteNumCallback inviteNumCallback) {
        SendMessage sendMessage = new SendMessage();
        BaseRequest request = new BaseRequest();
        sendMessage.setData(request);
        registerSubscription(service.getInviteNum(sendMessage)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResultSubscriber<ResultMessage<InviteNumResult>>() {
                    @Override
                    void onSuccess(ResultMessage<InviteNumResult> inviteNumResultResultMessage) {
                        inviteNumCallback.Success(inviteNumResultResultMessage.getData());
                    }

                    @Override
                    void onFail(ResultMessage.ErrorBean t) {
                        inviteNumCallback.Fail(t.getCode(), t.getMessage());

                    }
                })

        );

    }

}
