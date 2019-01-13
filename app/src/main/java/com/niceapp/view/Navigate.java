package com.niceapp.view;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

import com.niceapp.model.result.BalanceFail;
import com.niceapp.model.result.BalanceResult;
import com.niceapp.model.result.BarrageResult;
import com.niceapp.model.result.BettingCloseResult;
import com.niceapp.model.result.BettingDetailResult;
import com.niceapp.model.result.BettingFail;
import com.niceapp.model.result.BettingResult;
import com.niceapp.model.result.ChangePasswordFail;
import com.niceapp.model.result.ChangePasswordResult;
import com.niceapp.model.result.DepositFail;
import com.niceapp.model.result.DepositRecordResult;
import com.niceapp.model.result.DepositResult;
import com.niceapp.model.result.DropFail;
import com.niceapp.model.result.DropResult;
import com.niceapp.model.result.ForgetPasswordFail;
import com.niceapp.model.result.ForgetPasswordResult;
import com.niceapp.model.result.HomeFail;
import com.niceapp.model.result.HomeResult;
import com.niceapp.model.result.InviteRewardFail;
import com.niceapp.model.result.InviteRewardResult;
import com.niceapp.model.result.LineChartResult;
import com.niceapp.model.result.LoginFail;
import com.niceapp.model.result.LoginResult;
import com.niceapp.model.result.MineFail;
import com.niceapp.model.result.MineResult;
import com.niceapp.model.result.PlayBettResult;
import com.niceapp.model.result.PlayBuyFail;
import com.niceapp.model.result.PlayBuyResult;
import com.niceapp.model.result.PlayRecordFail;
import com.niceapp.model.result.PlayRecordResult;
import com.niceapp.model.result.PlayResult;
import com.niceapp.model.result.ReSendEmailFail;
import com.niceapp.model.result.ReSendEmailResult;
import com.niceapp.model.result.RechargeFail;
import com.niceapp.model.result.RechargeResult;
import com.niceapp.model.result.RecordEntity;
import com.niceapp.model.result.RegisterFail;
import com.niceapp.model.result.RegisterResult;
import com.niceapp.model.result.RobCoinBuyResult;
import com.niceapp.model.result.RobCoinOpenResult;
import com.niceapp.model.result.RobCoinRecordChangeResult;
import com.niceapp.model.result.SendSmsFail;
import com.niceapp.model.result.SendSmsResult;
import com.niceapp.model.result.TradingRecordResult;
import com.niceapp.model.result.VerificationCodeResult;
import com.niceapp.model.result.WinPrizeDetailResult;
import com.niceapp.model.result.WinPrizeFail;
import com.niceapp.model.result.WinPrizeResult;
import com.niceapp.view.user.manager.AccountManager;

import java.util.HashMap;
import java.util.Map;

import static com.niceapp.base.ConstantsKt.RECORD;

public class Navigate {


    public static final String ACTION_LOGIN = "login";

    public static final String ACTION_REGISTER = "register";

    public static final String ACTION_SENDSMS = "sendSms";

    public static final String ACTION_HOME = "homePage";

    public static final String ACTION_MINE = "mine";

    public static final String ACTION_PLAY_RECORD = "playRecord";

    public static final String ACTION_PLAY = "play";

    public static final String ACTION_PLAY_EXIT = "exitPlayDetails";

    //行情折现数据
    private static final String ACTION_LINE_CHART = "lineChart";

    //play状态发送改变
    private static final String ACTION_PLAY_STATUS_CHANGE = "recordChange";

    //投注数量发生变化
    private static final String ACTION_PLAY_BET_CHANGE = "bettChange";

    public static final String ACTION_PLAY_BUY = "buy";

    public static final String ACTION_RECHARGE_RESULT = "getRechargeRecord";
    //投注结果
    public static final String ACTION_PLAY_BETT_RESULT = "bettResult";
    //提现记录
    public static final String ACTION_WITHDRAWAL_RESULT = "getDepositRecord";
    //发送验证码
    public static final String ACTION_VERIFICATION_CODE_RESULT = "sendSms";
    //忘记密码
    public static final String ACTION_FORGET_PASSWORD_RESULT = "forgetPwd";
    //更改密码
    public static final String ACTION_CHANGE_PASSWORD_RESULT = "updatePwd";

