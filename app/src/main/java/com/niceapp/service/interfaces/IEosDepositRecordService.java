package com.niceapp.service.interfaces;

import com.niceapp.model.request.EosDepositRecordRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.EosDepositRecordResult;
import com.niceapp.model.result.ResultMessage;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface IEosDepositRecordService {
    int i = 0;

    /**
     * eos 提现记录
     */
    @POST("deposit/eosDepositRecord")
    Observable<ResultMessage<EosDepositRecordResult>> register(@Body SendMessage<EosDepositRecordRequest> sendMessage);


}
