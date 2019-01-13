package com.niceapp.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import com.niceapp.R
import com.niceapp.base.actionbar.ActionBar
import com.niceapp.base.actionbar.StatusUtils
import com.niceapp.base.actionbar.StatusView
import com.cheddd.nqd.base.actionbar.ActionBarStyle
import com.umeng.analytics.MobclickAgent
import com.umeng.message.PushAgent
import com.umeng.socialize.utils.DeviceConfig.context
import rx.Subscription
import rx.subscriptions.CompositeSubscription
import solid.ren.skinlibrary.base.SkinBaseActivity


/**
 * Created by mateng on 2018/3/21.
 * Activity基类
 */
abstract class BaseActivity : SkinBaseActivity() {

    private val mAllSubscription = CompositeSubscription()
    private var contentLayout: ContentLayout? = null
    private var actionBar: ActionBar? = null
    private val mProgressDialog: ProgressDialog = ProgressDialog()
    private var disconnectDialog: DisconnectDialog = DisconnectDialog()
    private var mOpenTouchEventDelay: Boolean = true


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        ActivityManager.instance.addActivity(this)

        StatusUtils.setFullToStatusBar(this)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        mProgressDialog.isCancelable = false

        disconnectDialog.isCancelable = false

        initContentView()

        PushAgent.getInstance(context).onAppStart();

    }

    override fun onResume() {
        super.onResume()
        //友盟统计
        MobclickAgent.onResume(this)
    }

    override fun onPause() {
        super.onPause()
        //友盟统计
        MobclickAgent.onPause(this)
    }

    override fun onDestroy() {
        ActivityManager.instance.removeActivity(this)
        clearSubscription()
        super.onDestroy()
    }

    private fun initContentView() {
        val content: ViewGroup = findViewById(android.R.id.content)
        content.removeAllViews()
        actionBar = setActionBar(setActionBarStyle())
        contentLayout = ContentLayout(this)
        contentLayout?.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
        val rootView = LinearLayout(this)
        rootView.orientation = LinearLayout.VERTICAL

        rootView.addView(actionBar)
        rootView.addView(contentLayout)
        content.addView(rootView)
    }

    final override fun setContentView(view: View?, params: ViewGroup.LayoutParams?) {
        contentLayout?.setContentView(view)
    }

    final override fun setContentView(view: View?) {
        contentLayout?.setContentView(view)
    }

    final override fun setContentView(layoutResID: Int) {
        contentLayout?.setContentView(layoutResID)
    }


    /**
     * 设置ActionBar
     */
    open fun setActionBar(style: ActionBarStyle): ActionBar {
        val actionBar = ActionBar(this)
        actionBar.style = style
        actionBar.title = title
        return actionBar
    }

    override fun onStart() {
        super.onStart()
        findViewById<StatusView>(R.id.status_view).setBackgroundColor(ContextCompat.getColor(this, R.color.color_0000))
    }

    /**
     * 设置ActionBar样式
     */
    open fun setActionBarStyle(): ActionBarStyle {
        return ActionBarStyle.GENERIC_BAR
    }

    override fun setTitle(title: CharSequence?) {
        super.setTitle(title)
        actionBar?.title = title
    }

    override fun setTitle(titleId: Int) {
        super.setTitle(titleId)
        actionBar?.title = resources.getString(titleId)
    }

    fun showToast(msg: String?) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    fun showProgress() {
        if (mProgressDialog.dialog != null && mProgressDialog.dialog.isShowing) {
            //dialog is showing so do something
        } else {
            //dialog is not showing
            mProgressDialog.show(supportFragmentManager, javaClass.simpleName)
        }
    }

    fun hideProgress() {
        if (mProgressDialog.isAdded) {
            mProgressDialog.dismissAllowingStateLoss()
        }
    }

    fun showDisconnectDialog() {
        if (disconnectDialog.dialog != null && disconnectDialog.dialog.isShowing) {
            //dialog is showing so do something
        } else {
            //dialog is not showing
            disconnectDialog.show(supportFragmentManager, "dialog")
        }
    }

    fun hidDisconnectDialog() {
        if (disconnectDialog.isAdded) {
            disconnectDialog.dismissAllowingStateLoss()
        }
    }


    fun registerSubscription(subscription: Subscription) {
        mAllSubscription.add(subscription)
    }

    fun unregisterSubscription(subscription: Subscription) {
        mAllSubscription.remove(subscription)
    }

    private fun clearSubscription() {
        mAllSubscription.clear()
    }


//    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
//        if (ev != null) {
//            if (mOpenTouchEventDelay && ev.getAction() == MotionEvent.ACTION_DOWN) {
//                if (isFastDoubleClick()) {
//                    return true;
//
//                }
//            }
//        }
//        return super.dispatchTouchEvent(ev)
//    }
//
//    fun isFastDoubleClick(): Boolean {
//
//        val time = System.currentTimeMillis()
//        var mLastClickTime = 0L
//
//        val timeD = time - mLastClickTime
//        if (timeD >= 0 && timeD <= 500) {
//            return true
//        } else {
//            mLastClickTime = time
//            return false
//        }
//    }
//
//    protected fun openTouchDelay(open: Boolean) {
//        mOpenTouchEventDelay = open
//    }

}