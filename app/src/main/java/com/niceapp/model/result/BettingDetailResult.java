package com.niceapp.model.result;


public class BettingDetailResult {
    WinDetailResult.BettDetails ethDetails;
    WinDetailResult.BettDetails tokenDetails;

    public WinDetailResult.BettDetails getEthDetails() {
        return ethDetails;
    }

    public void setEthDetails(WinDetailResult.BettDetails ethDetails) {
        this.ethDetails = ethDetails;
    }

    public WinDetailResult.BettDetails getTokenDetails() {
        return tokenDetails;
    }

    public void setTokenDetails(WinDetailResult.BettDetails tokenDetails) {
        this.tokenDetails = tokenDetails;
    }
}
