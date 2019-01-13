package com.niceapp.base

import android.os.Bundle
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import com.cheddd.nqd.base.actionbar.ActionBarStyle
import com.niceapp.base.actionbar.ActionBar
import solid.ren.skinlibrary.base.SkinBaseFragment

/**
 * Created by mateng on 2018/3/21.
 */
abstract class BaseFragment : SkinBaseFragment() {

    private var parentView: LinearLayout? = null
    private var contentLayout: ContentLayout? = null
    private var actionBar: ActionBar? = null
    private val mProgressDialog: ProgressDialog = ProgressDialog()
    private var textView = null
    private var disconnectDialog: DisconnectDialog = DisconnectDialog()

    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mProgressDialog.isCancelable = false
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        parentView = LinearLayout(context)
        parentView?.orientation = LinearLayout.VERTICAL
        parentView?.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)

        contentLayout = ContentLayout(context)
        contentLayout?.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)

        actionBar = setActionBar(setActionBarStyle())

        parentView?.addView(actionBar)
        parentView?.addView(contentLayout)

        return parentView
    }

    final override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    final override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        onCreated(savedInstanceState)
    }

    open fun onCreated(savedInstanceState: Bundle?) {}

    var title: String? = null
        set(value) {
            actionBar?.title = value
        }

    var titleColor: Int? = null
        set(value) {
            actionBar?.titleColor = value
        }


    var LeftImageVisible: Boolean? = null
        set(value) {
            if (value == true) {
                actionBar?.leftImageVisible = true
            } else if (value == false) {
                actionBar?.leftImageVisible = false
            }
        }

    fun setContentView(@LayoutRes layoutRes: Int) {
        contentLayout?.setContentView(layoutRes)
    }

    fun setContentView(view: View?) {
        contentLayout?.setContentView(view)
    }

    fun <T : View> findViewById(@IdRes id: Int): T? {
        return view?.findViewById(id)
    }


    /**
     * 设置ActionBar
     */
    open fun setActionBar(style: ActionBarStyle): ActionBar {
        val actionBar = ActionBar(context!!)
        actionBar.style = style
        return actionBar
    }

    /**
     * 设置ActionBar类型
     */
    open fun setActionBarStyle(): ActionBarStyle = ActionBarStyle.NONE


    /**
     * 弹出等待进度框
     */
    open fun showProgress() {
        if (mProgressDialog.dialog != null && mProgressDialog.dialog.isShowing) {
            //dialog is showing so do something
        } else {
            //dialog is not showing
            mProgressDialog.show(fragmentManager, javaClass.simpleName)
        }
    }

    /**
     * 收起等待网络进度框
     */
    open fun hideProgress() {
        if (mProgressDialog.isAdded) {
            mProgressDialog.dismissAllowingStateLoss()
        }
    }


    fun showDisconnectDialog() {
        if (disconnectDialog.dialog != null && disconnectDialog.dialog.isShowing) {
            //dialog is showing so do something
        } else {
            //dialog is not showing
            disconnectDialog.show(fragmentManager, javaClass.simpleName)
        }
    }

    fun hidDisconnectDialog() {
        if (disconnectDialog.isAdded) {
            disconnectDialog.dismissAllowingStateLoss()
        }
    }

    fun showToast(msg: String?) {
        Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
//        recyclerPresenter()
    }

//    /**
//     * 释放Presenter
//     */
//    open fun recyclerPresenter() {}


}