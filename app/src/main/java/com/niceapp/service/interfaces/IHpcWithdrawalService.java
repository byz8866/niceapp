package com.niceapp.service.interfaces;

import com.niceapp.model.request.HpcRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.HpcWithdrawlResult;
import com.niceapp.model.result.ResultMessage;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface IHpcWithdrawalService {
    int i = 0;

    /**
     * hpc 提现
     */
    @POST("deposit/depositHpc")
    Observable<ResultMessage<HpcWithdrawlResult>> register(@Body SendMessage<HpcRequest> params);


}
