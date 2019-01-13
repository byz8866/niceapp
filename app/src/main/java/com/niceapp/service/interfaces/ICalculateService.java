package com.niceapp.service.interfaces;

import com.niceapp.model.request.CalculateRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.CalculateResult;
import com.niceapp.model.result.ResultMessage;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface ICalculateService {

    /**
     * 首页
     */
    @POST("robCoin/calculate")
    Observable<ResultMessage<CalculateResult>> getCalculateInfo(@Body SendMessage<CalculateRequest> sendMessage);

}
