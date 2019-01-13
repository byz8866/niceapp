package com.niceapp.service.presenter;

import com.niceapp.base.ActivityManager;
import com.niceapp.main.activity.MainActivity;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.view.user.message.MessageDrop;

import org.greenrobot.eventbus.EventBus;

import java.net.ConnectException;

import rx.Subscriber;

public abstract class ResultSubscriber<T extends ResultMessage> extends Subscriber<T> {


    @Override
    final public void onCompleted() {

    }

    @Override
    final public void onError(Throwable e) {
        ResultMessage.ErrorBean errorBean = new ResultMessage.ErrorBean();
        errorBean.setCode(-1);
        errorBean.setMessage(errorBean.getMessage());
        if (e instanceof ConnectException) {
            errorBean.setMessage("网络连接错误");
        }
        onFail(errorBean);
    }

    @Override
    final public void onNext(T t) {
        if (!t.getResult().equalsIgnoreCase("success")) {
            if (t.getError().getCode() == 10029) {
                ActivityManager.Companion.getInstance().finishAllActivityWithOutThis(MainActivity.class);
                //发通知
                MessageDrop dropFail = new MessageDrop();
                EventBus.getDefault().post(dropFail);

            } else {
                onFail(t.getError());
            }
        } else {
            onSuccess(t);
        }

    }

    abstract void onSuccess(T t);

    abstract void onFail(ResultMessage.ErrorBean t);

}
