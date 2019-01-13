package com.niceapp.service.interfaces;

import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.model.result.RobResult;
import com.niceapp.model.result.WinCoinResult;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface IWinCoinService {

    /**
     * 中奖记录
     */
    @POST("robCoin/winRecord")
    Observable<ResultMessage<WinCoinResult>> getHomeInfo(@Body SendMessage sendMessage);

}
