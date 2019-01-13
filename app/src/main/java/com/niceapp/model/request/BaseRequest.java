package com.niceapp.model.request;

import com.niceapp.BaseApp;
import com.niceapp.utils.IdDevice;
import com.niceapp.utils.SignUtils;

public class BaseRequest {
    private String deviceId = IdDevice.getDeviceID(BaseApp.getApp()); //客户端唯一标识
    // private Long timestamp = System.currentTimeMillis();
    private String timestamp = String.valueOf(System.currentTimeMillis());
    private String nonce = SignUtils.str2HexStr(String.valueOf(timestamp) + deviceId);
}
