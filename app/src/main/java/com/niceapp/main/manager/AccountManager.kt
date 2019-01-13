package com.niceapp.view.user.manager

import com.niceapp.BaseApp
import com.niceapp.utils.PreferencesUtils

/**
 * Created by mateng on 2018/2/28.
 * 用户登录管理类
 */
object AccountManager {

    fun login(token: String?): Boolean {
        BaseApp.getApp()?.applicationContext?.let {
            return PreferencesUtils.putString(it, ACCOUNT_SP_KEY_TOKEN, token
                    ?: "", ACCOUNT_SP_NAME)
        }
        return false
    }

    fun logout() {
        BaseApp.getApp()?.applicationContext?.let {
            PreferencesUtils.remove(it, ACCOUNT_SP_KEY_TOKEN, ACCOUNT_SP_NAME)
        }
    }

    fun getToken(): String {
        BaseApp.getApp()?.applicationContext?.let {
            return PreferencesUtils.getString(it, ACCOUNT_SP_KEY_TOKEN, "--", ACCOUNT_SP_NAME)!!
        }
        return "--"
    }

    /**
     * 是否登录
     */
    fun isLogin(): Boolean {
        BaseApp.getApp()?.applicationContext?.let {
            return PreferencesUtils.getString(it, ACCOUNT_SP_KEY_TOKEN, null, ACCOUNT_SP_NAME) != null
        }
        return false
    }
}

