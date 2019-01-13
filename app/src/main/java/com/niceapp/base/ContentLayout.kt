package com.niceapp.base

import android.content.Context
import android.support.annotation.LayoutRes
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout

/**
 * Created by mateng on 2018/3/21.
 * 内容容器，处理内容展示和网络错误和无数据等异常状态
 */
class ContentLayout : FrameLayout {

    private var connectionFail: View? = null
    private var contentView: View? = null

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    /**
     * 根据布局ID设置布局内容
     */
    fun setContentView(@LayoutRes layoutRes: Int) {
        setContentView(LayoutInflater.from(context).inflate(layoutRes, this, false))
    }

    /**
     * 根据View设置布局内容
     */
    fun setContentView(view: View?) {
        contentView = view
        addView(view)
    }

    /**
     * 网络连接失败
     */
    fun netConnectionFail(@LayoutRes layoutRes: Int) {
        netConnectionFail(connectionFail
                ?: LayoutInflater.from(context).inflate(layoutRes, this, false))
    }

    /**
     * 网络连接失败
     */
    fun netConnectionFail(view: View) {
        connectionFail = view
        removeAllViews()
        addView(connectionFail)
    }

    /**
     * 网络连接失败
     */
    fun netConnectionFail() {
        //默认错误界面

    }

    /**
     * 网络重新加载成功
     */
    fun reloadSuccess() {
        removeAllViews()
        addView(contentView)
    }

}