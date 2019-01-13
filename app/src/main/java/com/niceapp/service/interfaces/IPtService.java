package com.niceapp.service.interfaces;

import com.niceapp.model.request.SendMessage;
import com.niceapp.model.request.EthPtEosRequest;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.model.result.PtRecordResult;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface IPtService {

    /**
     * 首页夺币
     */
    @POST("trading/tokenTradingRecord")
    Observable<ResultMessage<PtRecordResult>> getHomeInfo(@Body SendMessage<EthPtEosRequest> sendMessage);

}
