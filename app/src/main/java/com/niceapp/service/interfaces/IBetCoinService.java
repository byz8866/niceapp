package com.niceapp.service.interfaces;

import com.niceapp.model.request.BetCoinRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.ResultMessage;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface IBetCoinService {

    /**
     * 首页
     */
    @POST("robCoin/bett")
    Observable<ResultMessage> getHomeInfo(@Body SendMessage<BetCoinRequest> sendMessage);

}
