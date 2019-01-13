package com.niceapp.scoket.keep;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.keepalive.KeepAliveFilter;
import org.apache.mina.filter.keepalive.KeepAliveRequestTimeoutHandler;

public class KeepAliveRequestTimeoutHandlerImpl implements KeepAliveRequestTimeoutHandler {
    @Override
    public void keepAliveRequestTimedOut(KeepAliveFilter keepAliveFilter, IoSession ioSession) throws Exception {
        ioSession.close(true);
        System.out.print("客户端挂了  我把session给干掉了！");
    }
}