package com.niceapp.service.interfaces;

import com.niceapp.model.request.SendMessage;
import com.niceapp.model.request.EthPtEosRequest;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.model.result.EosRecordResult;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface IEosService {

    /**
     * 首页夺币
     */
    @POST("trading/eosTradingRecord")
    Observable<ResultMessage<EosRecordResult>> getHomeInfo(@Body SendMessage<EthPtEosRequest> sendMessage);

}
