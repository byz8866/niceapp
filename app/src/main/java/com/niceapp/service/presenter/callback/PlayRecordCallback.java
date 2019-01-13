package com.niceapp.service.presenter.callback;

import com.niceapp.model.result.PlayRecordResult;
import com.niceapp.model.result.PreWinnerResult;

public interface PlayRecordCallback {

    void playRecordSuccess(PlayRecordResult result);

    void playRecordFail(String message);

}
