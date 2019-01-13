package com.niceapp.scoket;

import android.util.Log;

import com.niceapp.BuildConfig;
import com.niceapp.scoket.codec.ClientCodecFactory;
import com.niceapp.scoket.keep.KeepAliveMessageFactoryImpl;
import com.niceapp.scoket.keep.KeepAliveRequestTimeoutHandlerImpl;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.service.IoServiceListener;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.keepalive.KeepAliveFilter;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;

/**
 * Created by MaTeng on 16/12/6.
 */

public class SocketConnect implements ReceivedMessageListener {

    /**
     * R®5秒发送一次心跳包
     */
    private static final int HEARTBEATRATE = 5;

    /**
     * 30秒后超时
     */
    private static final int IDELTIMEOUT = 10;

    private ClientHandler clientHandler;
    private IoConnector connector;
    private ConnectFuture future;
    private IoSession session;
    private InetSocketAddress socketAddress;
    private ReceivedMessageListener receivedMessageListener;

    private boolean isFinish = false;

    /**
     * 初始化
     */
    public SocketConnect(IoServiceListener serviceListener) {
        connector = new NioSocketConnector();

        connector.setConnectTimeoutMillis(IDELTIMEOUT * 1000);
        connector.getSessionConfig().setMaxReadBufferSize(299999);
        //打印log日志
        connector.getFilterChain().addLast("logger", new LoggingFilter());
        //添加自定义编解码器
        connector.getFilterChain().addLast("codec",
                new ProtocolCodecFilter(new ClientCodecFactory())
        );
        connector.getFilterChain().addLast("heartbeat", keepAliveMessageFactory());
        connector.addListener(serviceListener);
        connector.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, HEARTBEATRATE);
        //编写业务逻辑的地方，读取数据和发送数据的基本操作
        clientHandler = new ClientHandler(this);
        connector.setHandler(clientHandler);
    }

    public void addReceivedMessageListener(ReceivedMessageListener receivedMessageListener) {
        this.receivedMessageListener = receivedMessageListener;
    }

    private KeepAliveFilter keepAliveMessageFactory() {
        //心跳检测开始
        KeepAliveMessageFactory heartBeatFactory = new KeepAliveMessageFactoryImpl();
        KeepAliveFilter heartBeat = new KeepAliveFilter(heartBeatFactory,
                IdleStatus.WRITER_IDLE);

        //设置是否forward到下一个filter
        heartBeat.setForwardEvent(true);
        //设置心跳频率
        heartBeat.setRequestInterval(HEARTBEATRATE);

//        heartBeat.setRequestTimeout(IDELTIMEOUT);
//        //设置失败处理handler
        heartBeat.setRequestTimeoutHandler(new KeepAliveRequestTimeoutHandlerImpl());
        return heartBeat;
    }

    /**
     * 向服务器发送消息
     *
     * @param message
     */
    public synchronized void sendMessage(final Object message, String ip, int port, SendMsgCallback sendMsgCallback) {
        connect(ip, port, new ConnectCallback() {
            @Override
            public void success() {
                clientHandler.sendMessage(message);
                if (sendMsgCallback != null) {
                    sendMsgCallback.sendSuccess();
                }
            }

            @Override
            public void fail(String message) {
                if (BuildConfig.DEBUG) Log.d("SocketConnect", "连接失败:" + message);
                if (sendMsgCallback != null) {
                    sendMsgCallback.sendFail();
                }
            }
        });
    }


    public void sendMessage(final Object message, String ip, int port) {
        sendMessage(message, ip, port, null);
    }


    /**
     * 接收服务器消息后向外回调
     *
     * @param message
     */
    @Override
    public void receivedMessage(IoSession session, Object message) {
        if (receivedMessageListener != null)
            receivedMessageListener.receivedMessage(session, message);
    }


    /**
     * 连接
     *
     * @param hostname ip地址
     * @param port     端口号
     */
    public void connect(final String hostname, final int port) {
        connect(hostname, port, null);
    }

    /**
     * 连接
     *
     * @param hostname
     * @param port
     * @param callback 连接结果
     */
    public void connect(final String hostname, final int port, final ConnectCallback callback) {
        new Thread(() -> {
            if (isConnected()) {
                callback.success();
            } else {
                socketAddress = new InetSocketAddress(hostname, port);
                connect(socketAddress, callback);
            }
        }).start();
    }

    /**
     * 连接
     *
     * @param socketAddress
     */
    private void connect(final InetSocketAddress socketAddress, ConnectCallback callback) {
        future = connector.connect(socketAddress);
        future.awaitUninterruptibly();//等待连接创建成功
        try {
            session = future.getSession(); //获取回话
            if (callback != null) {
                if (isConnected()) {
                    callback.success();
                } else {
                    throw new Exception("Failed to the session connect.");
                }
            }
        } catch (Exception e) {
            if (callback != null)
                callback.fail(e.getMessage());
        }

    }

    /**
     * 判断是否连接
     *
     * @return
     */
    public boolean isConnected() {
        if (connector == null || future == null || session == null)
            return false;
        if (connector.isDisposed())
            return false;
        if (!future.isConnected())
            return false;
        if (!session.isConnected())
            return false;
        return true;
    }

    /**
     * 重新连接到另一个服务器
     *
     * @param hostname ip地址
     * @param port     端口号
     */
    public void connectRedirect(String hostname, int port) {
        disConnect();
        connect(hostname, port);
    }

    /**
     * 断开连接
     */
    public void disConnect() {

        if (isConnected()) {
            session.close(true);
            future.cancel();
        }

    }

    public void onDestroy() {
        isFinish = true;
        disConnect();
    }

    /**
     * 重新连接
     *
     * @param callback 连接结果回调
     * @param repeat   重复次数
     */
    public void reConnect(final ConnectCallback callback, final int repeat) {

        new Thread(() -> {
            if (isConnected()) {
                if (callback != null) {
                    callback.success();
                }
                return;
            }
            disConnect();
            int i = 0;
            do {
                i++;
                if (isFinish) {
                    return;
                }

                if (isConnected()) {
                    return;
                }
                connect(socketAddress, new ConnectCallback() {
                    @Override
                    public void success() {

                        if (BuildConfig.DEBUG)
                            Log.d("SocketConnect", "断线重连[IP:" + socketAddress.getHostName() + ",PORT:" + socketAddress.getPort() + "]成功");
                        if (callback != null) {
                            callback.success();
                        }
                    }

                    @Override
                    public void fail(String message) {
                        if (BuildConfig.DEBUG)
                            Log.d("SocketConnect", "重连服务器登录失败:" + message + ",3秒后再次连接");
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });

            } while (repeat == -1 || i < repeat);
            if (!isConnected()) {
                if (callback != null) {
                    callback.fail("连接失败");
                }
            }

        }).start();
    }

    /**
     * 默认重连方式，监听结果，连接失败后不再次尝试
     */
    public void reConnect(ConnectCallback callback) {
        reConnect(callback, 0);
    }


    public interface ConnectCallback {

        void success();

        void fail(String message);

    }


    public interface SendMsgCallback {
        void sendSuccess();

        void sendFail();

    }

}
