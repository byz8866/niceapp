package com.niceapp.service.interfaces;

import com.niceapp.model.request.RegisterRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.request.SendSmsRequest;
import com.niceapp.model.result.ResultMessage;

import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

public interface IRegisterService {
    int i = 0;

    /**
     * 注册
     */
    @POST("user/register")
    Observable<ResultMessage> register(@Body SendMessage<RegisterRequest> params);


    /**
     * 发送验证码
     */
    @POST("sendSms")
    Observable<ResultMessage> sendSms(@Body SendMessage<SendSmsRequest> params);


    /**
     * 获取图片验证码
     */
    @GET("getVerify")
    Observable<ResponseBody> getVerifyCode();

}
