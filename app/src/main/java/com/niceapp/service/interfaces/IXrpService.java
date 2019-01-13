package com.niceapp.service.interfaces;

import com.niceapp.model.request.EthPtEosRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.EosRecordResult;
import com.niceapp.model.result.ResultMessage;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface IXrpService {

    /**
     * 首页夺币
     */
    @POST("trading/xrpTradingRecord")
    Observable<ResultMessage<EosRecordResult>> getHomeInfo(@Body SendMessage<EthPtEosRequest> sendMessage);

}
