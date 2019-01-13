package com.niceapp.service.interfaces;

import com.niceapp.model.request.BetCoinRequest;
import com.niceapp.model.request.ChangeNickRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.ResultMessage;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface IChangeNickService {

    /**
     * 修改昵称
     */
    @POST("user/updateNickname")
    Observable<ResultMessage> changeNick(@Body SendMessage<ChangeNickRequest> sendMessage);

}
