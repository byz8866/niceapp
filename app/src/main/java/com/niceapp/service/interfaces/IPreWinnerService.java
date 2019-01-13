package com.niceapp.service.interfaces;

import com.niceapp.model.request.PlayRecordRequest;
import com.niceapp.model.request.PreWinnerRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.PlayBettResult;
import com.niceapp.model.result.PlayRecordResult;
import com.niceapp.model.result.PreWinnerResult;
import com.niceapp.model.result.ResultMessage;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface IPreWinnerService {

    /**
     * 往期获奖者
     */
    @POST("robCoin/previousWinners")
    Observable<ResultMessage<PreWinnerResult>> getPreWinner(@Body SendMessage<PreWinnerRequest> sendMessage);


    @POST("play/playRecord")
    Observable<ResultMessage<PlayRecordResult>> getPlayRecord(@Body SendMessage<PlayRecordRequest> sendMessage);
}
