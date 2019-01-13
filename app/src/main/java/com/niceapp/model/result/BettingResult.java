package com.niceapp.model.result;

import java.util.List;

public class BettingResult {

    private List<WinPrizeResult.WinPrizeResultBean> bettRecordResultList;

    public List<WinPrizeResult.WinPrizeResultBean> getBettRecordResultList() {
        return bettRecordResultList;
    }

    public void setBettRecordResultList(List<WinPrizeResult.WinPrizeResultBean> bettRecordResultList) {
        this.bettRecordResultList = bettRecordResultList;
    }

}
