package com.niceapp.scoket;

import org.apache.mina.core.session.IoSession;

public interface ReceivedMessageListener {

    void receivedMessage(IoSession ioSession, Object message);

}