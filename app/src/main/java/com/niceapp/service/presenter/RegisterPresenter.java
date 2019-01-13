package com.niceapp.service.presenter;

import com.niceapp.model.request.RegisterRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.request.SendSmsRequest;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.service.ServiceGenerator;
import com.niceapp.service.interfaces.IRegisterService;
import com.niceapp.service.presenter.callback.ImageVerifyCallback;
import com.niceapp.service.presenter.callback.RegisterCallback;
import com.niceapp.service.presenter.callback.SendSmsCallback;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RegisterPresenter extends BasePresenter {

    private IRegisterService service = ServiceGenerator.INSTANCE.createService(IRegisterService.class);


    public void register(RegisterRequest registerRequest, RegisterCallback callback) {
        SendMessage<RegisterRequest> sendMessage = new SendMessage<>();
        sendMessage.setData(registerRequest);
        registerSubscription(service.register(sendMessage)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(Throwable::printStackTrace)
                .onErrorResumeNext(throwable -> Observable.empty())
                .subscribe(new ResultSubscriber<ResultMessage>() {
                    @Override
                    void onSuccess(ResultMessage resultMessage) {
                        callback.success();
                    }

                    @Override
                    void onFail(ResultMessage.ErrorBean t) {
                        callback.fail(t.getMessage());
                    }
                })
        );
    }

    public void sendSms(SendSmsRequest sendSmsRequest, SendSmsCallback callback) {
        SendMessage<SendSmsRequest> sendMessage = new SendMessage<>();
        sendMessage.setData(sendSmsRequest);
        registerSubscription(service.sendSms(sendMessage)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResultSubscriber<ResultMessage>() {
                    @Override
                    void onSuccess(ResultMessage resultMessage) {
                        callback.sendSuccess();
                    }

                    @Override
                    void onFail(ResultMessage.ErrorBean t) {
                        callback.fail(t.getMessage());
                    }
                })
        );
    }

    public void getVerifyCode(ImageVerifyCallback imageVerifyCallback) {
        registerSubscription(service.getVerifyCode()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(responseBody -> {
                    byte[] bytes = null;
                    InputStream inputStream = responseBody.byteStream();
                    try {
                        bytes = readStream(inputStream);
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return bytes;
                })
                .subscribe(new Subscriber<byte[]>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        imageVerifyCallback.fail(e.getMessage());
                    }

                    @Override
                    public void onNext(byte[] bitmap) {
                        imageVerifyCallback.success(bitmap);
                    }
                }));
    }

    /*
     * 得到图片字节流 数组大小
     * */
    private static byte[] readStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        outStream.close();
        inStream.close();
        return outStream.toByteArray();
    }
}
