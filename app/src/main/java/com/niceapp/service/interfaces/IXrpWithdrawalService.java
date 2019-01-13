package com.niceapp.service.interfaces;

import com.niceapp.model.request.EosWithdrawalRequest;
import com.niceapp.model.request.EosWithdrawalResult;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.ResultMessage;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface IXrpWithdrawalService {

    /**
     *
     */
    @POST("deposit/depositXrp")
    Observable<ResultMessage<EosWithdrawalResult>> getHomeInfo(@Body SendMessage<EosWithdrawalRequest> sendMessage);

}
