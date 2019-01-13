package com.niceapp.service.interfaces;

import com.niceapp.model.request.OpenDetailRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.InviteNumResult;
import com.niceapp.model.result.OpenDetailsResult;
import com.niceapp.model.result.ResultMessage;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface IInviteNumService {

    /**
     * 邀请人列表
     */
    @POST("user/inviteNumbers")
    Observable<ResultMessage<InviteNumResult>> getInviteNum(@Body SendMessage sendMessage);

}
