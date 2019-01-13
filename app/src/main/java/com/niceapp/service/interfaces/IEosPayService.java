package com.niceapp.service.interfaces;

import com.niceapp.model.request.EthPtEosRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.EosPayRecordResult;
import com.niceapp.model.result.EosRecordResult;
import com.niceapp.model.result.ResultMessage;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface IEosPayService {

    /**
     *
     */
    @POST("deposit/eosRechargeRecord")
    Observable<ResultMessage<EosPayRecordResult>> getHomeInfo(@Body SendMessage<EthPtEosRequest> sendMessage);

}
