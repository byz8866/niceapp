package com.niceapp.service.interfaces;

import com.niceapp.model.request.RobCoinDetailRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.model.result.RobCoinDetailResult;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface IRobCoinDetailService {

    /**
     * 夺币
     */
    @POST("robCoin/details")
    Observable<ResultMessage<RobCoinDetailResult>> getRobCoinDetail(@Body SendMessage<RobCoinDetailRequest> sendMessage);

}
