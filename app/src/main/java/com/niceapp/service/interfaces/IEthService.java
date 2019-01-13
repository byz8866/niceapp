package com.niceapp.service.interfaces;

import com.niceapp.model.request.SendMessage;
import com.niceapp.model.request.EthPtEosRequest;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.model.result.EthRecordResult;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface IEthService {

    /**
     * 首页夺币
     */
    @POST("trading/ethTradingRecord")
    Observable<ResultMessage<EthRecordResult>> getHomeInfo(@Body SendMessage<EthPtEosRequest> sendMessage);

}
