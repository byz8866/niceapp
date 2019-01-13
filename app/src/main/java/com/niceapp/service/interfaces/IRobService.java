package com.niceapp.service.interfaces;

import com.niceapp.model.request.BettRecordRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.model.result.RobResult;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface IRobService {

    /**
     * 首页
     */
    @POST("robCoin/bettRecord")
    Observable<ResultMessage<RobResult>> getHomeInfo(@Body SendMessage<BettRecordRequest> sendMessage);

}
