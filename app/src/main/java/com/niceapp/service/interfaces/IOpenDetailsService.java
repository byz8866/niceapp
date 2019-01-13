package com.niceapp.service.interfaces;

import com.niceapp.model.request.OpenDetailRequest;
import com.niceapp.model.request.PreWinnerRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.OpenDetailsResult;
import com.niceapp.model.result.PreWinnerResult;
import com.niceapp.model.result.ResultMessage;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface IOpenDetailsService {

    /**
     * 开奖详情
     */
    @POST("robCoin/openDetails")
    Observable<ResultMessage<OpenDetailsResult>> getPreWinner(@Body SendMessage<OpenDetailRequest> sendMessage);

}
