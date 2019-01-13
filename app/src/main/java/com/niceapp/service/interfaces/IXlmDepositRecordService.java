package com.niceapp.service.interfaces;

import com.niceapp.model.request.EosDepositRecordRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.EosDepositRecordResult;
import com.niceapp.model.result.ResultMessage;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface IXlmDepositRecordService {
    int i = 0;

    /**
     * xlm 提现记录
     */
    @POST("deposit/xlmDepositRecord")
    Observable<ResultMessage<EosDepositRecordResult>> register(@Body SendMessage<EosDepositRecordRequest> sendMessage);


}
