package com.niceapp.scoket.keep;

import android.util.Log;

import com.niceapp.model.request.SendMessage;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;

public class KeepAliveMessageFactoryImpl implements KeepAliveMessageFactory {


    //客户端接收到服务器发送的数据
    @Override
    public boolean isRequest(IoSession session, Object message) {
        Log.d("KeepAliveMessageFactory", ("接收到服务器心数据包引发心跳事件心跳数据包是》》" + message));

//        if (message instanceof ResultMessage && ((ResultMessage) message).getAction().equals("pong")) {
//            return true;
//        }
        return false;
    }

    //判断客户端发送的是否是客户端请求消息
    @Override
    public boolean isResponse(IoSession session, Object message) {
        if (message instanceof SendMessage && ((SendMessage) message).getAction().equals("ping")) {
            Log.d("KeepAliveMessageFactory", ("客户端发送数据包中引发心跳事件: " + message));
            return true;
        }
        return false;
    }

    /**
     * 获取心跳请求包 non-null
     */
    @Override
    public Object getRequest(IoSession session) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setAction("ping");
        return sendMessage;
    }

    /**
     * 接受到的服务器数据包
     */
    @Override
    public Object getResponse(IoSession session, Object request) {
        //log.info(request.toString());
        return null;
    }
}
