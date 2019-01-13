package com.niceapp.service.interfaces;

import com.niceapp.model.request.BonusRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.BonusResult;
import com.niceapp.model.result.ResultMessage;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface IBonusService {

    /**
     *  分红收益
     */
    @POST("user/bonusArea")
    Observable<ResultMessage<BonusResult>> getBonusInfo(@Body SendMessage<BonusRequest> sendMessage);

}
