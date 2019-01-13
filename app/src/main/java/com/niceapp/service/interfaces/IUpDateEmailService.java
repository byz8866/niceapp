package com.niceapp.service.interfaces;

import com.niceapp.model.request.SendMessage;
import com.niceapp.model.request.UpdateEailRequest;
import com.niceapp.model.result.ResultMessage;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface IUpDateEmailService {
    int i = 0;

    /**
     * 更改邮箱
     */
    @POST("user/updateEmail")
    Observable<ResultMessage> register(@Body SendMessage<UpdateEailRequest> params);


}