    //中奖记录
    public static final String ACTION_WIN_PRIZE_RECORD_RESULT = "winPrizeRecord";
    //中奖详情
    public static final String ACTION_WIN_PRIZE_DETAIL_RESULT = "getPrizeDetails";
    //投注记录
    public static final String ACTION_BETTING_RESULT = "getBettRecord";
    //投注详情
    public static final String ACTION_BETTING_DETAIL_RESULT = "getBettDetail";
    //提现
    public static final String ACTION_DEPOSIT_RESULT = "deposit";
    //余额
    public static final String ACTION_BALANCE_RESULT = "getBalance";
    //邀请奖励
    public static final String ACTION_INVITEREWARD_RESULT = "inviteRewardPage";
    //交易流水
    public static final String ACTION_TRADING_RECORD_RESULT = "tradingRecord";
    //单点登录
    public static final String ACTION_DROP_RESULT = "drops";
    //关闭投注
    public static final String ACTION_BETTING_CLOSE_RESULT = "bettClose";
    //下一轮
    public static final String ACTION_NEXT_PLAY_RESULT = "nextPlay";
    //夺币购买通知
    public static final String ACTION_ROB_COIN_BUY = "robCoinBuy";
    //夺币开新奖期通知
    public static final String ACTION_ROB_COIN_CHANGE = "robCoinRecordChange";
    //开奖通知(robCoinOpen)
    public static final String ACTION_ROB_COIN_OPEN = "robCoinOpen";
    //重新发送激活邮件
    public static final String ACTION_RESEND_EMAIL = "resendEmail";
    //弹幕通知
    public static final String ACTION_BARRAGE = "barrage";


    public static Map<String, Class> ACTION_SUCCESS_MAP = new HashMap<>();
    public static Map<String, Class> ACTION_FAIL_MAP = new HashMap<>();

