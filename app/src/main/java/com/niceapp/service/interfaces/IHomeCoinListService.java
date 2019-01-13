package com.niceapp.service.interfaces;

import com.niceapp.model.request.RobCoinRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.model.result.RobCoinListResult;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface IHomeCoinListService {

    /**
     * 首页夺币
     */
    @POST("home/moreRobCoin")
    Observable<ResultMessage<RobCoinListResult>> getHomeInfo(@Body SendMessage<RobCoinRequest> sendMessage);

}
