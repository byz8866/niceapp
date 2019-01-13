package com.niceapp.service.interfaces;

import com.niceapp.model.request.ChangeNickRequest;
import com.niceapp.model.request.HpcRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.request.UpdateEailRequest;
import com.niceapp.model.result.HpcDepositRecordResult;
import com.niceapp.model.result.ResultMessage;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface IHpcDepositRecordService {
    int i = 0;

    /**
     * hpc 提现记录
     */
    @POST("deposit/hpcDepositRecord")
    Observable<ResultMessage<HpcDepositRecordResult>> register(@Body SendMessage params);


}