    static {
        ACTION_SUCCESS_MAP.put(ACTION_LOGIN, LoginResult.class);
        ACTION_SUCCESS_MAP.put(ACTION_REGISTER, RegisterResult.class);
        ACTION_SUCCESS_MAP.put(ACTION_SENDSMS, SendSmsResult.class);
        ACTION_SUCCESS_MAP.put(ACTION_MINE, MineResult.class);
        ACTION_SUCCESS_MAP.put(ACTION_HOME, HomeResult.class);
        ACTION_SUCCESS_MAP.put(ACTION_PLAY_RECORD, PlayRecordResult.class);
        ACTION_SUCCESS_MAP.put(ACTION_PLAY, PlayResult.class);
        ACTION_SUCCESS_MAP.put(ACTION_LINE_CHART, LineChartResult.class);
        ACTION_SUCCESS_MAP.put(ACTION_PLAY_STATUS_CHANGE, RecordEntity.class);
        ACTION_SUCCESS_MAP.put(ACTION_PLAY_BET_CHANGE, PlayResult.BettDetails.class);
        ACTION_SUCCESS_MAP.put(ACTION_PLAY_BUY, PlayBuyResult.class);
        ACTION_SUCCESS_MAP.put(ACTION_PLAY_BETT_RESULT, PlayBettResult.class);
        ACTION_SUCCESS_MAP.put(ACTION_RECHARGE_RESULT, RechargeResult.class);
        ACTION_SUCCESS_MAP.put(ACTION_WITHDRAWAL_RESULT, DepositRecordResult.class);
        ACTION_SUCCESS_MAP.put(ACTION_VERIFICATION_CODE_RESULT, VerificationCodeResult.class);
        ACTION_SUCCESS_MAP.put(ACTION_FORGET_PASSWORD_RESULT, ForgetPasswordResult.class);
        ACTION_SUCCESS_MAP.put(ACTION_WIN_PRIZE_RECORD_RESULT, WinPrizeResult.class);
        ACTION_SUCCESS_MAP.put(ACTION_WIN_PRIZE_DETAIL_RESULT, WinPrizeDetailResult.class);
        ACTION_SUCCESS_MAP.put(ACTION_CHANGE_PASSWORD_RESULT, ChangePasswordResult.class);
        ACTION_SUCCESS_MAP.put(ACTION_BETTING_RESULT, BettingResult.class);
        ACTION_SUCCESS_MAP.put(ACTION_BETTING_CLOSE_RESULT, BettingCloseResult.class);
        ACTION_SUCCESS_MAP.put(ACTION_BETTING_DETAIL_RESULT, BettingDetailResult.class);
        ACTION_SUCCESS_MAP.put(ACTION_DEPOSIT_RESULT, DepositResult.class);
        ACTION_SUCCESS_MAP.put(ACTION_BALANCE_RESULT, BalanceResult.class);
        ACTION_SUCCESS_MAP.put(ACTION_INVITEREWARD_RESULT, InviteRewardResult.class);
        ACTION_SUCCESS_MAP.put(ACTION_TRADING_RECORD_RESULT, TradingRecordResult.class);
        ACTION_SUCCESS_MAP.put(ACTION_DROP_RESULT, DropResult.class);
        ACTION_SUCCESS_MAP.put(ACTION_NEXT_PLAY_RESULT, RecordEntity.class);
        ACTION_SUCCESS_MAP.put(ACTION_ROB_COIN_BUY, RobCoinBuyResult.class);
        ACTION_SUCCESS_MAP.put(ACTION_ROB_COIN_CHANGE, RobCoinRecordChangeResult.class);
        ACTION_SUCCESS_MAP.put(ACTION_ROB_COIN_OPEN, RobCoinOpenResult.class);
        ACTION_SUCCESS_MAP.put(ACTION_RESEND_EMAIL, ReSendEmailResult.class);
        ACTION_SUCCESS_MAP.put(ACTION_BARRAGE, BarrageResult.class);


        ACTION_FAIL_MAP.put(ACTION_LOGIN, LoginFail.class);
        ACTION_FAIL_MAP.put(ACTION_REGISTER, RegisterFail.class);
        ACTION_FAIL_MAP.put(ACTION_SENDSMS, SendSmsFail.class);
        ACTION_FAIL_MAP.put(ACTION_MINE, MineFail.class);
        ACTION_FAIL_MAP.put(ACTION_HOME, HomeFail.class);
        ACTION_FAIL_MAP.put(ACTION_PLAY_RECORD, PlayRecordFail.class);
        ACTION_FAIL_MAP.put(ACTION_PLAY_BUY, PlayBuyFail.class);
        ACTION_FAIL_MAP.put(ACTION_CHANGE_PASSWORD_RESULT, ChangePasswordFail.class);
        ACTION_FAIL_MAP.put(ACTION_DEPOSIT_RESULT, DepositFail.class);
        ACTION_FAIL_MAP.put(ACTION_WIN_PRIZE_RECORD_RESULT, WinPrizeFail.class);
        ACTION_FAIL_MAP.put(ACTION_BETTING_DETAIL_RESULT, BettingFail.class);
        ACTION_FAIL_MAP.put(ACTION_FORGET_PASSWORD_RESULT, ForgetPasswordFail.class);
        ACTION_FAIL_MAP.put(ACTION_DROP_RESULT, DropFail.class);
        ACTION_FAIL_MAP.put(ACTION_INVITEREWARD_RESULT, InviteRewardFail.class);
        ACTION_FAIL_MAP.put(ACTION_RESEND_EMAIL, ReSendEmailFail.class);
        ACTION_FAIL_MAP.put(ACTION_BALANCE_RESULT, BalanceFail.class);
        ACTION_FAIL_MAP.put(ACTION_RECHARGE_RESULT, RechargeFail.class);

    }
}
