package com.niceapp.view.pop;

import com.tencent.bugly.beta.UpgradeInfo;
import com.niceapp.BuildConfig;
import com.niceapp.model.request.GetDividendsRequest;
import com.niceapp.model.request.NickRequest;
import com.niceapp.model.result.ActivityResult;
import com.niceapp.model.result.LoginResult;
import com.niceapp.view.pop.model.UpgradeModel;

import java.util.TreeMap;

public class PopMgr {

    //值越小, 优先级越高

    public static final int POP_CHANGE_NICK = 0x16;
    public static final int POP_DAILY_ACTIVITY = 0x13;
    public static final int POP_PT_DIALOG = 0x14;
    public static final int POP_DAILY_DIVIDENDS = 0x15;
    public static final int POP_NEWER_REGISTER = 0x12;
    public static final int POP_UPGRADE = 0x11;

    private static PopMgr mInstance;
    private PopCallback mListener;

    //使用treemap控制弹窗任务队列, 即使是后加入的任务,只要值较小, 就可以优先执行
    /***
     * 这样做有个弊端，在执行弹出下一个的时候，如果优先级靠前的话，会删掉这个靠前的dialog，而弹出过一次的再次弹出
     * ***/
    private TreeMap<Integer, Object> mPopDataTree;

    private PopMgr() {
        mPopDataTree = new TreeMap<>();
    }

    public static PopMgr getInstance() {
        if (mInstance == null) {
            mInstance = new PopMgr();
        }
        return mInstance;
    }

    private void insertTask(Integer key, Object obj) {
        // 如果key已经存在，treeMap中默认object会刷新，int会自动从小到大排序
        mPopDataTree.put(key, obj);
        if (mPopDataTree.size() == 1) {//如果是第一个, 那么直接执行
            mListener.shouldPop(mPopDataTree.firstKey(), mPopDataTree.get(mPopDataTree.firstKey()));
        }
    }

    public void removeTask(Integer key) {
        if (mPopDataTree.containsKey(key)) {
            mPopDataTree.remove(key);
        }
    }

    public void cleanTask() {
        if (mPopDataTree != null) {
            mPopDataTree.clear();
        }
    }

    private void removeFirstPop() {
        if (mPopDataTree.size() > 0) {
            mPopDataTree.remove(mPopDataTree.firstKey());
        }
    }

    public void nextTask() {
        removeFirstPop();
        if (mPopDataTree.size() > 0) {
            mListener.shouldPop(mPopDataTree.firstKey(), mPopDataTree.get(mPopDataTree.firstKey()));
        }
    }

    /**
     * 显示更新弹窗
     *
     * @param upgradeInfo
     * @param isManual
     */
    public void startUpgrade(UpgradeInfo upgradeInfo, boolean isManual) {
        if (upgradeInfo == null) {
            return;
        }
        if (upgradeInfo.versionCode > BuildConfig.VERSION_CODE) {
            if (mListener != null) {
                //转化数据体
                UpgradeModel model = new UpgradeModel();
                model.setForceUpgrade(upgradeInfo.upgradeType == 2);//升级策略 1建议 2强制 3手工
                model.setUpgradeContent(upgradeInfo.newFeature);
                model.setUpgradeTitle(upgradeInfo.title);
                model.setVersionName(upgradeInfo.versionName);
                model.setVersionCode(upgradeInfo.versionCode);
                model.setIsManual(isManual);
                insertTask(POP_UPGRADE, model);
            }
        }
    }


    /**
     * 新手注册成功赠送PT弹窗
     *
     * @param popInfoBean
     */
    public void showNewerRegisterPopInfo(LoginResult popInfoBean) {
        if (mListener != null) {
            insertTask(POP_NEWER_REGISTER, popInfoBean);
        }
    }

    /**
     * 每天登入后的分红弹窗
     *
     * @param request
     */
    public void showDailyDividendsPopInfo(GetDividendsRequest request) {
        if (mListener != null) {
            insertTask(POP_DAILY_DIVIDENDS, request);
        }
    }

    /**
     * 活动页弹窗
     *
     * @param request
     */
    public void showDailyActivityInfo(ActivityResult request) {
        if (mListener != null) {
            insertTask(POP_DAILY_ACTIVITY, request);
        }
    }

    /**
     * 活动修改昵称
     *
     * @param request
     */
    public void showChangeNick(NickRequest request) {
        if (mListener != null) {
            insertTask(POP_CHANGE_NICK, request);
        }
    }

    /**
     * 赠送pt活动页
     */
    public void showPtDialog() {
        if (mListener != null) {
            insertTask(POP_PT_DIALOG, null);
        }
    }


    public void setPopCallback(PopCallback popCallback) {
        mListener = popCallback;
    }

    public void removePopCallback() {
        mListener = null;
    }

    public interface PopCallback {
        void shouldPop(int popType, Object obj);
    }
}
