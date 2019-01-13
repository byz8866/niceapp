package com.niceapp.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.niceapp.base.ActivityManager;
import com.niceapp.main.activity.MainActivity;
import com.niceapp.model.result.DropFail;
import com.niceapp.view.user.message.MessageDrop;
import com.google.gson.Gson;
import com.niceapp.AppValue;
import com.niceapp.BuildConfig;
import com.niceapp.model.request.ConnectRequest;
import com.niceapp.model.request.SendMessage;
import com.niceapp.model.result.ConnectResult;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.scoket.SocketConnect;
import com.niceapp.view.Navigate;
import com.niceapp.view.user.message.SendNetworkRequestFail;
import com.niceapp.view.user.message.SendNetworkRequestSuccess;

import org.apache.mina.core.service.IoService;
import org.apache.mina.core.service.IoServiceListener;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SocketService extends Service {

    private SocketConnect socketConnect;
    private Gson gson;

    public SocketService() {
        gson = new Gson();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("SocketService", "Service开启");

        EventBus.getDefault().register(this);

        socketConnect = new SocketConnect(serviceListener);

        socketConnect.connect(AppValue.SOCKET_IP, AppValue.SOCKET_PORT, connectListener);

        //接受Socket消息
        socketConnect.addReceivedMessageListener((ioSession, message) -> {
            if (BuildConfig.DEBUG) Log.d("SocketService", "收到消息:" + message.toString());
            if (message instanceof ResultMessage) {
                Object object = null;

                if (!Navigate.ACTION_SUCCESS_MAP.containsKey(((ResultMessage) message).getAction())) {
                    return;
                }
                if (((ResultMessage) message).isSuccess()) {
                    object = gson.fromJson(gson.toJson(((ResultMessage) message).getData()), Navigate.ACTION_SUCCESS_MAP.get(((ResultMessage) message).getAction()));
                    if (object == null) {
                        try {
                            object = Navigate.ACTION_SUCCESS_MAP.get(((ResultMessage) message).getAction()).newInstance();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    try {
                        Class aClass = Navigate.ACTION_FAIL_MAP.get(((ResultMessage) message).getAction());
                        if (aClass != null) {
                            object = aClass.newInstance();
                            Method method = aClass.getMethod("setErrorBean", ResultMessage.ErrorBean.class);
                            method.invoke(object, ((ResultMessage) message).getError());
                        }
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }

                if (object != null) {
                    EventBus.getDefault().post(object);
                }
            }
        });
    }

    /**
     * IOConnector的监听器
     */
    private IoServiceListener serviceListener = new IoServiceListener() {

        @Override
        public void sessionCreated(IoSession session) {
            //创建
            if (BuildConfig.DEBUG) Log.d("SocketConnect", "sessionCreated");
        }

        @Override
        public void serviceActivated(IoService service) {
            //活动
            if (BuildConfig.DEBUG) Log.d("SocketConnect", "serviceActivated");
        }

        @Override
        public void serviceIdle(IoService service, IdleStatus idleStatus) {
            //空闲
            if (BuildConfig.DEBUG) Log.d("SocketConnect", "serviceIdle");
        }

        @Override
        public void serviceDeactivated(IoService service) {
            //失效
            if (BuildConfig.DEBUG) Log.d("SocketConnect", "serviceDeactivated");

//            FragmentActivity mContext = (FragmentActivity) ActivityManager.Companion.getInstance().currentActivity();
//            AlertDialog alertDialog = new AlertDialog();
//            if (mContext.getSupportFragmentManager().findFragmentByTag("ALERT") != null) {
//                alertDialog.show(mContext.getSupportFragmentManager(), "ALERT");
//            }
        }

        @Override
        public void sessionDestroyed(IoSession session) {
            //销毁
            if (BuildConfig.DEBUG) Log.d("SocketConnect", "sessionDestroyed");
        }
    };

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void reConnect(ConnectRequest request) {
        Log.d("SocketService", "请求重连");
        if (request.isConnect()) {
            //连接socket并监听连接结果
            socketConnect.connect(AppValue.SOCKET_IP, AppValue.SOCKET_PORT, connectListener);
        } else {
            socketConnect.reConnect(connectListener, request.getReCount());
        }


    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void sendMessage(SendMessage sendMessage) {
        Log.d("SocketService", "发送消息:" + sendMessage.toJson());
        socketConnect.sendMessage(sendMessage, AppValue.SOCKET_IP, AppValue.SOCKET_PORT, new SocketConnect.SendMsgCallback() {
            @Override
            public void sendSuccess() {
                EventBus.getDefault().post(new SendNetworkRequestSuccess());
            }

            @Override
            public void sendFail() {
                EventBus.getDefault().post(new SendNetworkRequestFail());
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void drop(DropFail dropFail) {
        ActivityManager.Companion.getInstance().finishAllActivityWithOutThis(MainActivity.class);
        //发通知
        MessageDrop drop = new MessageDrop();
        EventBus.getDefault().post(drop);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("SocketService", "service关闭");
        socketConnect.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    /**
     * 连接监听
     */
    SocketConnect.ConnectCallback connectListener = new SocketConnect.ConnectCallback() {
        @Override
        public void success() {
            EventBus.getDefault().post(new ConnectResult(true, "连接成功"));
        }

        @Override
        public void fail(String message) {
            Log.d("SocketService", "连接失败");
            EventBus.getDefault().post(new ConnectResult(false, message));
        }
    };
}
