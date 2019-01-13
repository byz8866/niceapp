package com.niceapp.scoket;


import com.niceapp.model.request.SendMessage;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

class ClientHandler extends IoHandlerAdapter {

    private IoSession session;

    private ReceivedMessageListener receivedMessage;

    /**
     * 构造函数
     *
     * @param receivedMessage 接收服务器消息的回调接口
     */
    public ClientHandler(ReceivedMessageListener receivedMessage) {
        this.receivedMessage = receivedMessage;
    }

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        this.session = session;
        super.sessionCreated(session);
        //设置连接闲置时间超过5秒吊起sessionIdle发送心跳
        session.getConfig().setIdleTime(IdleStatus.BOTH_IDLE, 15);
    }

    /**
     * 发送消息
     *
     * @param message
     */
    public void sendMessage(Object message) {
        this.session.write(message);
    }

    /**
     * 接收消息
     *
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        super.messageReceived(session, message);
        receivedMessage.receivedMessage(session, message);
    }

    /**
     * 出现异常
     *
     * @param session
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        super.exceptionCaught(session, cause);
        cause.printStackTrace();
//        session.close(false);
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        super.sessionIdle(session, status);

        //发送心跳包
        SendMessage sendMessage = new SendMessage();
        sendMessage.setAction("ping");
        sendMessage(sendMessage);
    }
}