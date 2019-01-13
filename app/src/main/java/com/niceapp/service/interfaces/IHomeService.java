package com.niceapp.service.interfaces;

import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.Home2Result;
import com.niceapp.model.result.ResultMessage;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface IHomeService {

    /**
     * 首页
     */
    @POST("home/homePage")
    Observable<ResultMessage<Home2Result>> getHomeInfo(@Body SendMessage sendMessage);

}
