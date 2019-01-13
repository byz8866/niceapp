package com.niceapp.service.interfaces;

import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.LuckNumResult;
import com.niceapp.model.result.ResultMessage;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface ILuckNumService {

    /**
     * 幸运号码
     */
    @POST("robCoin/luckyNumber")
    Observable<ResultMessage<LuckNumResult>> getLuckNum(@Body SendMessage sendMessage);

}
