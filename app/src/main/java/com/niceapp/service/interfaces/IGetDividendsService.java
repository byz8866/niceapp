package com.niceapp.service.interfaces;

import com.niceapp.model.request.GetDividendsSuccess;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.GetDividendsResult;
import com.niceapp.model.result.ResultMessage;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface IGetDividendsService {

    /**
     * 首页
     */
    @POST("user/getBonus")
    Observable<ResultMessage<GetDividendsSuccess>> getDividendsInfo(@Body SendMessage sendMessage);

}
