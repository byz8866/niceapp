package com.niceapp.service.interfaces;

import com.niceapp.model.request.NewRobRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.NewRobResult;
import com.niceapp.model.result.ResultMessage;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface INewRobService {

    /**
     * 夺币下一轮
     */
    @POST("robCoin/newRecord")
    Observable<ResultMessage<NewRobResult>> getNewRobInfo(@Body SendMessage<NewRobRequest> sendMessage);

}
